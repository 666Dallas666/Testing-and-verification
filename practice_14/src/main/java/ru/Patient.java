package ru;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Patient implements AllFunc{
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    /**
     * returns patient's last name
     * @return patient's last name
     */
    public String getLastName() {
        return lastName;
    }

    public Patient(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }
    /**
     * returns all params in string
     * @return params in string
     */
    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                '}';
    }
}
