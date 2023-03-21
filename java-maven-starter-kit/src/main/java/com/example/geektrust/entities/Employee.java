package com.example.geektrust.entities;

import com.example.geektrust.Utilities.FixedConstants;
import com.example.geektrust.exceptions.InputErrorException;

public class Employee {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public Employee(String emailAddress) throws InputErrorException {
        if (FixedConstants.VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress).matches()) {
            this.email = emailAddress;
            this.name = this.email.substring(0, this.email.indexOf('@'));
        } else {
            throw new InputErrorException("INPUT_DATA_ERROR");
        }
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
