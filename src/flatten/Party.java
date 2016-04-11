package flatten;

import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author luke
 */
public class Party {

    private ArrayList<Customer> customers;

    public Party() {
        customers = new ArrayList<Customer>();
    }

    public Party(ArrayList<Customer> customers) {
        customers = new ArrayList<Customer>();
    }

    public void getAllWithinDistance() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).isWithinOneHundredKm()) {
                list.add(customers.get(i));
            }
        }
        Collections.sort(list);//sort asc
        this.getAllWithinDistanceOutput(list);
    }

    public void getAllWithinDistanceOutput(ArrayList<Customer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).getName() + " " + a.get(i).getUser_id());
        }
    }

    public void addCustomer(String c) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(c);
            JSONObject jso = (JSONObject) obj;

            //cast variables to correct type
            double latitude = Double.parseDouble(jso.get("latitude").toString());
            int id = Integer.parseInt(jso.get("user_id").toString());
            String name = (String) jso.get("name");
            double longitude = Double.parseDouble(jso.get("longitude").toString());

            //construct customer & add to list
            Customer customer = new Customer(latitude, id, name, longitude);
            customer.calcDistance();//set within 100km
            customers.add(customer);
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }
}
