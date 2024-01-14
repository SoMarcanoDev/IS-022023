import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login extends JFrame {
    Palette color = new Palette();

    JPanel titlePanel;
    JPanel loginPanel;
    JPanel topBorder;
    JPanel bottomBorder;
    JPanel leftBorder;
    JPanel rightBorder;
    JPanel infoContainer;
    JPanel line;
    JPanel buttonContainer;
    
    JLabel titleLabel;
    JLabel registerUserLabel;
    JLabel registerTextLabel;

    PlaceholderTextField userTextField;
    PlaceholderTextField emailTextField;
    PlaceholderTextField passwordTextField;
    
    JButton cancelButton;
    JButton registerButton;

    

    Login () {
        this.setVisible(true);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1024, 720));
        this.setSize(1024, 720);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // this.getContentPane().setBackground(Color.blue);
        

        titlePanel = new JPanel();
        titlePanel.setBackground(color.gray);
        titlePanel.setPreferredSize(new Dimension(546,720));
        titlePanel.setLayout(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setText("TéchneLogic");
        titleLabel.setFont(new Font("Nunito Sans", Font.BOLD, 50));
        titleLabel.setForeground(color.white);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        titlePanel.add(titleLabel, BorderLayout.CENTER);

        loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(478,720));
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setMinimumSize(new Dimension(478,678));
        // loginPanel.setBackground(white);

        infoContainer = new JPanel();
        infoContainer.setPreferredSize(new Dimension(478,478));
        infoContainer.setBackground(color.white);
        infoContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        // infoContainer.setLayout(new BoxLayout(infoContainer, BoxLayout.Y_AXIS));

        topBorder = new JPanel();
        topBorder.setPreferredSize(new Dimension(478,135));
        topBorder.setBackground(color.white);

        bottomBorder = new JPanel();
        bottomBorder.setPreferredSize(new Dimension(478,135));
        bottomBorder.setBackground(color.white);

        leftBorder = new JPanel();
        leftBorder.setPreferredSize(new Dimension(80,135));
        leftBorder.setBackground(color.white);

        rightBorder = new JPanel();
        rightBorder.setPreferredSize(new Dimension(80,135));
        rightBorder.setBackground(color.white);

        registerUserLabel = new JLabel();
        registerUserLabel.setText("Registrar Usuario");
        registerUserLabel.setFont(new Font("Nunito Sans", Font.PLAIN, 35));
        registerUserLabel.setHorizontalAlignment(JLabel.CENTER);

        registerTextLabel = new JLabel();
        registerTextLabel.setText("<html>Ingrese los datos para registrar a<br/>un nuevo usuario en TéchneLogic</html>");
        registerTextLabel.setFont(new Font("Nunito Sans", Font.PLAIN, 20));
        registerTextLabel.setHorizontalAlignment(JLabel.CENTER);

        line = new JPanel();
        line.setPreferredSize(new Dimension(478,2));
        line.setBackground(color.lightGray);

        userTextField = new PlaceholderTextField("Usuario", "User_Icon.png");

        emailTextField = new PlaceholderTextField("Correo electronico", "Mail_Icon.png");
        
        passwordTextField = new PlaceholderTextField("Contraseña", "Lock_Icon.png");

        buttonContainer = new JPanel();
        buttonContainer.setPreferredSize(new Dimension(478,44));
        buttonContainer.setBackground(color.white);
        buttonContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));

        cancelButton = new JButton();
        cancelButton.setPreferredSize(new Dimension(148, 42));
        cancelButton.setText("Cancelar");
        cancelButton.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
        cancelButton.setBackground(color.black);
        cancelButton.setForeground(color.white);
        cancelButton.setFocusable(false);

        registerButton = new JButton();
        registerButton.setPreferredSize(new Dimension(148, 42));
        registerButton.setText("Registrar");
        registerButton.setFont(new Font("Nunito Sans", Font.PLAIN, 17));
        registerButton.setBackground(color.black);
        registerButton.setForeground(color.white);
        registerButton.setFocusable(false);

        buttonContainer.add(cancelButton);
        buttonContainer.add(registerButton);

        // infoContainer.add(Box.createVerticalGlue());
        infoContainer.add(registerUserLabel);
        infoContainer.add(registerTextLabel);
        infoContainer.add(line);
        infoContainer.add(userTextField);
        infoContainer.add(emailTextField);
        infoContainer.add(passwordTextField);
        infoContainer.add(buttonContainer);
        

        loginPanel.add(topBorder, BorderLayout.NORTH);
        loginPanel.add(bottomBorder, BorderLayout.SOUTH);
        loginPanel.add(leftBorder, BorderLayout.WEST);
        loginPanel.add(rightBorder, BorderLayout.EAST);
        loginPanel.add(infoContainer, BorderLayout.CENTER);
        

        this.add(titlePanel);
        this.add(loginPanel);
    }
}
