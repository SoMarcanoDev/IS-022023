import java.io.File;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class Date {
    int dd;
    int mm;
    int aaaa;
}

class Dispositivo {
    String desc;
    int ct;
    float mu;
    Date date;
    String nf;
    String ci;

    Dispositivo(String desc, int ct, float mu, Date date, String nf, String ci) {
        this.desc = desc;
        this.ct = ct;
        this.mu = mu;
        this.date = date;
        this.nf = nf;
        this.ci = ci;
    }
}

public class Inventario {

    static void loadDevices (List<Dispositivo> deviceList) {
        Date date = new Date();
        File inventario = new File("inventario.txt");
        try {
            Scanner Reader = new Scanner(inventario);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String[] parts = data.split("#");
                String[] dateParts = parts[3].split("/");
                date.dd = Integer.valueOf(dateParts[0]);
                date.mm = Integer.valueOf(dateParts[1]);
                date.aaaa = Integer.valueOf(dateParts[2]);

                Dispositivo device = new Dispositivo(parts[0], Integer.valueOf(parts[1]), Float.valueOf(parts[2]), date, parts[4], parts[5]);
                deviceList.add(device);
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }

    static void registerDevice(List<Dispositivo> deviceList, Scanner in) {
        String desc;
        int ct;
        float mu;
        Date date = new Date();
        String nf;
        String ci;

        System.out.println("Ingrese la descripcion: ");
        desc = in.nextLine();
        desc = in.nextLine();
        System.out.println("Ingrese la cantidad de equipos: ");
        ct = in.nextInt();
        System.out.println("Ingrese el precio unitario: ");
        mu = in.nextFloat();
        System.out.println("Ingrese la fecha de adquicision: ");
        date.dd = in.nextInt();
        date.mm = in.nextInt();
        date.aaaa = in.nextInt();
        System.out.println("Ingrese el numero de la factura: ");
        nf = in.nextLine();
        nf = in.nextLine();
        System.out.println("Ingrese la la cedula del profesor encargado: ");
        ci = in.nextLine();

        Dispositivo device = new Dispositivo(desc, ct, mu, date, nf, ci);
        deviceList.add(device);
    }

    static void saveDevices(List<Dispositivo> deviceList) {
        try {
            FileWriter inventoryWriter = new FileWriter("inventario.txt");
            for (int i=0; i < deviceList.size(); i++) {
                inventoryWriter.write(deviceList.get(i).desc + "#" + deviceList.get(i).ct 
                + "#" + deviceList.get(i).mu + "#" + deviceList.get(i).date.dd + "/" 
                + deviceList.get(i).date.mm + "/" + deviceList.get(i).date.aaaa + "#" 
                + deviceList.get(i).nf + "#" + deviceList.get(i).ci);
                inventoryWriter.write(System.getProperty( "line.separator" ));
            }
            inventoryWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
            
    }

    static void generateReport(List<Dispositivo> deviceList, Scanner in) {
        System.out.println("Ingrese la cedula del profesor: ");
        String ci;
        ci = in.nextLine();
        ci = in.nextLine();
        int ct = 0;
        float mu = 0;

        for (int i=0; i < deviceList.size(); i++) {

            if (ci.equals(deviceList.get(i).ci)) {
                ct = ct + deviceList.get(i).ct;
                mu = mu + deviceList.get(i).mu;
            }
        }

        System.out.println("Totalizacion: ");
        System.out.println(ct + " equipos.");
        System.out.println(mu + " Bs.");
    }
        

    public static void main(String[] args) throws Exception {
        List<Dispositivo> deviceList = new ArrayList<Dispositivo>();
        loadDevices(deviceList);

        Scanner sc = new Scanner(System.in);
        boolean done = false;
        int option = -1;

        new MainFrame();

        while (!done) {
            System.out.println("1. Registrar equipo.");
            System.out.println("2. Generar reporte.");
            System.out.println("3. Salir.");

            option = sc.nextInt();
            
            switch (option) {
                case 1: {
                    registerDevice(deviceList, sc);
                    break;
                }
                case 2: {
                    generateReport(deviceList, sc);
                    break;
                }
                default: {
                    done = true;
                    System.out.println("Adios");
                    break;
                }
            }
            
        }
        
        saveDevices(deviceList);
        
        sc.close();
    }
}