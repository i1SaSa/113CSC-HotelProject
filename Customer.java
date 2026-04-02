public class Customer implements ComesWithDesignatedParking {
    private String name;
    private String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public void assignParking() {
        System.out.println("Customer " + name + " has been assigned a standard parking spot.");
    }

    @Override
    public String toString() {
        return "Customer [Name=" + name + ", Phone=" + phone + "]";
    }
}
