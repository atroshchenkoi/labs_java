import by.gsu.pm.BusinessTrip;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTrips = {
                null,
                new BusinessTrip("Atroshchenko Ilya", 2099, 4),
                new BusinessTrip("Zanko Stas", 2251, 5),
                null,
                new BusinessTrip("Qwerty Asdfgh", 2149, 4),
                new BusinessTrip("Aezakmi Aezakmi", 1623, 7),
                new BusinessTrip()
        };
        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null){
                businessTrip.showFullInfoAboutEmployee();
            }
        }
        businessTrips[businessTrips.length - 1].setTransportationExpenses(1921);
        System.out.println("Total duration = " + (businessTrips[1].getNumberOfDays() + businessTrips[2].getNumberOfDays()));
        BusinessTrip max = new BusinessTrip();
        int sum = 0;
        for (BusinessTrip businessTrip : businessTrips) {
            if (businessTrip != null){
                System.out.println(businessTrip);
                sum += businessTrip.getTotalExpenses();
                if(businessTrip.getTotalExpenses() > max.getTotalExpenses()) max = businessTrip;

            }
        }
        System.out.println("Sum cost trips: " + BusinessTrip.conversionToRubles(sum));
        System.out.println("Max cost trip: " + max);
    }
}