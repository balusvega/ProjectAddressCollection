package com.apps;

import com.domain.Address;
import com.modules.AddressCollection;

public class AddressCollectionApp {

    public static void main(String[] args) {

        AddressCollection aCollection = new AddressCollection();

        String [] addressStrings = {
                "siva,123 davis dr,morrisville,nc",
                "reddy,54 shilloh dr,cary,nc",
                "Siva,123 davis dr,,nc",
                "bala,123 davis dr,chapelhill,GA",
                "john,54 shilloh dr,CARY,NC",
                "reddy,54 shilloh dr,cary,",
                "smith,1 dave st,morrisville,"
        };

        aCollection.populateData(addressStrings);

        aCollection.printAddresses();

        aCollection.printCities();

        aCollection.countCities();
    }
}
