import org.contact.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    Contact validContact;

    @BeforeEach
    public void init() {
        validContact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    @DisplayName("Test contact ID validation")
    void testContactId() {
        assertDoesNotThrow(() -> new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123456789000", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    @DisplayName("Test first name validation")
    void testFirstName() {
        assertDoesNotThrow(() -> validContact.validateAndSetFirstName("John"));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetFirstName("JohnJohnJohnJohnJohn"));
    }

    @Test
    @DisplayName("Test last name validation")
    void testLastName() {
        assertDoesNotThrow(() -> validContact.validateAndSetLastName("DoeDoe"));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetLastName(null));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetLastName("DoeDoeDoeDoe"));
    }

    @Test
    @DisplayName("Test phone number validation")
    void testPhoneNumber() {
        assertDoesNotThrow(() -> validContact.validateAndSetPhoneNumber("7817710000"));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetPhoneNumber(null));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetPhoneNumber("781771000"));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetPhoneNumber("78177100000"));
    }

    @Test
    @DisplayName("Test address validation")
    void testAddress() {
        assertDoesNotThrow(() -> validContact.validateAndSetAddress("123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetAddress(null));
        assertThrows(IllegalArgumentException.class, () -> validContact.validateAndSetAddress("123 Main St123 Main St123 Main St123 Main St"));
    }
}