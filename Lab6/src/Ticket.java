import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ticket extends JPanel {

    String departurePlace;
    int departureTime;
    int price;
    int ticketNumber;



    Ticket(int ticketNumber){
        this.ticketNumber = ticketNumber;
    }
    Ticket(String departurePlace){
        this.departurePlace = departurePlace;
    }
    Ticket(int departureTime,String departurePlace){
        this(departurePlace);
        this.departureTime = departureTime;
    }
    Ticket(String departurePlace,int price,int departureTime){
        this(departurePlace);
        this.price = price;
        this.departureTime= departureTime;
    }

    void setDeparturePlace(String departurePlace){
        this.departurePlace = departurePlace;
    }
    void setDepartureTime(int departureTime){
        this.departureTime = departureTime;
    }
    void setPrice(int price){
        this.price = price;
    }
    void setTicketData(ArrayList param){
        this.departurePlace = (String) param.get(0);
        this.departureTime = (int) param.get(1);
        this.price = (int) param.get(2);

    }
    void setNumber(int ticketNumber){
        this.ticketNumber = ticketNumber;
    }
    int getNumber(){
        return ticketNumber;
    }

    String getDepotPlace(){
        return departurePlace;
    }
    int getDepartureTime(){
        return departureTime;
    }
    int getPrice(){
        return price;
    }
    String getTicketData(){
        return "Клас: "+departurePlace +"\n Ціна: "+  price + "\n Час відправлення: "+ departureTime ;
    }
    @Override
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(10, 20, 200, 150);
    }
}


