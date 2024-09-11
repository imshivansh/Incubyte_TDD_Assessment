import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.shivansh.StringCalculator.StringCalculator;

public class StringCalculatorTest{
  private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void testEmptyStringReturnsZero(){
        Assertions.assertEquals(0,stringCalculator.add(""));
    }
}
