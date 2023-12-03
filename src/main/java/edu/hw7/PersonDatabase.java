package edu.hw7;

import java.util.List;

interface PersonDatabase {
    void add(Person person);

    void delete(int id);

    List findByName(String name);

    List findByAddress(String address);

    List findByPhone(String phone);
}
