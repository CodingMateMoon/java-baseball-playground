import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CalculatorTest {
    Calculator calculator;
    long time;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        time = System.currentTimeMillis();

    }
    @AfterEach
    void tearDown() {
        System.out.println("결과 : " + (System.currentTimeMillis() - time));
    }

    @Test
    void 덧셈테스트() {

        int result = calculator.plus(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    void 뺄셈테스트() {
        int result = calculator.minus(1, 3);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    void 곱셈테스트() {
        int testResult = 0;
        for (int i = 0; i < 100000000; i++) {
            testResult++;
        }
        int result = calculator.multiple(2, 3);
        assertThat(result).isEqualTo(6);
    }
}