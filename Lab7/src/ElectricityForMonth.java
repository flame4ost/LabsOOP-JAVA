public class ElectricityForMonth {

    Months monthName;
    int year;
    private int previousMonthIndex;
    private int thisMonthIndex;
    int currentPrice;

    ElectricityForMonth(Months monthName, int year){
        this.monthName=monthName;
        this.year=year;
    }

    ElectricityForMonth(Months monthName, int year, int lastIndex, int currentIndex, int currentPrice){
        this.monthName=monthName;
        this.year=year;
        this.previousMonthIndex =lastIndex;
        this.thisMonthIndex =currentIndex;
        this.currentPrice=currentPrice;
    }

    String getMonthData(){
        return "Місяць:"+ monthName+ ";" + " Рік:" + year +";"+ " Поп.місяць:" + previousMonthIndex +";"+ " Пот. місяць:" + thisMonthIndex + ";" + " Ціна :" + currentPrice + ";" ;
    }

    @Override
    public String toString(){
        return "Місяць:"+ monthName+ ";" + " Рік:" + year +";"+ " Поп. місяць:" + previousMonthIndex +";"+ " Пот. місяць:" + thisMonthIndex + ";" + " Ціна :" + currentPrice + ";" ;
    }
    public Months getMonth() {
        return monthName;
    }

    public void setMonthName(Months monthName) {
        this.monthName = monthName;
    }

    public int  getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPreviousMonthIndex() {
        return previousMonthIndex;
    }

    public void setPreviousMonthIndex(int previousMonthIndex) {
        this.previousMonthIndex = previousMonthIndex;
    }

    public int getThisMonthIndex() {
        return thisMonthIndex;
    }

    public void setThisMonthIndex(int thisMonthIndex) {
        this.thisMonthIndex = thisMonthIndex;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
