package edu.hw3.task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.assertj.core.api.Assertions;

public class Task5Test {
    @Test
    @DisplayName("[ \"John Locke\", \"Thomas Aquinas\", \"David Hume\", \"Rene Descartes\" ]")
    public void test1() {

        ArrayList<String> contacts = new ArrayList<>(Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"));

        ArrayList<Contact> contactsSorted = new ArrayList<>(Task5.parseContacts(contacts, "ASC"));

        Assertions.assertThat(contactsSorted.get(0).getLastnameOrName()).isEqualTo("Aquinas");
        Assertions.assertThat(contactsSorted.get(1).getLastnameOrName()).isEqualTo("Descartes");
        Assertions.assertThat(contactsSorted.get(2).getLastnameOrName()).isEqualTo("Hume");
        Assertions.assertThat(contactsSorted.get(3).getLastnameOrName()).isEqualTo("Locke");
    }

    @Test
    @DisplayName("[\"Paul Erdos\", \"Leonhard Euler\", \"Carl Gauss\"]")
    public void test2() {

        ArrayList<String> contacts = new ArrayList<>(Arrays.asList("Paul Erdos", "Carl Gauss", "Leonhard Euler"));

        ArrayList<Contact> contactsSorted = new ArrayList<>(Task5.parseContacts(contacts, "DESC"));

        Assertions.assertThat(contactsSorted.get(0).getLastnameOrName()).isEqualTo("Gauss");
        Assertions.assertThat(contactsSorted.get(1).getLastnameOrName()).isEqualTo("Euler");
        Assertions.assertThat(contactsSorted.get(2).getLastnameOrName()).isEqualTo("Erdos");
    }

    @Test
    @DisplayName("[], DESC")
    public void test3() {

        ArrayList<String> contacts = new ArrayList<>(Collections.emptyList());

        ArrayList<Contact> contactsSorted = new ArrayList<>(Task5.parseContacts(contacts, "DESC"));

        Assertions.assertThat(contactsSorted.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("null, DESC")
    public void test4() {

        ArrayList<String> contacts = null;

        ArrayList<Contact> contactsSorted = new ArrayList<>(Task5.parseContacts(contacts, "DESC"));

        Assertions.assertThat(contactsSorted.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("[\"Riko Mero\", \"Hello World\", \"John\"]")
    public void test5() {

        ArrayList<String> contacts = new ArrayList<>(Arrays.asList("Riko Mero", "Hello World", "John"));

        ArrayList<Contact> contactsSorted = new ArrayList<>(Task5.parseContacts(contacts, "ASC"));

        Assertions.assertThat(contactsSorted.get(0).getLastnameOrName()).isEqualTo("John");
        Assertions.assertThat(contactsSorted.get(1).getLastnameOrName()).isEqualTo("Mero");
        Assertions.assertThat(contactsSorted.get(2).getLastnameOrName()).isEqualTo("World");

    }
}
