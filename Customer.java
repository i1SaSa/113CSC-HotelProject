public class Customer implements ComesWithDesignatedParking {
    private String name;
    private String phone;
    private String customerID;

    public Customer(String customerID, String name, String phone) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // Interface method — Customer gets a standard parking spot
    @Override
    public void assignParking() {
        System.out.println("Customer " + name + " has been assigned a standard parking spot.");
    }

    @Override
    public String toString() {
        return "Customer [ID=" + customerID + ", Name=" + name + ", Phone=" + phone + "]";
    }
}
