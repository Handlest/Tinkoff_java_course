package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilityClass {

    private static final int DANGEROUS_HEIGHT = 100;

    private UtilityClass() {

    }

    public static List<Animal> t1SortByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::height))
            .toList();
    }

    public static List<Animal> t2SortByWeight(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    public static Map<Animal.Type, Integer> t3GetCountTypes(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(t -> 1)));
    }

    public static Animal t4GetLongestName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparing(t -> t.name().length()))
            .orElse(null);
    }

    public static Animal.Sex t5GetMostCommonSex(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
    }

    public static Map<Animal.Type, Animal> t6GetHeaviestOfEachType(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                animal -> animal,
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    public static Animal t7GetOldestKth(List<Animal> animals, int k) { // Remake for Kth animal amount oldest
        return animals.stream()
            .sorted(Comparator.comparing(Animal::age)).limit(k)
            .max(Comparator.comparing(Animal::age))
            .orElse(null);
    }

    public static Optional<Animal> t8GetHeaviestAmongLowerK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(t -> t.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    public static Integer t9CountPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    public static List<Animal> t10GetAnimalsNotMatchLegsAndAge(List<Animal> animals) {
        return animals.stream()
            .filter(t -> t.paws() != t.age())
            .toList();
    }

    public static List<Animal> t11GetAnimalsBitesAndHeightMore100(List<Animal> animals) {
        return animals.stream()
            .filter(t -> t.height() > DANGEROUS_HEIGHT && t.bites())
            .toList();
    }

    public static Integer t12CountWeightMoreHeight(List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(t -> t.weight() > t.height())
            .count());
    }

    public static List<Animal> t13AnimalsNamesHasMoreTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(t -> t.name().split(" ").length > 2)
            .toList();
    }

    public static boolean t14HasDogWithHeightMoreK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(t -> t.type().equals(Animal.Type.DOG) && t.height() > k);
    }

    public static Map<Animal.Type, Integer> t15CountWeightWithAgeBetween(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(t -> t.age() >= k && t.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> t16SortByTypeSexAndName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .toList();
    }

    public static boolean t17DoesSpidersBitesMoreDogs(List<Animal> animals) {
        long dogsBites = animals.stream().filter(t -> t.bites() && (t.type().equals(Animal.Type.DOG))).count();
        long spiderBites = animals.stream().filter(t -> t.bites() && (t.type().equals(Animal.Type.SPIDER))).count();
        return animals.stream().anyMatch(t -> t.type().equals(Animal.Type.DOG))
            && animals.stream().anyMatch(t -> t.type().equals(Animal.Type.SPIDER))
            && spiderBites > dogsBites;
    }

    @SafeVarargs public static Animal t18GetHeaviestFish(List<Animal>... animals) {
        return Stream.of(animals)
            .flatMap(List::stream)
            .filter(t -> t.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight)).orElse(null);
    }

    public static Map<String, Set<ValidationError>> t19GetErrors(List<Animal> animals) {
        return animals.stream()
            .flatMap(animal -> Validators.validateAnimal(animal)
                .entrySet().stream())
            .collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
            ));
    }

    public static Map<String, String> t20GetErrorsPretty(List<Animal> animals) {
        return t19GetErrors(animals).entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.join(", ", entry.getValue().toString())));
    }
}
