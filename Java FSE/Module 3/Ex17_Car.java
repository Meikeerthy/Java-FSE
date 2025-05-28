public class Ex17_Car {
    String make;
    String model;
    int year;

    // Constructor
    Ex17_Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    void displayDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Car Year: " + year);
    }
    
    public static void main(String[] args) {
        Ex17_Car car1 = new Ex17_Car("Toyota", "Corolla", 2020);
        Ex17_Car car2 = new Ex17_Car("Honda", "Civic", 2022);

        System.out.println("Details of Car 1:");
        car1.displayDetails();

        System.out.println("\nDetails of Car 2:");
        car2.displayDetails();
    }
}