package hw4.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Phonebook extends HashMap<String, ArrayList<String>> {

    public void addEntry(String lastname, String phone){
        if(this.containsKey(lastname)){
            ArrayList<String> phones = this.get(lastname);
            phones.add(phone);
            this.put(lastname, phones);
        } else this.put(lastname, new ArrayList<String>(Arrays.asList(phone)));
    }

    public ArrayList<String> getPhones(String lastname){
        if(this.containsKey(lastname)){
            ArrayList<String> phones = this.get(lastname);
            return phones;
        } else {
            System.out.println("No entry for " + lastname + " have been found!");
            return null;
        }
    }
}
