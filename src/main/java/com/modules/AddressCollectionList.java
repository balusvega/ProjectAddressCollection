package com.modules;

import com.domain.Address;
import com.exceptions.InvalidAddressFormatException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressCollectionList {

    List<Address> addresses = new ArrayList<Address>();

    Map<String, Integer> cityCount = new HashMap<String, Integer>();

    public void populateData(List<String> addressStrings){

        int addressCount=0;

        for(String aString : addressStrings){
            try{
                addresses.add(convertData(aString));
            }catch (InvalidAddressFormatException exp){
                System.out.println("Invalid address: "+aString);
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
        for(Address anAdress : addresses)
            System.out.println(anAdress.toString());
    }

    public  void countCity(){

        for (Address anAddress : addresses){

            if(cityCount.get(anAddress.getCity())==null){
                cityCount.put(new String(anAddress.getCity()), new Integer(1));
            }else{
                Integer count = cityCount.get(anAddress.getCity());
                cityCount.put(new String(anAddress.getCity()), new Integer(count.intValue() + 1));
            }
        }

        System.out.println("::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::: C I T Y    C O U N T :::::: ");

        for(Map.Entry<String, Integer> entry : cityCount.entrySet()){

            System.out.println("City: "+entry.getKey()+ "::: count: "+entry.getValue());

        }
    }

}
