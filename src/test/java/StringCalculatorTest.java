import org.junit.jupiter.api.*;
import org.shivansh.StringCalculator.StringCalculator;

public class StringCalculatorTest{
    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("Testing Empty String")
    public void test_givenEmptyString_whenAdded_thenReturnsZero() {
        Assertions.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @DisplayName("Testing Single Digit String")
    public void test_givenSingleNumberString_whenAdded_thenReturnsNumber() {
        Assertions.assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    @DisplayName("Testing Multiple Digit String")
    public void test_givenMultipleNumberString_whenAdded_thenReturnsNumber() {
        Assertions.assertEquals(3, stringCalculator.add("1,2"));
        Assertions.assertEquals(2,stringCalculator.add("1000,2"));
    }

    @Test
    @DisplayName("Testing new line between numbers")
    public void test_givenNewLinesBetweenNumbers_whenAdded_thenReturnsSum() {
        Assertions.assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    @DisplayName("Testing Custom Delimiter String")
    public void test_givenCustomDelimiter_whenAdded_thenReturnsSum() {
        Assertions.assertEquals(3, stringCalculator.add("//;\n1;2"));
        Assertions.assertEquals(6, stringCalculator.add("//|\n1|2|3"));
        Assertions.assertEquals(8, stringCalculator.add("//***\n1***2***3\n2"));
        Assertions.assertEquals(6,stringCalculator.add("//[***]\n1***2***3"));
        Assertions.assertEquals(6,stringCalculator.add("//[*][%]\\n1*2%3"));

    }

    @Test
    @DisplayName("Testing Negative number String")
    public void test_givenNegativeNumbers_whenAdded_thenThrowsExceptionWithAllNegatives() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.add("1,-2,3,-4");
        });
        Assertions.assertEquals("Negative numbers not allowed: -2,-4", exception.getMessage());
    }


}
