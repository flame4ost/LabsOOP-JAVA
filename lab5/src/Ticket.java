import javax.swing.*;
import java.awt.*;

public class Ticket extends JPanel {

    protected double price;
    protected String id;

    public Ticket(String id, double ticketPrice){
        this.price = ticketPrice;
        this.id = id;

    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void paint (Graphics g){
        g.drawRect(10,10,100,100);
        g.drawString(id, 20, 50);
        g.drawString(""+price+ " грн.", 20, 70);
    }
}

