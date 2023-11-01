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
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false)
        );

        List<Animal> sortedAnimals = UtilityClass.t1SortByHeight(animals);

        assertThat(sortedAnimals).containsExactly(
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true)
        );
    }

    @Test
    void t2SortByWeightReverse() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false)
        );
        int k = 2;

        List<Animal> sortedAnimals = UtilityClass.t2SortByWeight(animals, k);

        assertThat(sortedAnimals).containsExactly(
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false)
        );
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
        List<Animal> animals = List.of(
            new Animal("Cattt", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false)
        );

        Animal longestNameAnimal = UtilityClass.t4GetLongestName(animals);

        assertThat(longestNameAnimal).isEqualTo(new Animal("Cattt", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false));
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
        List<Animal> animals = List.of(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 35, 5, true),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 5, 25, 3, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.F, 2, 15, 1, true)
        );

        Map<Animal.Type, Animal> heaviestOfEachType = UtilityClass.t6GetHeaviestOfEachType(animals);

        assertThat(heaviestOfEachType)
            .containsEntry(Animal.Type.CAT, new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 3, 40, 6, true))
            .containsEntry(Animal.Type.DOG, new Animal("Dog2", Animal.Type.DOG, Animal.Sex.F, 4, 35, 5, true))
            .containsEntry(Animal.Type.BIRD, new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 5, 25, 3, false));
    }

    @Test
    void t7GetOldestKth() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false)
        );
        int k = 2;

        Animal oldestKthAnimal = UtilityClass.t7GetOldestKth(animals, k);

        assertThat(oldestKthAnimal).isEqualTo(new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false));
    }

    @Test
    void t8GetHeaviestAmongLowerK() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 5, 45, 3, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false)
        );
        int k = 35;
        Optional<Animal> heaviestAnimal = UtilityClass.t8GetHeaviestAmongLowerK(animals, k);

        assertThat(heaviestAnimal).contains(new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false));
    }

    @Test
    void t9CountPaws() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false)
        );

        int totalPaws = UtilityClass.t9CountPaws(animals);

        assertThat(totalPaws).isEqualTo(10);
    }

    @Test
    void t10GetAnimalsNotMatchLegsAndAge() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 4, 50, 4, true)
        );

        List<Animal> mismatchedAnimals = UtilityClass.t10GetAnimalsNotMatchLegsAndAge(animals);

        assertThat(mismatchedAnimals).contains(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 4, false),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 2, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 6, true)
        );
    }

    @Test
    void t11GetAnimalsBitesAndHeightMore100() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 120, 30, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 110, 40, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 90, 20, false),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 130, 50, true)
        );

        List<Animal> dangerousAnimals = UtilityClass.t11GetAnimalsBitesAndHeightMore100(animals);

        assertThat(dangerousAnimals).containsExactly(
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 110, 40, true),
            new Animal("Lion", Animal.Type.CAT, Animal.Sex.M, 4, 130, 50, true)
        );
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
        int k = 20;

        boolean hasDogWithHeightMoreK = UtilityClass.t14HasDogWithHeightMoreK(animals, k);

        assertThat(hasDogWithHeightMoreK).isTrue();
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
        List<Animal> animals = List.of(
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 20, 15, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 4, 35, 25, false)
        );

        List<Animal> sortedAnimals = UtilityClass.t16SortByTypeSexAndName(animals);

        assertThat(sortedAnimals).containsExactly(
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.F, 4, 35, 25, false),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 20, 15, true)
        );
    }

    @Test
    void t17DoesSpidersBitesMoreDogs() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 20, 15, true)
        );

        boolean spidersBiteMoreDogs = UtilityClass.t17DoesSpidersBitesMoreDogs(animals);

        assertThat(spidersBiteMoreDogs).isFalse();
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

        assertThat(errors).isEmpty();
    }

    @Test
    void t20GetErrorsPretty() {
        List<Animal> animals = List.of(
            new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 2, 30, 40, false),
            new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 3, 40, 30, true),
            new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 20, 15, false)
        );

        Map<String, String> errorsPretty = UtilityClass.t20GetErrorsPretty(animals);

        assertThat(errorsPretty).isEmpty();
    }
}

