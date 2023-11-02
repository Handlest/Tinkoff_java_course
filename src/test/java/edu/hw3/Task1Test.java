package edu.hw3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    @DisplayName("Hello world!")
    public void test1() {

        String inputString = "Hello world!";

        String result = Task1.atbash(inputString);

        Assertions.assertThat(result).isEqualTo("Svool dliow!");
    }

    @Test
    @DisplayName("Quotation from Martin Fowler")
    public void test2() {

        String inputString = "Any fool can write code that a computer can understand. Good programmers" +
            " write code that humans can understand. ― Martin Fowler";

        String result = Task1.atbash(inputString);

        Assertions.assertThat(result).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw." +
            " Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }

    @Test
    @DisplayName("Empty string")
    public void test3() {

        String inputString = "";

        String result = Task1.atbash(inputString);

        Assertions.assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Russian string")
    public void test4() {

        String inputString = "Здравствуй, мир!";

        String result = Task1.atbash(inputString);

        Assertions.assertThat(result).isEqualTo("Здравствуй, мир!");
    }

    @Test
    @DisplayName("Mixed register")
    public void test5() {

        String inputString = "AbCdE";

        String result = Task1.atbash(inputString);

        Assertions.assertThat(result).isEqualTo("ZyXwV");
    }
}
