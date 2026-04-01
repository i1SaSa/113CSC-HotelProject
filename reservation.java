



public abstract  class reservation {
protected String resID;
protected Date date;
protected int price;
protected boolean isreserved;
public reservation(String resID, int day,int month,int year, int price) {
    this.resID = resID;
    this.date = new Date( day,  month,  year) ;
    this.price = price;
    this.isreserved = true;
}
public String getResID() {
    return resID;
}
public void setResID(String resID) {
    this.resID = resID;
}
public String getDate() {
    return date.getDate();
}
public void setDate(int day,int month,int year) {
    date.setDay( day);
     date.setMonth( month);
     date.setYear( year);
}
public int getPrice() {
    return price;
}
public void setPrice(int price) {
    this.price = price;
}
public boolean isIsreserved() {
    return isreserved;
}
public void setIsreserved(boolean isreserved) {
    this.isreserved = isreserved;
}
abstract int calculatePrice();

}
