import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ticket extends JPanel
{
    Color col;
    String material;
    int price;
    String country;
    Ticket() {
    }

    //Конструктори
    Ticket(String a) {
        material = a;
    }

    Ticket(String a, int b) {
        material = a;
        price = b;
    }
    //Методи
    public void paint (Graphics g) {
        g.setColor(col);
        g.drawRect(10,15,price,50);
        g.drawString(material, 50, 10);
    }


}
