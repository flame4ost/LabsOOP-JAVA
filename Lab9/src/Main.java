import javax.swing.*;

public class Main {
    public static void main(String args[]){

        String databaseURL = "jdbc:mysql://localhost/lab9?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "1111";
        String driverName = "com.mysql.jdbc.Driver";
        JFrame window = new JFrame("Lab9");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JDBCAdapter jdbcAdapter = new JDBCAdapter(databaseURL,driverName,user,password);
        jdbcAdapter.executeQuery("SELECT * from products");
        JTable table = new JTable(jdbcAdapter);
        window.add(table);
        window.setSize(700, 150);
        window.setVisible(true);
    }
}
