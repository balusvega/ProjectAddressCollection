package com.modules;

import com.domain.Address;
import com.exceptions.InvalidAddressFormatException;

public class AddressCollection {

    Address [] addresses;
    String [] cities;
    int cityCount=0;
    int [] totalCitiesCount;

    public void populateData(String [] addressStrings){

        int addressCount=0;
        cities = new String[addressStrings.length];
        for(int counter=0;counter<addressStrings.length;counter++){
            try{
                convertData(addressStrings[counter]);
                addressCount++;
            }catch (InvalidAddressFormatException exp){
//                System.out.println("Invalid address: "+addressStrings[counter]);
            }
        }
        addresses = new Address[addressCount];
        addressCount=0;
        for(int counter=0;counter<addressStrings.length;counter++){
            try{
                addresses[addressCount] = convertData(addressStrings[counter]);
                boolean isPresent=false;
                for(int secondCounter=0; secondCounter<cities.length;secondCounter++){
                    if(cities[secondCounter]!=null &&
                            addresses[addressCount].getCity().equals(cities[secondCounter])){
                        isPresent=true;
                    }
                }
                if(!isPresent) {
//                    System.out.println("addressCount: "+addressCount+" city: current city count: "+cityCount);
                    cities[cityCount] = addresses[addressCount].getCity();
                    cityCount++;
                }
                addressCount++;
            } catch (InvalidAddressFormatException exp){
                System.out.println("Invalid Address: "+addressStrings[counter]);
            }
        }
    }

    private Address convertData(String addressString) throws InvalidAddressFormatException{
        // siva,123 davis dr,cary,nc
        String [] splits = addressString.split(",");
        if(splits.length!=4){
            throw new InvalidAddressFormatException();
        }else {
            if(splits[2]==null || splits[2].isEmpty() || splits[3]==null
                    || splits[3].isEmpty())
                throw new InvalidAddressFormatException();
        }
        Address anAddress = new Address();
        if(splits[0]!=null)
            anAddress.setName(splits[0].trim());
        else
            anAddress.setName("");
        if(splits[1]!=null)
            anAddress.setStreet(splits[1].trim());
        else
            anAddress.setStreet("");

        anAddress.setCity(splits[2].trim().toUpperCase());
        anAddress.setState(splits[3].trim().toUpperCase());
        return anAddress;
    }

    public void printAddresses(){
        for(int counter=0;counter<addresses.length;counter++)
            System.out.println(addresses[counter].toString());
    }
    public void printCities(){
        for(int counter=0;counter<cities.length;counter++)
            System.out.println(cities[counter]);

        System.out.println("Total cities: "+cityCount);
    }


    public void countCities(){

        totalCitiesCount = new int[cityCount];

        for (int counter=0;counter<addresses.length;counter++){
            for (int cityCounter=0; cityCounter<cityCount;cityCounter++){
                if(cities[cityCounter].equals(addresses[counter].getCity())){
                    totalCitiesCount[cityCounter]++;
                }
            }
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println("::::  C I T Y    C O U N T :::::::::");
        for (int counter=0;counter<cityCount;counter++){
            System.out.println("city: "+cities[counter]+" count: "+totalCitiesCount[counter]);
        }
        System.out.println("::::::::::::::::::::::::::::::::::::");
    }

}
