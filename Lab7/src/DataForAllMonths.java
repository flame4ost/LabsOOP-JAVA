import javax.swing.*;
import java.util.*;

public class DataForAllMonths {

    int totalUsedEnergyCost;

    int totalIndexSum;

    Map<Integer, List<ElectricityForMonth>> allData = new TreeMap<>();

    int i;

    void addNewMonthData(ElectricityForMonth data) {
        List<ElectricityForMonth> thisYearList = allData.get(data.getYear());
        if (thisYearList != null) {
            for(int i = 0; i<thisYearList.size(); i++){
                ElectricityForMonth electricityForMonth = thisYearList.get(i);
                if(electricityForMonth.getMonth().equals(data.getMonth())){
                    JOptionPane.showMessageDialog(null,"Дані за цей місяць вже введено!");
                    return;
                }
            }
            if (data.getPreviousMonthIndex() >= data.getThisMonthIndex()){
                JOptionPane.showMessageDialog(null,"Дані за попередній місяць перевищують данні за поточний!");
                return;
            }

            thisYearList.add(data);
            MonthsComparator monthsComparator = new MonthsComparator();
            Collections.sort(thisYearList, monthsComparator);
            System.out.println(allData.toString());
        } else {
            thisYearList = new ArrayList<>();
            thisYearList.add(data);
            allData.put(data.getYear(), thisYearList);
            System.out.println(allData.toString());
        }
    }

    public List<ElectricityForMonth> getMonthsDataForPeriod(int firstYear, int lastYear, int firstMonthParam, int lastMonthParam) {
        List<ElectricityForMonth> resultList = new ArrayList<>();
        for (int i = firstYear; i <= lastYear; i++) {
            List<ElectricityForMonth> oneYearElectroData = allData.get(i);
            if (oneYearElectroData != null) {
                if (i == firstYear) {
                    int foundIndex = getMonthIndex(firstMonthParam, oneYearElectroData);
                    resultList.addAll(oneYearElectroData.subList(foundIndex, oneYearElectroData.size()));
                } else {
                    if (i == lastYear) {
                        int foundIndex = getMonthIndex(lastMonthParam, oneYearElectroData);
                        resultList.addAll(oneYearElectroData.subList(0, foundIndex));
                    } else {
                        resultList.addAll(oneYearElectroData);
                    }
                }
            }
        }
        return resultList;
    }

    private int getMonthIndex(int monthNumber, List<ElectricityForMonth> oneYearElectroData) {
        int foundIndex = 0;
        for (int j = 0; j < oneYearElectroData.size(); j++) {
            ElectricityForMonth electricityForMonth = oneYearElectroData.get(j);
            if (electricityForMonth.getMonth().ordinal() == monthNumber) {
                foundIndex = j;
                break;
            }
        }
        return foundIndex;
    }

    public void calculateTotalSumAndCost(){

        for(Map.Entry<Integer, List<ElectricityForMonth>> entry : allData.entrySet()){
            List<ElectricityForMonth> electricityForMonths = entry.getValue();
            for (ElectricityForMonth electricityForMonth : electricityForMonths) {
                totalIndexSum += (electricityForMonth.getThisMonthIndex()-electricityForMonth.getPreviousMonthIndex());
                int costForPeriod = (electricityForMonth.getThisMonthIndex()-electricityForMonth.getPreviousMonthIndex())*electricityForMonth.getCurrentPrice();
                totalUsedEnergyCost += costForPeriod;
            }
        }

    }
}

