import org.junit.Assert;
import org.junit.Test;
import io.javaclasses.stringCalculation.parsers.StringToNumber;
public final class NumberFiniteStateMachineLongRunningUnitTest {

    @Test
    public void parseStringToNumber() {
        String string = "-145.6704kk973hy";
        StringToNumber result = new StringToNumber();
        double res = result.parse(string);
        System.out.println( new StringToNumber().parse(string));
        Assert.assertEquals(-145.6704, result.parse(string), 4 );
    }

}