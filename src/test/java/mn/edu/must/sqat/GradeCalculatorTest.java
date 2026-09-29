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
    @DisplayName("90 оноо яг А дүн байх ёстой")
    void letterGradeBoundaryExactly90IsA() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой")
    void letterGradeBoundaryJustBelow90IsB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    @DisplayName("Буруу оноонд exception шиднэ")
    void letterGradeInvalidScoreThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(-1.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(100.1));
    }

    @ParameterizedTest
    @DisplayName("letterGrade-ийн хязгааруудыг шалгах")
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
    void letterGradeBoundariesParameterized(double score, String expectedGrade) {
        assertEquals(expectedGrade, calculator.letterGrade(score));
    }

    @Test
    @DisplayName("totalScore хэвийн бодолт")
    void totalScoreValidNormalValues() {
        assertEquals(100.0, calculator.totalScore(10, 40, 10, 10, 30), 0.001);
    }

    @Test
    @DisplayName("totalScore сөрөг утгад exception")
    void totalScoreNegativeValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(-5, 40, 10, 10, 30));
    }

    @Test
    @DisplayName("totalScore дээд хязгаар хэтрэхэд exception")
    void totalScoreExceedingMaxLimitThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.totalScore(10, 41, 10, 10, 30));
    }

    @ParameterizedTest
    @DisplayName("totalScore parameterized тест")
    @CsvSource({
        "10, 40, 10, 10, 30, 100.0",
        "5, 20, 5, 5, 15, 50.0",
        "0, 0, 0, 0, 0, 0.0"
    })
    void totalScoreValidCasesParameterized(double att, double lab, double q1, double q2, double exam, double expected) {
        assertEquals(expected, calculator.totalScore(att, lab, q1, q2, exam), 0.001);
    }
}
