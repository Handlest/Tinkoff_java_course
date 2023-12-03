package edu.hw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;


public class SynchronizedPersonDatabase implements PersonDatabase {

    private final Map<Integer, Person> idToPersonMap = new HashMap<>();
    private final Map<String, List<Integer>> nameIndex = new HashMap<>();
    private final Map<String, List<Integer>> addressIndex = new HashMap<>();
    private final Map<String, List<Integer>> phoneIndex = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        idToPersonMap.put(person.id(), person);

        addToIndex(nameIndex, person.name(), person.id());
        addToIndex(addressIndex, person.address(), person.id());
        addToIndex(phoneIndex, person.phoneNumber(), person.id());
    }

    @Override
    public synchronized void delete(int id) {
        Person person = idToPersonMap.remove(id);

        removeFromIndex(nameIndex, person.name(), id);
        removeFromIndex(addressIndex, person.address(), id);
        removeFromIndex(phoneIndex, person.phoneNumber(), id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return findByIds(nameIndex.getOrDefault(name, new ArrayList<>()));
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return findByIds(addressIndex.getOrDefault(address, new ArrayList<>()));
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return findByIds(phoneIndex.getOrDefault(phone, new ArrayList<>()));
    }

    private List<Person> findByIds(List<Integer> ids) {
        return getPeople(ids, idToPersonMap);
    }

    @NotNull static List<Person> getPeople(List<Integer> ids, Map<Integer, Person> idToPersonMap) {
        List<Person> result = new ArrayList<>();
        for (int id : ids) {
            Person person = idToPersonMap.get(id);
            if (person != null) {
                result.add(person);
            }
        }
        return result;
    }

    private void addToIndex(Map<String, List<Integer>> index, String key, int id) {
        index.computeIfAbsent(key, k -> new ArrayList<>()).add(id);
    }

    private void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        List<Integer> ids = index.get(key);
        if (ids != null) {
            ids.remove(Integer.valueOf(id));
            if (ids.isEmpty()) {
                index.remove(key);
            }
        }
    }
}
