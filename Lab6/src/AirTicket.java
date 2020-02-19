import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


class AirTicket extends Ticket{

    int planeNumber;
    int airplaneSeatNumber;
    boolean hasRestaurant;

    AirTicket(int price, String depotStation){
        super(price,depotStation);
    }
    AirTicket(int departureTime){
        super(departureTime);
    }
    AirTicket(int departureTime, int planeNumber, int airplaneSeatNumber){
        super(departureTime);
        this.planeNumber = planeNumber;
        this.airplaneSeatNumber =  airplaneSeatNumber;
    }
    AirTicket(String depotStation, int departureTime, int price, int planeNumber, int airplaneSeatNumber){
        super(departureTime,depotStation);
        this.price = price;
        this.planeNumber = planeNumber;
        this.airplaneSeatNumber = airplaneSeatNumber;

    }
    AirTicket(String departureTime, boolean hasRestaurant){
        super(departureTime);
        this.hasRestaurant = hasRestaurant;
    }
    void setNumber(int planeNumber){
        this.planeNumber = planeNumber;
    }
    void setAirplaneSeatNumber(int airplaneSeatNumber){
        this.airplaneSeatNumber = airplaneSeatNumber;
    }
    void setHasRestaurant(boolean hasRestaurant){
        this.hasRestaurant = hasRestaurant;
    }
    void setTicketData(ArrayList param){
        this.departurePlace= (String) param.get(0);
        this.departureTime= (int)  param.get(1);
        this.price=(int) param.get(2);
        this.planeNumber=(int)param.get(3);
        this.airplaneSeatNumber=(int)param.get(4);
    }
    int getNumber(){
        return planeNumber;
    }
    int getAirplaneSeatNumber(){
        return airplaneSeatNumber;
    }
    boolean isHasRestaurant(){
        return hasRestaurant;
    }

    @Override
    String getTicketData() {
        return "Клас: "+departurePlace + "\n Ціна: "+  price +"\n Час відправлення: "+ departureTime + "\n Номер літаку: "+ planeNumber+ "\n Номер місця: "+airplaneSeatNumber;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(10, 20, 200, 150);
        if(MainWindow.hasRestaurantBoolean == true){
            g.setColor(Color.GRAY);
            g.fillRect(10, 20, 30, 150);
        }
    }
}
