import org.contact.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        assertEquals(0, service.getContacts().size());
        service.addContact("John", "Doe", "1234567890", "123 Main St");
        assertEquals(1, service.getContacts().size());
        service.addContact("Jane", "Doe", "1234567891", "123 Main St");
        assertEquals(2, service.getContacts().size());
        service.addContact("John", "Smith", "1234567892", "123 Main St");
        assertEquals(3, service.getContacts().size());
        assertThrows(IllegalArgumentException.class, () -> service.addContact("John", "Doe", "1234567890000", "123 Main St"));
    }

    @Test
    void testDeleteContact() {
        service.addContact("John", "Doe", "1234567890", "123 Main St");
        service.addContact("Jane", "Doe", "1234567891", "123 Main St");
        service.addContact("John", "Smith", "1234567892", "123 Main St");
        assertEquals(3, service.getContacts().size());
        service.deleteContact(service.getContacts().get(0).getContactId());
        assertEquals(2, service.getContacts().size());
    }

    @Test
    void testUpdateContact() {
        String contactId = service.addContact("John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(contactId, null));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(contactId, "JohnJohnJohn"));
        assertDoesNotThrow(() -> service.updateFirstName(contactId, "Jonathan"));

        assertThrows(IllegalArgumentException.class, () -> service.updateLastName(contactId, null));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName(contactId, "DoeDoeDoeDoe"));
        assertDoesNotThrow(() -> service.updateLastName(contactId, "Johnson"));

        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(contactId, null));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(contactId, "12345678990345"));
        assertDoesNotThrow(() -> service.updatePhoneNumber(contactId, "1234567891"));

        assertThrows(IllegalArgumentException.class, () -> service.updateAddress(contactId, null));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress(contactId, "123 Main St123 Main St123 Main St123 Main St"));
        assertDoesNotThrow(() -> service.updateAddress(contactId, "1456 Test St"));

    }
}