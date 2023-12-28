package Lesson2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        FileReader fileReader = new FileReader("resources/words.txt");
//        Scanner scanner = new Scanner(fileReader);

        String[] words = {
                "год", "человек", "работа", "год",
                "дело", "жизнь", "день", "дело",
                "жизнь", "работа", "слово", "год",
        };

        System.out.println("Количество слов в массиве: " + words.length);

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Количество уникальных слов в массиве: " + uniqueWords.size());

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nПодсчет количества повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("\"" + entry.getKey() + "\"" + ". Количество повторений: " + entry.getValue());
        }

        //Second task (PhoneBook)---------------------------

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Petrov", "89885706369");
        phoneBook.add("Bashirov", "89953325548");
        phoneBook.add("Cat", "8413848344338");
        phoneBook.add("My nephew", "164");
        phoneBook.add("My nephew", "150");
        phoneBook.add("My nephew", "150");


        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Bashirov"));
        System.out.println(phoneBook.get("Cat"));
        System.out.println(phoneBook.get("My nephew"));
    }
}
