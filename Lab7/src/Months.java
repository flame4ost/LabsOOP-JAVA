public enum Months {
    JANUARY("January"),FEBRUARY("February"),MARCH("March"),
    APRIL("April"),MAY("May"),JUNE("June"),
    JULY("July"),AUGUST("August"),SEPTEMBER("September"),
    OCTOBER("October"),NOVEMBER("November"),DECEMBER("December");

    String monthName;

    public String getMonthName() {
        return monthName;
    }

    Months(String monthName){
        this.monthName = monthName;
    }

}

