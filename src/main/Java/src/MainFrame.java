import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {
    Inventario inventory = new Inventario();
    JButton registerData;
    JButton generateReport;
    JButton exit;
    JTextField descTextField;
    JTextField ctTextField;
    JTextField muTextField;
    JTextField dateTextField;
    JTextField nfTextField;
    JTextField ciTextField;


    MainFrame() {
        JLabel headerLabel = new JLabel("Ingrese data del equipo: ");
        headerLabel.setBounds(10,10,200,25);

        JLabel descLabel = new JLabel("Descripcion: ");
        descLabel.setBounds(10,50,200,25);

        descTextField = new JTextField();
        descTextField.setBounds(100, 50, 525, 25);

        JLabel ctLabel = new JLabel("Cantidad: ");
        ctLabel.setBounds(10,90,100,25);

        ctTextField = new JTextField();
        ctTextField.setBounds(100, 90, 50, 25);

        JLabel muLabel = new JLabel("Costo unitario (Bs.): ");
        muLabel.setBounds(300, 90, 200, 25);

        muTextField = new JTextField();
        muTextField.setBounds(425, 90, 200, 25);

        JLabel dateLabel = new JLabel("<html>Fecha de adquisicion: <br/>dd/mm/aaaa</html>");
        dateLabel.setBounds(10, 130, 200, 25);

        dateTextField = new JTextField();
        dateTextField.setBounds(150, 130, 120, 25);

        JLabel nfLabel = new JLabel("Nro. de Factura: ");
        nfLabel.setBounds(330, 130, 200, 25);

        nfTextField = new JTextField();
        nfTextField.setBounds(435, 130, 190, 25);

        JLabel ciLabel = new JLabel("C.I. del Responsable del equipo: ");
        ciLabel.setBounds(10, 170, 400, 25);

        ciTextField = new JTextField();
        ciTextField.setBounds(200, 170, 120, 25);

        registerData = new JButton();
        registerData.setBounds(335, 345, 100, 25);
        registerData.addActionListener(this);
        registerData.setText("Registrar data");
        registerData.setFocusable(false);
        registerData.setFont(new Font(null, Font.PLAIN, 10));

        generateReport = new JButton();
        generateReport.setBounds(445, 345, 108, 25);
        generateReport.addActionListener(this);
        generateReport.setText("Generar reporte");
        generateReport.setFocusable(false);
        generateReport.setFont(new Font(null, Font.PLAIN, 10));

        exit = new JButton();
        exit.setBounds(565, 345, 60, 25);
        exit.addActionListener(this);
        exit.setText("Salir");
        exit.setFocusable(false);
        exit.setFont(new Font(null, Font.PLAIN, 10));


        this.setTitle("Registro y Control de Equipos en Centro de Investigacion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(660, 420);
        this.setLayout(null);
        this.setVisible(true);

        this.add(headerLabel);
        this.add(descLabel);
        this.add(descTextField);
        this.add(ctLabel);
        this.add(ctTextField);
        this.add(muLabel);
        this.add(muTextField);
        this.add(dateLabel);
        this.add(dateTextField);
        this.add(nfLabel);
        this.add(nfTextField);
        this.add(registerData);
        this.add(ciLabel);
        this.add(ciTextField);
        this.add(generateReport);
        this.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerData){
            inventory.registerDevice(descTextField.getText(), ctTextField.getText(), muTextField.getText(), dateTextField.getText(), nfTextField.getText(), ciTextField.getText());
        } else if(e.getSource() == generateReport){
            this.setVisible(false);
            new ReportFrame(this, inventory);
        } else if (e.getSource() == exit) {
            inventory.saveDevices();
            System.exit(0);
        }
    }
}
