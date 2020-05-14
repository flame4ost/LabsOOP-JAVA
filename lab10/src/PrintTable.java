

import entity.Company;
import entity.Product;
import entity.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PrintTable {
    String res[];
    int kilkist;
    List<Product> products;
    List<Type> types;
    List<Company> companys;
    public void print()
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        products = session.createQuery("from Product").list();
        types = session.createQuery("from Type").list();
        companys = session.createQuery("from Company").list();
        session.close();
        sf.close();
    }
}

/*public class PrintTable {
    String res[];
    int kilkist;
    List<Product> products;
    public void print()
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        products = session.createQuery("from Product").list();
        /*kilkist = 0;
        for (Product p:products) {
            kilkist++;
        }
        res = new String[kilkist];
        int i = 0;
        for(Product p:products){//Перенести код цього класу в сервлет!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            //System.out.println(p.getName()+" "+p.getPrice()+" "+p.getCode());

            res[i] = (p.getName()+" "+p.getPrice()+" "+p.getCode()+" ");
            i++;
        }
        session.close();
                sf.close();
                }
                }
                */