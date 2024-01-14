import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PlaceholderTextField extends JPanel implements FocusListener {
    Palette color = new Palette();
    String str;
    Border border;
    Border outside;
    Border inside;
    JLabel icon;
    ImageIcon imageIcon;
    JTextField textField;
    
    PlaceholderTextField(String str, String iconFilename) {
        
        imageIcon = new ImageIcon(iconFilename);
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        icon = new JLabel();
        icon.setPreferredSize(new Dimension(35,35));
        icon.setIcon(imageIcon);
        // icon.setBackground(color.gray);
        // icon.setOpaque(true);

        this.str = str;
        
        inside = BorderFactory.createEmptyBorder(0, 0, 0, 0);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(265,35));
        textField.setText(this.str);
        textField.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
        textField.setForeground(color.lightGray);
        textField.setBackground(color.offWhite);
        textField.addFocusListener(this);
        textField.setBorder(inside);

        outside = BorderFactory.createLineBorder(color.lightGray, 2);
        border = BorderFactory.createCompoundBorder(outside, inside);

        this.setPreferredSize(new Dimension(314,48));
        this.setBorder(border);
        this.setBackground(color.offWhite);
        this.add(icon);
        this.add(textField);
        
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textField.getText().equals(str)) {
            textField.setText("");
            textField.setForeground(color.black);
            icon.setVisible(false);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textField.getText().isEmpty()) {
            textField.setForeground(color.lightGray);
            textField.setText(str);
            icon.setVisible(true);
        }
    }
}
