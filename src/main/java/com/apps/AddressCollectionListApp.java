package com.apps;

import com.modules.AddressCollection;
import com.modules.AddressCollectionList;

import java.util.ArrayList;
import java.util.List;

public class AddressCollectionListApp {

    public static void main(String[] args) {

        AddressCollectionList aCollection = new AddressCollectionList();

        List<String> addressStrings = new ArrayList<String>();

        addressStrings.add("siva,123 davis dr,morrisville,nc");
        addressStrings.add("reddy,54 shilloh dr,cary,nc");
        addressStrings.add("Siva,123 davis dr,,nc");
        addressStrings.add("bala,123 davis dr,chapelhill,GA");
        addressStrings.add("john,54 shilloh dr,CARY,NC");
        addressStrings.add("reddy,54 shilloh dr,cary,");
        addressStrings.add("smith,1 dave st,morrisville,");

        aCollection.populateData(addressStrings);

        aCollection.printAddresses();

        aCollection.countCity();
    }
}
