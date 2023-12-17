package edu.hw10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Task1Test {

    @Test
    public void testGenerateObjectWithNotNull() throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();
        TestClassWithAnnotations obj = rog.nextObject(TestClassWithAnnotations.class, "create");

        assertNotNull(obj);
        assertNotNull(obj.getName());
    }

    @Test
    public void testGenerateObjectWithMinAndMax() throws Exception {
        RandomObjectGenerator rog = new RandomObjectGenerator();
        TestClassWithAnnotations obj = rog.nextObject(TestClassWithAnnotations.class, "create");

        assertNotNull(obj);
        System.out.println(obj.getAge());
        assertTrue(obj.getAge() >= 18 && obj.getAge() <= 100);

    }
}

class TestClassWithAnnotations {
    private String name;
    private int age;

    @NotNull
    public String getName() {
        return name;
    }

    @Min(18)
    @Max(100)
    public int getAge() {
        return age;
    }

    // Фабричный метод
    public static TestClassWithAnnotations create(String name, int age) {
        TestClassWithAnnotations obj = new TestClassWithAnnotations();
        obj.name = name;
        obj.age = age;

        return obj;
    }
}

