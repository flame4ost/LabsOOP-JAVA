import entity.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by alex3 on 6/8/2017.
 */
public class Tables {

    void showTables(){
        JFrame window = new JFrame("lab10");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel buttomPanel = new JPanel();
        JLabel nameTable1 = new JLabel("Products");
        JLabel nameTable2 = new JLabel("Types");
        JLabel nameTable3 = new JLabel("Companys");

        window.setLayout(new GridLayout(3,0));

        JTable tableData = new JTable(new ProductTableModel());

        topPanel.add(nameTable1);
        topPanel.add(new JTable(new ProductTableModel()));
        centerPanel.add(nameTable2);
        centerPanel.add(new JTable(new TypeTableModel()));
        buttomPanel.add(nameTable3);
        buttomPanel.add(new JTable(new CompanyTableModel()));

        window.add(topPanel);
        window.add(centerPanel);
        window.add(buttomPanel);
        window.setSize(400,400);
        window.setVisible(true);
    }
}
