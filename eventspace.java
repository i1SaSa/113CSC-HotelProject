public abstract  class eventspace extends reservation {
    protected int maxCapacity;
    protected int size;
  public eventspace(String resID, int day, int month, int year, int price, int maxCapacity, int size) {
        super(resID, day, month, year, price);
        this.maxCapacity = maxCapacity;
        this.size = size;
    }

 
}
