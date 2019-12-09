import java.awt.*;
import java.util.Date;

class AirTicket extends Ticket {
    Date arrivalTime;
    Date departureTime;
    String arrivalPlace;
    String departurePlace;


    //Конструктори
    AirTicket(Date arrivalTime, int price, Date departureTime, String arrivalPlace, String departurePlace) {
        super("Spain");
        this.price = price;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.arrivalPlace = arrivalPlace;
        this.departurePlace = departurePlace;
    }
    AirTicket(int price, Date arrival_time, String arrivalPlace)
    {
        super("Spain");
        this.price = price;
        this.arrivalTime = arrivalTime;
        this.arrivalPlace = arrivalPlace;

    }

    @Override
    public void paint (Graphics g)
    {
        g.drawOval(20, price, ""+ arrivalPlace, ""+ departurePlace,);
    }

    public void DrawWindowAirTicket() {
    }
}

