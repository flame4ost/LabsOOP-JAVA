import javax.swing.*;
import java.awt.*;

class Plate {
    boolean broken;
    boolean clean;
    boolean wet;
    double price;
    Color colorBackground = Color.white;
    void openColChooser()
    {
        colorBackground = JColorChooser.showDialog(null, "Choose a background",colorBackground);
    }
    //конструктори
    Plate() {
        broken = false;
        clean = true;
        price = 100;
    }

    Plate(int a) {
        price = a;
    }

    Plate(boolean b,boolean c, boolean d) {
        this(100);
        clean = c;
        wet = d;
    }

    String replics1 = "Information Plate";
    String replics2 = "Wash";
    String replics3 = "Put in place";
    String replics4 = "Check Plate";



    void wash() {
        if (broken) {
            System.out.println(replics2);
            broken = true;
            clean = false;
            wet = true;
        }
        else {
            System.out.println(replics3);
            clean = true;
            broken = false;
            wet = true;
        }
    }

    boolean canBeServed() {
        if (clean && !broken && !wet)
            return true;
        else
            System.out.println(replics4);
            return false;
    }

    void breakPlate() {
        broken = false;
    }

    String getPlateInfo() {
        System.out.println(replics1);
        return "||Wash:||" + wet + "||Broken:||" + broken + "||Clean:||" + clean + "||Price plate||=" + price;
    }


}
