package http;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private int stationMetro;
    private String phone;
    private int rentTime;
    private String delivery;
    private String comment;
    private String[] color;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStationMetro() {
        return stationMetro;
    }

    public void setStationMetro(int stationMetro) {
        this.stationMetro = stationMetro;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public Order(String firstName, String lastName, String address, int stationMetro, String phone, int rentTime, String delivery, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.stationMetro = stationMetro;
        this.phone = phone;
        this.rentTime = rentTime;
        this.delivery = delivery;
        this.comment = comment;
        this.color = color;
    }
}
