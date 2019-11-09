import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("First");
        frame.setSize(400, 400);
        JButton btn = new JButton("Start");
        frame.getContentPane().add(btn, BorderLayout.EAST);
        JTextField tf = new JTextField();
        frame.getContentPane().add(tf, BorderLayout.CENTER);
        JTextField tf1 = new JTextField();
        frame.getContentPane().add(tf1, BorderLayout.SOUTH);
        JTextField tf2 = new JTextField();
        frame.getContentPane().add(tf2, BorderLayout.SOUTH);
        btn.setLocation(12, 12);
        btn.setSize(165, 50);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = tf.getText();
                int m = str.length() / 2;
                tf2.setText(" Перша частина= " +str.substring(0,m)    +  "    Друга частина=  "  +str.substring(m));
            }
        });
        frame.setVisible(true);
    }
}