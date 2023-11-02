package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class UtilityClassTest {

    @Test
    void t1SortByHeight() {
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false);
        List<Animal> animals = List.of(cat, dog, bird);

        List<Animal> sortedAnimals = UtilityClass.t1SortByHeight(animals);

        assertThat(sortedAnimals).containsExactly(bird, cat, dog);
    }

    @Test
    void t2SortByWeightReverse() {
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false);
        List<Animal> animals = List.of(cat, dog, bird);
        int k = 2;

        List<Animal> sortedAnimals = UtilityClass.t2SortByWeight(animals, k);

        assertThat(sortedAnimals).containsExactly(dog, cat);
    }

    @Test
    void t3GetCountTypes() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 4, 35, 5, true)
        );

        Map<Animal.Type, Integer> countTypes = UtilityClass.t3GetCountTypes(animals);

        assertThat(countTypes)
            .containsEntry(Animal.Type.CAT, 2)
            .containsEntry(Animal.Type.DOG, 1)
            .containsEntry(Animal.Type.BIRD, 1);
    }

    @Test
    void t4GetLongestName() {
        Animal cat = new Animal("KittyCat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false);
        List<Animal> animals = List.of(cat, dog, bird);

        Animal longestNameAnimal = UtilityClass.t4GetLongestName(animals);

        assertThat(longestNameAnimal).isEqualTo(cat);
    }

    @Test
    void t5GetMostCommonSex() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 4, 35, 5, true)
        );

        Animal.Sex mostCommonSex = UtilityClass.t5GetMostCommonSex(animals);

        assertThat(mostCommonSex).isEqualTo(Animal.Sex.M);
    }

    @Test
    void t6GetHeaviestOfEachType() {
        Animal cat1 = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal cat2 = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 3, 40, 6, true);
        Animal dog1 = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 20, 2, false);
        Animal dog2 = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 35, 5, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 5, 25, 3, false);

        List<Animal> animals = List.of(cat1, cat2, dog1, dog2, bird);

        Map<Animal.Type, Animal> heaviestOfEachType = UtilityClass.t6GetHeaviestOfEachType(animals);

        assertThat(heaviestOfEachType)
            .containsEntry(Animal.Type.CAT, cat2)
            .containsEntry(Animal.Type.DOG, dog2)
            .containsEntry(Animal.Type.BIRD, bird);
    }

    @Test
    void t7GetOldestKth() {
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false);
        List<Animal> animals = List.of(cat, dog, bird);
        int k = 2;

        Animal oldestKthAnimal = UtilityClass.t7GetOldestKth(animals, k);

        assertThat(oldestKthAnimal).isEqualTo(cat);
    }

    @Test
    void t8GetHeaviestAmongLowerK() {
        Animal cat1 = new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal cat2 = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 3, 40, 6, true);
        Animal dog1 = new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 20, 2, false);
        Animal dog2 = new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 35, 5, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 5, 25, 3, false);

        List<Animal> animals = List.of(cat1, cat2, dog1, dog2, bird);
        int k = 35;

        Optional<Animal> heaviestAnimal = UtilityClass.t8GetHeaviestAmongLowerK(animals, k);

        assertThat(heaviestAnimal).contains(cat1);
    }

    @Test
    void t9CountPaws() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 1, true)
        );

        int totalPaws = UtilityClass.t9CountPaws(animals);

        assertThat(totalPaws).isEqualTo(18);
    }

    @Test
    void t10GetAnimalsNotMatchLegsAndAge() {
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal cat2 = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 4, 50, 4, true);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false);


        List<Animal> animals = List.of(cat, cat2, dog, bird);

        List<Animal> mismatchedAnimals = UtilityClass.t10GetAnimalsNotMatchLegsAndAge(animals);

        assertThat(mismatchedAnimals).containsExactlyInAnyOrder(cat, bird, dog);
    }

    @Test
    void t11GetAnimalsBitesAndHeightMore100() {
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false);
        Animal lion = new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 150, 4, true);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 140, 6, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 120, 2, false);

        List<Animal> animals = List.of(cat, lion, dog, bird);

        List<Animal> dangerousAnimals = UtilityClass.t11GetAnimalsBitesAndHeightMore100(animals);

        assertThat(dangerousAnimals).containsExactlyInAnyOrder(lion, dog);
    }

    @Test
    void t12CountWeightMoreHeight() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 15, false)
        );

        int count = UtilityClass.t12CountWeightMoreHeight(animals);

        assertThat(count).isEqualTo(1);
    }

    @Test
    void t13AnimalsNamesHasMoreTwoWords() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Big Brown Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 15, false)
        );

        List<Animal> animalsWithLongNames = UtilityClass.t13AnimalsNamesHasMoreTwoWords(animals);

        assertThat(animalsWithLongNames).containsExactly(
            new Animal("Big Brown Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true)
        );
    }

    @Test
    void t14HasDogWithHeightMoreK() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 15, false)
        );
        int k1 = 20;
        int k2 = 50;

        boolean hasDogWithHeightMoreK1 = UtilityClass.t14HasDogWithHeightMoreK(animals, k1);
        boolean hasDogWithHeightMoreK2 = UtilityClass.t14HasDogWithHeightMoreK(animals, k2);

        assertThat(hasDogWithHeightMoreK1).isTrue();
        assertThat(hasDogWithHeightMoreK2).isFalse();
    }

    @Test
    void t15CountWeightWithAgeBetween() {
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 20, 15, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 35, 25, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 5, 25, 20, false)
        );
        int k = 2;
        int l = 4;
        Map<Animal.Type, Integer> weightCount = UtilityClass.t15CountWeightWithAgeBetween(animals, k, l);

        assertThat(weightCount)
            .containsEntry(Animal.Type.CAT, 70)
            .containsEntry(Animal.Type.DOG, 25);
    }

    @Test
    void t16SortByTypeSexAndName() {
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 40, false);
        Animal cat2 = new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false);
        Animal cat3 = new Animal("Cat3", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false);
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 20, 15, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 4, 35, 25, false);
        List<Animal> animals = List.of(cat, cat2, cat3, dog, spider, bird);

        List<Animal> sortedAnimals = UtilityClass.t16SortByTypeSexAndName(animals);

        assertThat(sortedAnimals).containsExactly(cat2, cat3, cat, dog, bird, spider);
    }

    @Test
    void t17DoesSpidersBitesMoreDogs() {
        List<Animal> animals1 = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 20, 15, true)
        );

        List<Animal> animals2 = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 20, 15, true)
        );
        List<Animal> animals3 = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.F, 1, 3, 2, true)
        );

        boolean spidersBiteMoreDogs1 = UtilityClass.t17DoesSpidersBitesMoreDogs(animals1);
        boolean spidersBiteMoreDogs2 = UtilityClass.t17DoesSpidersBitesMoreDogs(animals2);
        boolean spidersBiteMoreDogs3 = UtilityClass.t17DoesSpidersBitesMoreDogs(animals3);

        assertThat(spidersBiteMoreDogs1).isFalse();
        assertThat(spidersBiteMoreDogs2).isTrue();
        assertThat(spidersBiteMoreDogs3).isFalse(); // Недостаточно данных, нет информации о собаках
    }

    @Test
    void t18GetHeaviestFish() {
        List<Animal> animals1 = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.F, 3, 40, 30, true)
        );

        List<Animal> animals2 = List.of(
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 1, 20, 15, true),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 35, 25, false)
        );

        Animal heaviestFish = UtilityClass.t18GetHeaviestFish(animals1, animals2);

        assertThat(heaviestFish).isEqualTo(new Animal("Fish1", Animal.Type.FISH, Animal.Sex.F, 3, 40, 30, true));
    }

    @Test
    void t19GetErrors() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 15, false)
        );


        Map<String, Set<ValidationError>> errors = UtilityClass.t19GetErrors(animals);
        assertThat(errors)
            .containsEntry("Cat", Set.of())
            .containsEntry("Dog", Set.of())
            .containsEntry("Bird", Set.of());

    }

    @Test
    void t20GetErrorsPretty() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 15, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 1000, 20, 15, false),
            new Animal("Bird3", Animal.Type.BIRD, Animal.Sex.M, 1000, 20, 1500000000, false)
        );

        Map<String, String> errorsPretty = UtilityClass.t20GetErrorsPretty(animals);

        assertThat(errorsPretty)
            .containsEntry("Cat", "[]")
            .containsEntry("Dog", "[]")
            .containsEntry("Bird", "[]")
            .containsEntry("Bird2", "[Age error]")
            .containsEntry("Bird3", "[Weight error, Age error]");
    }
}

