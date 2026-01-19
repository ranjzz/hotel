is import java.util.Scanner;

/**
 * Main class is the entry point of the Hotel Reservation System.
 * It provides a menu-driven console interface for users to interact with the system.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Adding some sample rooms
        hotel.addRoom(new Room(101, "Single", 100.0));
        hotel.addRoom(new Room(102, "Double", 150.0));
        hotel.addRoom(new Room(103, "Suite", 250.0));

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Add Room");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Check Room Availability");
            System.out.println("5. View Reservations");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Add Room
                    System.out.print("Enter room number: ");
                    int roomNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter room type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter room price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    hotel.addRoom(new Room(roomNumber, type, price));
                    System.out.println("Room added successfully.");
                    break;

                case 2:
                    // Book Room
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter customer ID proof: ");
                    String idProof = scanner.nextLine();
                    Customer customer = new Customer(name, phone, idProof);

                    System.out.print("Enter room number: ");
                    int bookRoomNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter check-in date (yyyy-MM-dd): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Enter check-out date (yyyy-MM-dd): ");
                    String checkOut = scanner.nextLine();

                    hotel.bookRoom(customer, bookRoomNumber, checkIn, checkOut);
                    break;

                case 3:
                    // Cancel Reservation
                    System.out.print("Enter customer name: ");
                    String cancelName = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int cancelRoomNumber = Integer.parseInt(scanner.nextLine());
                    hotel.cancelReservation(cancelName, cancelRoomNumber);
                    break;

                case 4:
                    // Check Availability
                    hotel.checkAvailability();
                    break;

                case 5:
                    // View Reservations
                    hotel.viewReservations();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}