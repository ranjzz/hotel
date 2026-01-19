import java.time.LocalDate;

/**
 * Room class represents a hotel room with its details.
 * It encapsulates the room number, type, price, and availability status.
 */
public class Room {
    private int roomNumber;
    private String type;
    private double price;
    private boolean available;

    /**
     * Constructor to initialize a Room object.
     * @param roomNumber The unique number of the room.
     * @param type The type of the room (e.g., Single, Double, Suite).
     * @param price The price per night for the room.
     */
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.available = true; // Rooms are available by default
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns a string representation of the Room object.
     * @return A formatted string with room details.
     */
    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + type + ", Price: $" + price + ", Available: " + available;
    }
}