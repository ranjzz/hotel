import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Reservation class represents a booking made by a customer for a room.
 * It encapsulates the customer, room, check-in and check-out dates, and total bill.
 */
public class Reservation {
    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalBill;

    /**
     * Constructor to initialize a Reservation object.
     * @param customer The customer making the reservation.
     * @param room The room being reserved.
     * @param checkInDate The check-in date.
     * @param checkOutDate The check-out date.
     */
    public Reservation(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalBill = calculateBill();
    }

    /**
     * Calculates the total bill based on the number of days and room price.
     * @return The total bill amount.
     */
    private double calculateBill() {
        long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        return days * room.getPrice();
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalBill() {
        return totalBill;
    }

    /**
     * Returns a string representation of the Reservation object.
     * @return A formatted string with reservation details.
     */
    @Override
    public String toString() {
        return "Customer: " + customer.getName() + ", Room: " + room.getRoomNumber() + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate + ", Total Bill: $" + totalBill;
    }
}