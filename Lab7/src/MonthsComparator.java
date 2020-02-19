import java.util.Comparator;

public class MonthsComparator implements Comparator<ElectricityForMonth> {

    public int compare (ElectricityForMonth m1, ElectricityForMonth  m2){
        if(m1.monthName == m2.monthName){
            return 0;
        }
        if(m1.monthName.ordinal() > m2.monthName.ordinal()) {
            return 1;
        }
        else{
            return -1;
        }
    }
}
