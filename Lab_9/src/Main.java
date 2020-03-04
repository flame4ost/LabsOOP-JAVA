public class Main {

    public static void main(String[] args) {
        MyDataModel model = new MyDataModel();
        JDBCAdapter adapter = new JDBCAdapter("jdbc:mysql://sql7.freemysqlhosting.net/sql7315168", "com.mysql.jdbc.Driver", "sql7315168", "GPlWZ4k6h7");
        adapter.executeQuery("CREATE TABLE Cats (id INT unsigned NOT NULL AUTO_INCREMENT, name VARCHAR(150) NOT NULL");
        //Server: sql7.freemysqlhosting.net
        //Name: sql7315168
        //Username: sql7315168
        //Password: GPlWZ4k6h7
        //Port number: 3306
    }
}

