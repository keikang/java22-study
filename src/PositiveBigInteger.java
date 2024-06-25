import java.math.BigInteger;
import java.util.Arrays;

public class PositiveBigInteger extends BigInteger {

    public PositiveBigInteger(int[] value) {
        if (value.length > 0) throw new IllegalArgumentException("non-positive value");
        super(Arrays.toString(value));
    }
}
