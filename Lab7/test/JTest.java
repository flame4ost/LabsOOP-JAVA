import lab7.ElectricityCount;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JTest {

    @Test
    public void testCalculateElectricityPeriod(){
        ElectricityCount electricityCount = new ElectricityCount();
        electricityCount.addMonth(1999,4,1.4,12,23,false);
        electricityCount.addMonth(1999,5,1.4,23,29,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
        try {
            Date date  = simpleDateFormat.parse("4/1999");
            Date date2  = simpleDateFormat.parse("5/1999");
            Assert.assertEquals(17,electricityCount.calculateElectricityPeriod(date, date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void testCalculateCostPeriod(){
        ElectricityCount electricityCount = new ElectricityCount();
        electricityCount.addMonth(1994,4,2,10,20,false);
        electricityCount.addMonth(1994,5,1,20,30, false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
        try {
            Date date  = simpleDateFormat.parse("4/1994");
            Date date2  = simpleDateFormat.parse("5/1994");
            Assert.assertEquals(30, electricityCount.calculateCostPeriod(date, date2),30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
