import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Main {
    static Plate bt;

    public static void main(String[] args) {
        JFrame frame=new JFrame("First");
        frame.setSize(400,600);
        frame.setLayout(null);
        JButton btn=new JButton("Button");
        frame.getContentPane().add(btn);
        JButton btna=new JButton("press Button");
        frame.getContentPane().add(btna);
        JButton btnb=new JButton("release Button");
        frame.getContentPane().add(btnb);
        JButton btnc=new JButton("size Button");
        frame.getContentPane().add(btnc);
        JButton btnd=new JButton("break Button");
        frame.getContentPane().add(btnd);
        JButton btne=new JButton("name Button");
        frame.getContentPane().add(btne);

        btn.setBounds(120, 10, 165,50);
        btna.setBounds(120, 70, 165,50);
        btnb.setBounds(120, 130, 165,50);
        btnc.setBounds(120, 190, 165,50);
        btnd.setBounds(120, 250, 165,50);
        btne.setBounds(120, 310, 165,50);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                bu = new Button();
                System.out.println("object is created");
            }
        });
        btna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("press:" + bu.pressed );
                bu.press();
                System.out.println("press:" + bu.pressed);
            }
        });
        btnb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("pressed:" + bu.pressed );
                bu.release();
                System.out.println("pressed:" + bu.pressed);
            }
        });
        btnc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("size:" + bu.getSize());
            }
        });
        btnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("broken:" + bu.broken );
                System.out.println("pressed:" + bu.pressed );

                bu.breakButton();
                System.out.println("broken:" + bu.broken);
                System.out.println("pressed:" + bu.pressed );

            }
        });
        btne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("name:" + bu.getName());
            }
        });
        frame.setVisible(true);
    }
}


public class Plate {
    int size;
    String name;
    String color;
    boolean pressed;
    boolean broken;

    void press() {
        pressed = true;
    }

    void release() {
        pressed = false;
    }

    void breakButton() {
        broken = true;
        pressed = false;
    }

    int getSize(){
        return size;
    }

    String getColor() {
        return color;
    }

    String getName() {
        return name;
    }
}

