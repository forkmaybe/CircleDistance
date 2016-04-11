package flatten;

/**
 *
 * @author luke
 */
public class Customer implements Comparable<Customer> {

    private double latitude;
    private Integer user_id;
    private String name;
    private double longitude;
    private boolean withinOneHundredKm;

    public Customer(double latitude, Integer user_id, String name, double longitude) {
        this.latitude = latitude;
        this.user_id = user_id;
        this.name = name;
        this.longitude = longitude;
        withinOneHundredKm = false;
    }

    public void calcDistance() {
        double x1 = Math.toRadians(53.3381985);//latitude
        double y1 = Math.toRadians(-6.2592576);//longitude
        double x2 = Math.toRadians(this.latitude);
        double y2 = Math.toRadians(this.longitude);

        // great circle distance in radians
        double angle1 = Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        // convert back to degrees
        angle1 = Math.toDegrees(angle1);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance = 60 * angle1;
        distance = 1.609344 * distance;

        if (distance <= 100) {
            this.setWithinOneHundredKm(true);
        }
    }

    public boolean isWithinOneHundredKm() {
        return withinOneHundredKm;
    }

    public void setWithinOneHundredKm(boolean withinOneHundredKm) {
        this.withinOneHundredKm = withinOneHundredKm;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public int compareTo(Customer o) {
        if (user_id < o.getUser_id()) {
            return -1;
        }
        if (user_id > o.getUser_id()) {
            return 1;
        }
        return 0;
    }

}
