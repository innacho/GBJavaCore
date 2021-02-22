package hw4.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Phonebook extends HashMap<String, HashSet<String>> {

    public void addEntry(String lastname, String phone){
        if(this.containsKey(lastname)){
            HashSet<String> phones = this.get(lastname);
            phones.add(phone);
            this.put(lastname, phones);
        } else this.put(lastname, new HashSet<String>(Arrays.asList(phone)));
    }

    public HashSet<String> getPhones(String lastname){
        if(this.containsKey(lastname)){
            HashSet<String> phones = this.get(lastname);
            return phones;
        } else {
            System.out.println("No entry for " + lastname + " have been found!");
            return null;
        }
    }
}
