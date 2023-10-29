package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class Task5 {

    private Task5() {
    }

    public static List<Contact> parseContacts(@Nullable ArrayList<String> contacts, String order) {
        ArrayList<Contact> contactArrayList = new ArrayList<>();
        if (contacts == null) {
            return Collections.emptyList();
        }
        for (String entry : contacts) {
            String[] tempString = entry.split(" ");
            if (tempString.length > 2) {
                throw new IllegalArgumentException("Одна из записей содержит больше чем два поля");
            }
            if (tempString.length == 1) {
                contactArrayList.add(new Contact(tempString[0]));
            } else if (tempString.length == 2) {
                contactArrayList.add(new Contact(tempString[0], tempString[1]));
            }
        }
        contactArrayList.sort(Comparator.comparing(
            Contact::getLastnameOrName,
            order.equals("DESC") ? Comparator.reverseOrder() : Comparator.naturalOrder()
        ));
        return contactArrayList;
    }
}
