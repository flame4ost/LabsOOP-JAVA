import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

class Main {
    static Plate plate;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plate #2");
        frame.setSize(400, 600);
        frame.setLayout(null);
        JButton btn = new JButton("Create Plate");
        frame.getContentPane().add(btn);
        JButton btna = new JButton("Clean(t/f) Plate");
        frame.getContentPane().add(btna);
        JButton btnb = new JButton("Drop Plate");
        frame.getContentPane().add(btnb);
        JButton btnc = new JButton("Size Plate");
        frame.getContentPane().add(btnc);
        JButton btnd = new JButton("Colour Plate");
        frame.getContentPane().add(btnd);
        JButton btne = new JButton("Price Plate");
        frame.getContentPane().add(btne);
        JButton btnf = new JButton("Name Plate");
        frame.getContentPane().add(btnf);
        JButton btng = new JButton("Eat All");
        frame.getContentPane().add(btng);

        btn.setBounds(120, 10, 165, 50);
        btna.setBounds(120, 70, 165, 50);
        btnb.setBounds(120, 130, 165, 50);
        btnc.setBounds(120, 190, 165, 50);
        btnd.setBounds(120, 250, 165, 50);
        btne.setBounds(120, 310, 165, 50);
        btnf.setBounds(120, 370, 165, 50);
        btng.setBounds(120, 430, 165, 50);
        frame.setVisible(true);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plate = new Plate();
                System.out.println("Plate is created");
            }
        });
        btna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Plate Dirty => " + plate.clean);
                plate.clean();
                System.out.println("Clean => " + plate.clean);
            }
        });
        btnb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("broken: " + plate.broken);
                plate.breakPlate();
                System.out.println("broken: " + plate.broken);
            }
        });
        btnc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Size: " + plate.getSize());
            }
        });
        btnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Colour: " + plate.getColour());
            }
        });
        btne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Price: " + plate.getPrice());
            }
        });
        btnf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Name: " + plate.getName());

            }
        });
        btng.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plate.filledPercent = 50; //на скільки заповнена тарілка
                System.out.println("Filled: " + plate.filledPercent);
                plate.eatAll();
            }
        });
    }
}
