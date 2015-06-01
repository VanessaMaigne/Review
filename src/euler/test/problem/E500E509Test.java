package problem;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class E500E509Test {

    E500E509Impl e500E509 = new E500E509Impl();

    @Test
    public void testE505(){
        System.out.print("\ntest E505 ");
        double result = e500E509.functionX(2);
        Assert.assertEquals(result, 3.0, 0);
        result = e500E509.functionX(3);
        Assert.assertEquals(result, 2.0, 0);
        result = e500E509.functionX(4);
        Assert.assertEquals(result, 11.0, 0);
        result = e500E509.functionY(4, 4);
        Assert.assertEquals(result, 11.0, 0);
        result = e500E509.functionY(4, 3);
        Assert.assertEquals(result, Math.pow(2, 60) - 9, 0);
        result = e500E509.functionY(4, 2);
        Assert.assertEquals(result, Math.pow(2, 60) - 12, 0);
//        result = e500E509.functionY(4, 1);
//        Assert.assertEquals(result, 8.0, 0);
//        result = e500E509.getE505(4);
//        Assert.assertEquals(result, 8.0, 0);
//        result = e500E509.getE505(10);
//        Assert.assertEquals(result, Math.pow(2, 60)-34, 0);
//        result = e500E509.getE505(Math.pow(10,3));
//        Assert.assertEquals(result, 101881.0, 0);
//        result = e500E509.getE505(Math.pow(10, 12));
//        Assert.assertEquals(result, 648L);
//        System.out.print(result);

        BigDecimal resultBG = e500E509.functionXWithBD(new BigDecimal("2"));
        Assert.assertEquals(resultBG, new BigDecimal("3"));
        resultBG = e500E509.functionXWithBD(new BigDecimal("3"));
        Assert.assertEquals(resultBG, new BigDecimal("2"));
        resultBG = e500E509.functionXWithBD(new BigDecimal("4"));
        Assert.assertEquals(resultBG, new BigDecimal("11"));
        resultBG = e500E509.functionYWithBD(new BigDecimal("4"), new BigDecimal("4"));
        Assert.assertEquals(resultBG, new BigDecimal("11"));
        resultBG = e500E509.functionYWithBD(new BigDecimal("4"), new BigDecimal("3"));
        Assert.assertEquals(resultBG, new BigDecimal("2").pow(60).subtract(new BigDecimal("9")));
        resultBG = e500E509.functionYWithBD(new BigDecimal("4"), new BigDecimal("2"));
        Assert.assertEquals(resultBG, new BigDecimal("2").pow(60).subtract(new BigDecimal("12")));
        resultBG = e500E509.functionYWithBD(new BigDecimal("4"), new BigDecimal("1"));
        Assert.assertEquals(resultBG, new BigDecimal("8"));
        resultBG = e500E509.getE505WithBD(new BigDecimal("4"));
        Assert.assertEquals(resultBG, new BigDecimal("8"));
        resultBG = e500E509.getE505WithBD(new BigDecimal("10"));
        Assert.assertEquals(resultBG, new BigDecimal("2").pow(60).subtract(new BigDecimal("34")));
        resultBG = e500E509.getE505WithBD(new BigDecimal("10").pow(3));
        Assert.assertEquals(resultBG, new BigDecimal("101881"));
        resultBG = e500E509.getE505WithBD(new BigDecimal("10").pow(12));
//        Assert.assertEquals(resultBG, 648L);
        System.out.print(result);

    }

}
