import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface: BookingOperations
interface BookingOperations {
    void bookTicket(String flightNumber, String passengerName, String date);
    void cancelTicket(String bookingID);
    void viewBookings();
    void searchFlights(String date);
}

// Abstract Class: Booking
abstract class Booking {
    protected String bookingID;
    protected String flightNumber;
    protected String passengerName;
    protected String date;

    public Booking(String bookingID, String flightNumber, String passengerName, String date) {
        this.bookingID = bookingID;
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
        this.date = date;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getDate() {
        return date;
    }

    public abstract void displayBookingDetails();
}

// Concrete Class: FlightBooking
class FlightBooking extends Booking {
    public FlightBooking(String bookingID, String flightNumber, String passengerName, String date) {
        super(bookingID, flightNumber, passengerName, date);
    }

    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Flight Number: " + flightNumber);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Date: " + date);
    }
}

// Concrete Class: BookingManager
class BookingManager implements BookingOperations {
    private List<Booking> bookings = new ArrayList<>();

    public void bookTicket(String flightNumber, String passengerName, String date) {
        String bookingID = "B" + (bookings.size() + 1);
        Booking newBooking = new FlightBooking(bookingID, flightNumber, passengerName, date);
        bookings.add(newBooking);
        System.out.println("Ticket booked successfully. Booking ID: " + bookingID);
    }

    public void cancelTicket(String bookingID) {
        bookings.removeIf(booking -> booking.getBookingID().equals(bookingID));
        System.out.println("Ticket cancelled successfully. Booking ID: " + bookingID);
    }

    public void viewBookings() {
        for (Booking booking : bookings) {
            booking.displayBookingDetails();
        }
    }

    public void searchFlights(String date) {
        System.out.println("Searching for flights on date: " + date);
        // Implement flight search logic here
    }
}

// Main Class: TravelBookingSystem
public class TravelBookingSystem {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Travel Booking System Menu:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Bookings");
            System.out.println("4. Search Flights");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight Number: ");
                    String flightNumber = scanner.nextLine();
                    System.out.print("Enter Passenger Name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    bookingManager.bookTicket(flightNumber, passengerName, date);
                    break;
                case 2:
                    System.out.print("Enter Booking ID: ");
                    String bookingID = scanner.nextLine();
                    bookingManager.cancelTicket(bookingID);
                    break;
                case 3:
                    bookingManager.viewBookings();
                    break;
                case 4:
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String searchDate = scanner.nextLine();
                    bookingManager.searchFlights(searchDate);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        //scanner.close(); // Close the Scanner to release resources
    }
}
