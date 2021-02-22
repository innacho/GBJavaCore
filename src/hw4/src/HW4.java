package hw4.src;

// 1.Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.
// 2.Написать простой класс Телефонный Справочник, который хранит в себе список фамилий
// и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
// а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
// может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны
// выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
// взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов
// проверки телефонного справочника.

import java.util.*;

public class HW4 {
    public static void main(String args[]) {
        //Первое задание, создадим массив слов с повторениями
        String[] wordArr = new String[15];
        for (int i = 1, arrInd = 0; i <= 5; i++){
            for(int j = 0; j < i; j++, arrInd++){
                wordArr[arrInd] = "word"+ String.valueOf(i);
            }
        }

        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
        System.out.println(wordList);

        //cоздадим сет без дубликатов на осове нашего листа
        Set<String> wordSet = new HashSet<>(wordList);
        System.out.println(wordSet);

        //посчитаем число вхождений каждого слова в исходный массив
        Iterator<String> setIterator = wordSet.iterator();
        do {
            String current = setIterator.next();
            int count = 0;
            for(String word : wordArr){
                if(word.equals(current))  count++;
            }
            System.out.println("Word " + current + " appears in array " + count + " times.");
        }while(setIterator.hasNext());

        //второе задание - телефонная книга
        Phonebook phonebook = new Phonebook();

        //заполним телефонную книгу
        phonebook.addEntry("Ivanov", "+79101111111");
        phonebook.addEntry("Ivanov", "+79102222222");
        phonebook.addEntry("Petrov", "+791013333333");
        phonebook.addEntry("Sidorov", "+79104444444");
        phonebook.addEntry("Petrov", "+79105555555");
        //попробуем добавить дубликат уже существующей записи в телефонную книгу
        phonebook.addEntry("Petrov", "+79105555555");
        phonebook.addEntry("Petrov", "+79105555555");

        System.out.println(phonebook);

        //работа поиска по телефонной книге
        System.out.println("All phones for lastname " + "Ivanov: " + phonebook.getPhones("Ivanov") );

        phonebook.addEntry("Kolobok", "+79106666666");

        System.out.println("All phones for lastname " + "Kolobok: " + phonebook.getPhones("Kolobok") );

        System.out.println("All phones for lastname " + "Krokodil: " + phonebook.getPhones("Krokodil") );



    }
}
