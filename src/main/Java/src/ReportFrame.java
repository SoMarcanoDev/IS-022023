import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReportFrame extends JFrame implements ActionListener {
    JLabel typeLabel = new JLabel();
    JButton continueButton;
    MainFrame mainFrame;
    JPanel individualReportPanel;
    JPanel generalReportPanel;
    JTextField ciTextField;
    ButtonGroup group;
    JRadioButton individualButton;
    JRadioButton generalButton;
    JButton totalButton;
    JTextArea generalReport;
    JScrollPane generalReportScroll;

    ReportFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        typeLabel.setText("Tipo reporte: ");
        typeLabel.setVerticalAlignment(JLabel.TOP);
        typeLabel.setBounds(10,10,200,25);

        individualButton = new JRadioButton("Individual");
        individualButton.setBounds(100, 10, 100, 25);
        individualButton.setFocusable(false);
        individualButton.addActionListener(this);

        generalButton = new JRadioButton("General");
        generalButton.setFocusable(false);
        generalButton.setBounds(200, 10, 100, 25);
        generalButton.addActionListener(this);

        group = new ButtonGroup();
        group.add(individualButton);
        group.add(generalButton);

        JLabel ciLabel = new JLabel("C.I. del Responsable del equipo: ");
        ciLabel.setBounds(10,0,400,25);

        ciTextField = new JTextField();
        ciTextField.setBounds(200, 0, 300, 25);

        totalButton = new JButton("Totalizar");
        totalButton.setFocusable(false);
        totalButton.setBounds(550, 0 , 80, 25);
        totalButton.setFont(new Font(null, Font.PLAIN, 10));

        individualReportPanel = new JPanel();
        individualReportPanel.setBounds(0, 50, 660, 250);
        individualReportPanel.setLayout(null);
        individualReportPanel.setVisible(false);

        individualReportPanel.add(ciLabel);
        individualReportPanel.add(ciTextField);
        individualReportPanel.add(totalButton);

        generalReport = new JTextArea();
        generalReport.setText("                         C.I. Responsable                               Cantidad equipos                            Monto total(Bs.)");
        generalReport.setEditable(false);

        generalReportScroll = new JScrollPane(generalReport);
        generalReportScroll.setBounds(15, 10, 615, 200);
        
        generalReportPanel = new JPanel();
        generalReportPanel.setBounds(0, 50, 660, 250);
        generalReportPanel.setLayout(null);
        generalReportPanel.setVisible(false);

        // generalReportPanel.add(generalReport);
        generalReportPanel.add(generalReportScroll);

        JLabel totalLabel = new JLabel("<html>Totalizacion: <br/>__ equipos <br/> ________ Bs. </html>");
        totalLabel.setBounds(30, 300, 100, 75);

        continueButton = new JButton();
        continueButton.setBounds(550, 345, 80, 25);
        continueButton.addActionListener(this);
        continueButton.setText("Continuar");
        continueButton.setFocusable(false);
        continueButton.setFont(new Font(null, Font.PLAIN, 10));


        this.setTitle("Reporte del Inventario del Centro de Investigacion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(660, 420);
        this.setLayout(null);
        this.setVisible(true);

        this.add(typeLabel);
        this.add(individualButton);
        this.add(generalButton);
        this.add(individualReportPanel);
        this.add(generalReportPanel);
        this.add(totalLabel);
        this.add(continueButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            this.dispose();
            mainFrame.setVisible(true);
        }
        if (e.getSource() == individualButton) {
            individualReportPanel.setVisible(true);
            generalReportPanel.setVisible(false);
        }
        if (e.getSource() == generalButton) {
            individualReportPanel.setVisible(false);
            generalReportPanel.setVisible(true);
        }
    }
}
