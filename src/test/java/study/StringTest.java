package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class
StringTest {
    @Test
    void replace() {
        String actual = "hello yelim".replace("yelim", "eunjung");
        assertThat(actual).isEqualTo("hello janghyun");
    }

    @Test
    void split() {

        String ex = "1,2";
        String ex2 = "1";

        String[] exArray = ex.split(",");
        String[] exArray2 = ex2.split(",");

        assertThat(exArray).contains("1");
        assertThat(exArray).contains("2");
        assertThat(exArray).containsExactly("1", "2");
        assertThat(exArray2).containsExactly("1");
    }

    @BeforeEach
    void setUp() {

    }
}
