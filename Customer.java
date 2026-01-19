/**
 * Customer class represents a customer with their personal details.
 * It encapsulates the customer's name, phone number, and ID proof.
 */
public class Customer {
    private String name;
    private String phone;
    private String idProof;

    /**
     * Constructor to initialize a Customer object.
     * @param name The name of the customer.
     * @param phone The phone number of the customer.
     * @param idProof The ID proof of the customer (e.g., Passport, Driver's License).
     */
    public Customer(String name, String phone, String idProof) {
        this.name = name;
        this.phone = phone;
        this.idProof = idProof;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdProof() {
        return idProof;
    }

    /**
     * Returns a string representation of the Customer object.
     * @return A formatted string with customer details.
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", ID Proof: " + idProof;
    }
}