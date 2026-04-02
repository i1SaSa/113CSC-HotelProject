
import java.time.*;

public abstract  class reservation {
protected customer guest;
protected String resID;
protected LocalDate date;
protected int price;
protected char status;
//possible status: A (active), R (refunded), C (cancelled), I (In progress)

public reservation(String resID, int day,int month,int year, int price, customer guest) {
    this.resID = resID;
    this.date = LocalDate.of(year, month, day);
    this.price = price;
    this.status = 'I';
    this.guest = guest;
}
public String getResID() {
    return resID;
}
public char getStatus() {
    return status;
}
public void setStatus(char status) {
    status = Character.toUpperCase(status);
this.status = status;
    if ("ARCF".indexOf(status) == -1) {
        this.status = 'R';
        System.out.println("Invalid status. Status set to 'R' (refunded) by default.");
    }
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
    if (date.isBefore(LocalDate.now())) {
        this.date = LocalDate.now();
        System.out.println("Error: Date cannot be in the past. Date set to today by default.");
    }
      
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
