import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.shivansh.StringCalculator.StringCalculator;

public class StringCalculatorTest{
  private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void test_givenEmptyString_whenAdded_thenReturnsZero() {
        Assertions.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void test_givenSingleNumberString_whenAdded_thenReturnsNumber() {
        Assertions.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void test_givenMultipleNumberString_whenAdded_thenReturnsNumber() {
        Assertions.assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void test_givenNewLinesBetweenNumbers_whenAdd_thenReturnsSum() {
        Assertions.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void test_givenCustomDelimiter_whenAdd_thenReturnsSum() {
        Assertions.assertEquals(3, stringCalculator.add("//;\n1;2"));
    }



}
