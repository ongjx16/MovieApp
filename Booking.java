import java.io.Serializable;

public class Booking implements Serializable {
    private String name; 
    private String email; 
    private long contactno;
    private float totalPrice;
    private String TXNid;
    private String movieDate;
    private String movieTime;

    public Booking(){}
    public Booking(String name, String email, long contactno, float totalPrice, String TXNid, String movieDate, String movieTime){
        this.name=name;
        this.email=email;
        this.contactno=contactno;
        this.totalPrice=totalPrice;
        this.TXNid=TXNid;
        this.movieDate=movieDate;
        this.movieTime=movieTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTXNid() {
        return TXNid;
    }

    public void setTXNid(String TXNid) {
        this.TXNid = TXNid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}

