package mn.edu.must.sqat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    private GradeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new GradeCalculator();
    }

    @Test
    @DisplayName("1. 90 оноо яг А дүн байх ёстой")
    void test1_letterGradeBoundaryExactly90IsA() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    @Test
    @DisplayName("2. 89.99 оноо B дүн байх ёстой")
    void test2_letterGradeBoundaryJustBelow90IsB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    @DisplayName("3. letterGrade буруу оноонд exception шиднэ")
    void test3_letterGradeInvalidScoreThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(-1.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(100.1));
    }

    @ParameterizedTest
    @DisplayName("4. letterGrade заагуудыг шалгах parameterized тест")
    @CsvSource({
        "95.0, A",
        "90.0, A",
        "89.99, B",
        "80.0, B",
        "70.0, C",
        "60.0, D",
        "59.99, F",
        "0.0, F"
    })
    void test4_letterGradeBoundariesParameterized(double score, String expectedGrade) {
        assertEquals(expectedGrade, calculator.letterGrade(score));
    }

    @Test
    @DisplayName("5. totalScore хэвийн бодолт")
    void test5_totalScoreValidNormalValues() {
        assertEquals(100.0, calculator.totalScore(10, 40, 10, 10, 30), 0.001);
    }

    @Test
    @DisplayName("6. totalScore сөрөг утгад exception")
    void test6_totalScoreNegativeValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(-1, 40, 10, 10, 30));
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(10, -5, 10, 10, 30));
    }

    @Test
    @DisplayName("7. totalScore дээд хязгаар хэтрэхэд exception")
    void test7_totalScoreExceedingMaxLimitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(11, 40, 10, 10, 30));
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(10, 41, 10, 10, 30));
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(10, 40, 10, 10, 31));
    }

    @ParameterizedTest
    @DisplayName("8. totalScore зөв утгуудыг шалгах parameterized тест")
    @CsvSource({
        "10, 40, 10, 10, 30, 100.0",
        "5, 20, 5, 5, 15, 50.0",
        "0, 0, 0, 0, 0, 0.0"
    })
    void test8_totalScoreValidCasesParameterized(double att, double lab, double q1, double q2, double exam, double expected) {
        assertEquals(expected, calculator.totalScore(att, lab, q1, q2, exam), 0.001);
    }
}
