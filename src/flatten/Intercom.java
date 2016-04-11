package flatten;

import java.io.*;

/**
 *
 * @author luke
 */
public class Intercom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Intercom m = new Intercom();
        m.run();
    }

    public void run() {
        String jsonData = "";
        BufferedReader br = null;
        Party p = new Party();
        try {
            String line;
            br = new BufferedReader(new FileReader("gistfile1.txt"));
            while ((line = br.readLine()) != null) {
                p.addCustomer(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        p.getAllWithinDistance();
    }
}
