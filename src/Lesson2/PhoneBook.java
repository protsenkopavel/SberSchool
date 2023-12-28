package Lesson2;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!contacts.containsKey(lastName)) {
            contacts.put(lastName, new HashSet<>());
        }
        contacts.get(lastName).add(phoneNumber);
    }

    public Set<String> get(String lastName) {
        return contacts.getOrDefault(lastName, new HashSet<>());
    }
}
