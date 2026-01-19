import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hotel class manages the hotel's rooms, customers, and reservations.
 * It provides methods for room management, booking, cancellation, and availability checks.
 */
public class Hotel {
    private List<Room> rooms;
    private List<Customer> customers;
    private List<Reservation> reservations;

    /**
     * Constructor to initialize the Hotel with empty lists.
     */
    public Hotel() {
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    /**
     * Adds a new room to the hotel.
     * @param room The room to add.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Books a room for a customer.
     * @param customer The customer making the booking.
     * @param roomNumber The room number to book.
     * @param checkInDate The check-in date as a string (yyyy-MM-dd).
     * @param checkOutDate The check-out date as a string (yyyy-MM-dd).
     * @return True if booking is successful, false otherwise.
     */
    public boolean bookRoom(Customer customer, int roomNumber, String checkInDate, String checkOutDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
            LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

            if (checkIn.isAfter(checkOut) || checkIn.isEqual(checkOut)) {
                System.out.println("Invalid dates. Check-out must be after check-in.");
                return false;
            }

            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                    Reservation reservation = new Reservation(customer, room, checkIn, checkOut);
                    reservations.add(reservation);
                    customers.add(customer);
                    room.setAvailable(false);
                    System.out.println("Room booked successfully. Total bill: $" + reservation.getTotalBill());
                    return true;
                }
            }
            System.out.println("Room not available or does not exist.");
            return false;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Use yyyy-MM-dd.");
            return false;
        }
    }

    /**
     * Cancels a reservation for a customer.
     * @param customerName The name of the customer.
     * @param roomNumber The room number of the reservation.
     * @return True if cancellation is successful, false otherwise.
     */
    public boolean cancelReservation(String customerName, int roomNumber) {
        for (Reservation res : reservations) {
            if (res.getCustomer().getName().equals(customerName) && res.getRoom().getRoomNumber() == roomNumber) {
                res.getRoom().setAvailable(true);
                reservations.remove(res);
                System.out.println("Reservation cancelled successfully.");
                return true;
            }
        }
        System.out.println("Reservation not found.");
        return false;
    }

    /**
     * Checks and displays available rooms.
     */
    public void checkAvailability() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    /**
     * Displays all reservations.
     */
    public void viewReservations() {
        System.out.println("All Reservations:");
        for (Reservation res : reservations) {
            System.out.println(res);
        }
    }

    /**
     * Finds a room by room number.
     * @param roomNumber The room number to find.
     * @return The Room object if found, null otherwise.
     */
    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}