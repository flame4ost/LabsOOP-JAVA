import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AirTicket extends Ticket {
    protected String departurePlace;
    protected String arrivalPlace;
    protected Date launchTime;


    public AirTicket(String id, double ticketPrice, String departurePlace, String arrivalPlace, Date launchTime) {
        super(id, ticketPrice);
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.launchTime = launchTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public Date getLaunchTime() {
        return launchTime;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }

    public void setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
    }

    public void paint(Graphics g) {
        g.drawRoundRect(10, 10, 100, 100, 30, 30);
        g.drawString(id, 20, 35);
        g.drawString(""+price+ " грн.", 20, 55);
        g.drawString(departurePlace + " - " + arrivalPlace, 20, 75);
        g.drawString((String.valueOf(launchTime)), 20, 95);
    }

    public String getFullInfo() {
        return "TicketPrice: " + price + "\n" + "DeparturePlace: " + departurePlace + "\n" + "ArrivalPlace: " + "\n" + "LaunchTime: " + "\n";
    }


}
