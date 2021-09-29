package ru;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Patient1 implements AllFunc{
    @JsonProperty("firstName")
    public String firstName;
    @JsonProperty("lastName")
    public String lastName;
    @JsonProperty("position")
    public int position;
    /**
     * returns patient's position
     * @return patient's position
     */
    public int getPosition() {
        return position;
    }

    public Patient1(String name, String lastName, int position) {
        this.firstName = name;
        this.lastName = lastName;
        this.position = position;
    }
    /**
     * returns all params in string
     * @return params in string
     */
    @Override
    public String toString() {
        return "Patient1{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position +
                '}';
    }
}