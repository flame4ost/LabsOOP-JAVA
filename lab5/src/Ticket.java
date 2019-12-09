import javax.swing.*;
import java.awt.*;

class Ticket extends JPanel {
    Color color;
    String material;
    int price;
    String country;
    int number;

    Ticket(String spain) {
    }

    //Конструктори
    Ticket(String material, String country) {
        this.material = material;
        this.country = country;
    }

    Ticket(String material, int price) {
        this.material = material;
        this.price = price;
    }
    //Методи
    public void paint (Graphics g) {
        g.setColor(color);
        g.drawRect(10,15,  price,50);
        g.drawString(""+number, 50, 10);
    }


    public void DrawWindowTicket() {
    }
}
