package org.contact;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateAndSetContactId(contactId);
        validateAndSetFirstName(firstName);
        validateAndSetLastName(lastName);
        validateAndSetPhoneNumber(phone);
        validateAndSetAddress(address);
    }

    private boolean contactIdIsValid(String contactId) {
        return contactId != null && contactId.length() <= 10;
    }

    private boolean nameIsValid(String name) {
        return name != null && name.length() <= 10;
    }

    private boolean phoneIsValid(String phone) {
        return phone != null && phone.length() == 10;
    }

    private boolean addressIsValid(String address) {
        return address != null && address.length() <= 30;
    }

    private void validateAndSetContactId(String contactId) {
        if (contactIdIsValid(contactId)) {
            this.contactId = contactId;
        } else {
            throw new IllegalArgumentException("Invalid contact ID. Value must be unique, not blank, and less than 11 characters.");
        }
    }

    public void validateAndSetFirstName(String firstName) {
        if (nameIsValid(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be empty and must be less than 11 characters.");
        }
    }

    public void validateAndSetLastName(String lastName) {
        if (nameIsValid(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be empty and must be less than 11 characters.");
        }
    }

    public void validateAndSetPhoneNumber(String phoneNumber) {
        if (phoneIsValid(phoneNumber)) {
            this.phone = phoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must be exactly 10 characters.");
        }
    }

    public void validateAndSetAddress(String address) {
        if (addressIsValid(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be empty and must be less than 31 characters.");
        }
    }
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
}