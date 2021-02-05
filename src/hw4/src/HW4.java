package hw4.src;

import java.util.*;

public class HW4 {
    public static void main(String args[]) {
        //Первое задание, массив слов с повторениями
        String[] wordArr = new String[15];
        for (int i = 1, arrInd = 0; i <= 5; i++){
            for(int j = 0; j < i; j++, arrInd++){
                wordArr[arrInd] = "word"+ String.valueOf(i);
            }
        }

        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
        System.out.println(wordList);

        //cоздадим се без дубликатов на осове нашего листа
        Set<String> wordSet = new HashSet<>(wordList);
        System.out.println(wordSet);

        //посчитаем число вхождений каждого слова в исходный массив
        Iterator<String> setIterator = wordSet.iterator();
        do {
            String current = setIterator.next();
            int count = 0;
            for(int i = 0; i < wordArr.length; i++){
                if(wordArr[i].equals(current))  count++;
            }
            System.out.println("Word " + current + " appears in array " + count + " times.");
        }while(setIterator.hasNext());

        //второе задание - телефонная книга
        Phonebook phonebook = new Phonebook();

        phonebook.addEntry("Ivanov", "+79101111111");
        phonebook.addEntry("Ivanov", "+79102222222");
        phonebook.addEntry("Petrov", "+791013333333");
        phonebook.addEntry("Sidorov", "+79104444444");
        phonebook.addEntry("Petrov", "+79105555555");
        System.out.println(phonebook);

        System.out.println("All phones for lastname " + "Ivanov: " + phonebook.getPhones("Ivanov") );

        phonebook.addEntry("Kolobok", "+79106666666");

        System.out.println("All phones for lastname " + "Kolobok: " + phonebook.getPhones("Kolobok") );

        System.out.println("All phones for lastname " + "Krokodil: " + phonebook.getPhones("Krokodil") );

    }
}
