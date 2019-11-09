import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AirTicket extends Ticket
{
    int price;
    int length;
    int time;

    //Конструктори
    AirTicket(int i, int a, int b)
    {
        price = a;
        length = b;
        time = i;
    }
    AirTicket(int a, int b)
    {
        price = a;
        time = b;
        length = a * b;
    }
    @Override
    public void paint (Graphics g)
    {
        g.drawOval(20, price, time, length);
    }
    void DrawWindowAirTicket()
    {
        JFrame SetWin = new JFrame("Setting air_ticket");
        GridLayout gbl = new GridLayout(4,1);
        SetWin.setLayout(gbl);
        SetWin.setLocation(0,350);

        JTextField  pric = new JTextField();
        JTextField  leng = new JTextField();
        JTextField  tim = new JTextField();
        JLabel lprice = new JLabel("Price:");
        JLabel lleng = new JLabel("Time:");
        JLabel ltim = new JLabel("Length:");
        JButton apply = new JButton("Apply");

        SetWin.getContentPane().add(lprice);
        SetWin.getContentPane().add(pric);
        SetWin.getContentPane().add(lleng);
        SetWin.getContentPane().add(leng);
        SetWin.getContentPane().add(ltim);
        SetWin.getContentPane().add(tim);
        SetWin.getContentPane().add(apply);
        SetWin.setVisible(true);
        SetWin.setSize(500,300);

       apply.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
       price = Integer.parseInt(pric.getText());
       length= Integer.parseInt(leng.getText());
       time = Integer.parseInt(tim.getText());
         }
        }
        );
    }




}
