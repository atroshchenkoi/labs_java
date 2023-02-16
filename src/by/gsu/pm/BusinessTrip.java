package by.gsu.pm;

public class BusinessTrip {
    private static final int DAILY_ALLOWANCE_RATE = 1999;
    private String employeeAccount;
    private int transportationExpenses;
    private int numberOfDays;

    public BusinessTrip() {}

    public BusinessTrip(String employeeAccount, int transportationExpenses, int numberOfDays) {
        this.employeeAccount = employeeAccount;
        this.transportationExpenses = transportationExpenses;
        this.numberOfDays = numberOfDays;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public static String conversionToRubles(int kopecks){
        return kopecks / 100 + "." + (kopecks % 100) / 10 + (kopecks % 100) % 10;
    }

    public int getTotalExpenses(){
        return numberOfDays * DAILY_ALLOWANCE_RATE + transportationExpenses;
    }

    public void showFullInfoAboutEmployee(){
        System.out.println("rate = " + conversionToRubles(DAILY_ALLOWANCE_RATE)
                + "\naccount = " + employeeAccount
                + "\ntransport = " + conversionToRubles(transportationExpenses)
                + "\ndays = " + numberOfDays
                + "\ntotal = " + conversionToRubles(getTotalExpenses()));
    }
    @Override
    public String toString() {
        return employeeAccount + ";" + conversionToRubles(transportationExpenses) + ";" + numberOfDays + ";" + conversionToRubles(getTotalExpenses());
    }
}
