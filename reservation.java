
import java.time.*;

public abstract  class reservation {
    protected customer guest;
protected String resID;
protected LocalDate date;

protected int price;
protected char status;


public reservation(String resID, int day,int month,int year, int price, customer guest) {
    this.resID = resID;
    this.date = LocalDate.of(year, month, day);
    this.price = price;
    this.status = 'R';
    this.guest = guest;
}
public String getResID() {
    return resID;
}
public char getStatus() {
    return status;
}
public void setStatus(char status) {
    this.status = status;
}
public void setResID(String resID) {
    this.resID = resID;
}

public customer getGuest() {
    return guest;
}
public LocalDate getDate() {
    return date;
}
public void setDate(LocalDate date) {
    this.date = date;
}
public void setGuest(customer guest) {
    this.guest = guest;
}


public int getPrice() {
    return price;
}
public void setPrice(int price) {
    this.price = price;
}


abstract int calculatePrice();

}
