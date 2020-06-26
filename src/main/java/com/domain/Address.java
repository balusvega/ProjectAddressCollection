package com.domain;

public class Address {

    private String name;
    private String street;
    private String city;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        String returnString ="";
        if(name!=null && !name.isEmpty())
            returnString = returnString.concat("Name:").concat(this.name);
        if(street!=null && !street.isEmpty())
            returnString = returnString.concat(" & street: ").concat(this.street);
        if(city!=null && !city.isEmpty())
            returnString = returnString.concat(" & city: ").concat(this.city);
        if(state!=null && !state.isEmpty())
            returnString = returnString.concat(" && state: ").concat(this.state);

        return returnString;

    }
}
