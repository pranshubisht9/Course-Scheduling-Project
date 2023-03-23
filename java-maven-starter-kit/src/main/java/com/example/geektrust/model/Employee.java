package com.example.geektrust.model;

import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.utility.FixedConstants;

public class Employee {
    private final String name;
    private final String email;
    public Employee(String emailAddress) throws InvalidInputException {
        if (FixedConstants.VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches()) {
            this.email = emailAddress;
                    this.name = this.email.substring(0, this.email.indexOf('@'));
        } else {
            throw new InvalidInputException("INPUT_DATA_ERROR");
        }
    }
    public String getName() {
        return name;
    }
    public String getEmailAddress() {
        return email;
    }
}
