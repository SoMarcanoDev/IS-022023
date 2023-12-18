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
    static List<Dispositivo> deviceList;
    List<String> generalReportList;
    List<String> ciList;

    static void loadDevices () {
        File inventario = new File("inventario.txt");
        try {
            Scanner Reader = new Scanner(inventario);
            while (Reader.hasNextLine()) {
                Date date = new Date();
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

    void registerDevice(String desc, String count, String unitPrice, String dateFull, String nf, String ci) {
        
        int ct = Integer.valueOf(count);
        float mu = Float.valueOf(unitPrice);
        Date date = new Date();
        String[] dateParts = dateFull.split("/");
        date.dd = Integer.valueOf(dateParts[0]);
        date.mm = Integer.valueOf(dateParts[1]);
        date.aaaa = Integer.valueOf(dateParts[2]);

        Dispositivo device = new Dispositivo(desc, ct, mu, date, nf, ci);
        deviceList.add(device);
    }

    void saveDevices() {
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

    String generateIndividualReport(String ci) {
        int ct = 0;
        float mu = 0;
        String result;

        for (int i=0; i < deviceList.size(); i++) {

            if (ci.equals(deviceList.get(i).ci)) {
                ct = ct + deviceList.get(i).ct;
                mu = mu + deviceList.get(i).mu;
            }
        }

        result = "<html>Totalizacion: <br/>" + ct + " equipos <br/>" + mu +" Bs. </html>";

        return result;
    }

    String generateGeneralReport() {
        int ct = 0;
        float mu = 0;
        String result;

        for (int i=0; i < deviceList.size(); i++) {
            ct = ct + deviceList.get(i).ct;
            mu = mu + deviceList.get(i).mu;
        }

        result = "<html>Totalizacion: <br/>" + ct + " equipos <br/>" + mu +" Bs. </html>";

        return result;
    }
    
    boolean isNotCount(String ci) {
        for (int i=0; i < ciList.size(); i++) {
            if (ci.equals(ciList.get(i))) {
                return false;
            }
        }

        return true;
    }

    void generateGeneralReportList () {
        ciList = new ArrayList<String>();
        generalReportList = new ArrayList<String>();
        int ct = 0;
        float mu = 0;
        String space = "                         ";
        

        for (int i=0; i < deviceList.size(); i++) {
            if (isNotCount(deviceList.get(i).ci)) {
                String ci = new String();
                ci = deviceList.get(i).ci;
                ciList.add(ci);
                for (int j = i; j < deviceList.size(); j ++){
                    if (ci.equals(deviceList.get(j).ci)) {
                    ct = ct + deviceList.get(j).ct;
                    mu = mu + deviceList.get(j).mu;
                    }
                }
                String result = space + ci + space + space + ct + space + space + mu;
                generalReportList.add(result);
                ct = 0;
                mu = 0;
            }
        }

    }

    Inventario() {
        deviceList = new ArrayList<Dispositivo>();
        loadDevices();
    }
    
}