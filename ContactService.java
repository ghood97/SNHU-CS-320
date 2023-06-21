package org.contact;

import java.util.ArrayList;
import java.util.Random;

public class ContactService {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    private static final Random rnd = new Random();

    public static String getUniqueId() {
        StringBuilder sb = new StringBuilder(10);
        for(int i=0; i < 10; i++)
            sb.append((char)('0' + rnd.nextInt(10)));
        return sb.toString();
    }

    public String addContact(String firstName, String lastName, String phone, String address) {
        String newContactId = getUniqueId();
        Contact newContact = new Contact(newContactId, firstName, lastName, phone, address);
        contacts.add(newContact);
        return newContactId;
    }

    public void deleteContact(String contactId) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactId().equals(contactId)) {
                contacts.remove(i);
                break;
            }
        }
    }

    public Contact updateFirstName(String contactId, String firstName) {
        Contact contact = findContactById(contactId);
        if (contact != null) {
            contact.validateAndSetFirstName(firstName);
        }
        return contact;
    }

    public Contact updateLastName(String contactId, String lastName) {
        Contact contact = findContactById(contactId);
        if (contact != null) {
            contact.validateAndSetLastName(lastName);
        }
        return contact;
    }

    public Contact updatePhoneNumber(String contactId, String phone) {
        Contact contact = findContactById(contactId);
        if (contact != null) {
            contact.validateAndSetPhoneNumber(phone);
        }
        return contact;
    }

    public Contact updateAddress(String contactId, String address) {
        Contact contact = findContactById(contactId);
        if (contact != null) {
            contact.validateAndSetAddress(address);
        }
        return contact;
    }

    public Contact findContactById(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
