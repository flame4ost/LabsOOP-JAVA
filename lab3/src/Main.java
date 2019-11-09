import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Lab 3");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        Plate plate = new Plate(false, true, false);

        JButton myNPr = new JButton("Price Plate");
        JButton checkPlate = new JButton("Verify Plate..");
        JButton washPlate = new JButton("Information Plate");
        JButton setCol = new JButton("Open ColorChooser");

        window.getContentPane().add(myNPr, BorderLayout.NORTH);
        window.getContentPane().add(checkPlate, BorderLayout.CENTER);
        window.getContentPane().add(washPlate, BorderLayout.EAST);
        window.getContentPane().add(setCol, BorderLayout.SOUTH);
        window.setSize(640, 480);

        setCol.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 plate.openColChooser();
                 setCol.setBackground(plate.colorBackground);
                 myNPr.setBackground(plate.colorBackground);
                 checkPlate.setBackground(plate.colorBackground);
                 washPlate.setBackground(plate.colorBackground);
             }
        });

        myNPr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plate.breakPlate();
            }
        }
        );
        checkPlate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plate.wash();
                System.out.println(plate.getPlateInfo());
            }
        }
        );
        washPlate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plate.canBeServed();
            }
        }
        );


    }
}

