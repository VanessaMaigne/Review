package problem;

import common.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;

public class E20E29Test {

    E20E29 e20E29 = new E20E29Impl();

    @Test
    public void testE20(){
        System.out.print("\ntest E20 ");
        long result = e20E29.getE20(10);
        Assert.assertEquals(result, 27L);
        result = e20E29.getE20(100);
        Assert.assertEquals(result, 648L);
        System.out.print(result);
    }

    @Test
    public void testE21(){
        System.out.print("\ntest E21 ");
        long result = e20E29.functionD(220);
        Assert.assertEquals(result, 284);
        result = e20E29.functionD(284);
        Assert.assertEquals(result, 220);
        result = e20E29.getE21(10000);
        Assert.assertEquals(result, 31626);
        System.out.print(result);
    }

    @Test
    public void testE22(){
        System.out.print("\ntest E22 ");
        long result = e20E29.getScoreName("COLIN");
        Assert.assertEquals(result, 53);
        result = e20E29.getE22("resources/p022_names.txt");
        Assert.assertEquals(result, 871198282);
        System.out.print(result);
    }

    @Test
    public void testE23(){
        System.out.print("\ntest E23 ");
        boolean booleanResult = e20E29.isAbundantNumber(12);
        Assert.assertTrue(booleanResult);
        booleanResult = e20E29.isSumOfTwoAbundantNumber(24);
        Assert.assertTrue(booleanResult);
        long result = e20E29.getE23(28213);
        Assert.assertEquals(result, 4179871);
        System.out.print(result);
    }

    @Test
    public void testE24(){
        System.out.print("\ntest E24 ");
        ArrayList<String> testArray = new ArrayList<String>();
        testArray.add("0");
        testArray.add("1");
        testArray.add("2");
        testArray.add("3");
        String result = e20E29.getFirstElement(14, testArray);
        Assert.assertEquals(result, "2");
        result = e20E29.getFirstElement(7, testArray);
        Assert.assertEquals(result, "1");
        result = e20E29.getFirstElement(20, testArray);
        Assert.assertEquals(result, "3");
        testArray.remove("2");
        result = e20E29.getFirstElement(2, testArray);
        Assert.assertEquals(result, "0");
        result = e20E29.getE24("0 1 2 3", 14);
        Assert.assertEquals(result, "2031");
        result = e20E29.getE24("0 1 2 3", 7);
        Assert.assertEquals(result, "1023");
        result = e20E29.getE24("0 1 2 3 4 5 6 7 8 9", 1);
        Assert.assertEquals(result, "0123456789");
        result = e20E29.getE24("0 1 2 3 4 5 6 7 8 9", 5);
        Assert.assertEquals(result, "0123456978");
        result = e20E29.getE24("0 1 2 3 4 5 6 7 8 9", 999999);
        Assert.assertEquals(result, "2783915406");
        result = e20E29.getE24("0 1 2 3 4 5 6 7 8 9", 1000000);
        Assert.assertEquals(result, "2783915460");
        System.out.print(result);
    }

    @Test
    public void testE25(){
        System.out.print("\ntest E25 ");
        long result = Utils.getFibonacci(12);
        Assert.assertEquals(result, 144);
        BigInteger resultBG = Utils.getFibonacciWithoutRecursive(1);
        Assert.assertEquals(resultBG, new BigInteger("1"));
        resultBG = Utils.getFibonacciWithoutRecursive(2);
        Assert.assertEquals(resultBG, new BigInteger("1"));
        resultBG = Utils.getFibonacciWithoutRecursive(3);
        Assert.assertEquals(resultBG, new BigInteger("2"));
        resultBG = Utils.getFibonacciWithoutRecursive(12);
        Assert.assertEquals(resultBG, new BigInteger("144"));
        int index = e20E29.getE25(3);
        Assert.assertEquals(index, 12);
        index = e20E29.getE25(1000);
        Assert.assertEquals(index, 4782);
        System.out.print(index);
    }

    @Test
    public void testE26(){
        System.out.print("\ntest E26 NOK");
        int number = Utils.getDisplayTimePeriod("68312448344834483", "4483");
        Assert.assertEquals(number, 3);
        String period = Utils.getPeriod("68312448344834483");
        Assert.assertEquals(period, "4483");
        long result = e20E29.getE26(10, 6);
        Assert.assertEquals(result, 7);
//        int numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(14);
//        Assert.assertEquals(numberOfDigitPeriod, 3);
//        numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(8);
//        Assert.assertEquals(numberOfDigitPeriod, 3);
//        numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(6);
//        Assert.assertEquals(numberOfDigitPeriod, 1);
//        numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(7);
//        Assert.assertEquals(numberOfDigitPeriod, 6);
//        numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(4);
//        Assert.assertEquals(numberOfDigitPeriod, 2);
//        numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(3);
//        Assert.assertEquals(numberOfDigitPeriod, 1);
//        result = e20E29.getE26(10);
//        Assert.assertEquals(result, 7);
//        result = e20E29.getE26(1000);
//        Assert.assertEquals(result, );
//        System.out.print(result);
    }

    @Test
    public void testE27(){
        System.out.print("\ntest E27 ");
        long result = e20E29.getNumberPrime(1, 41);
        Assert.assertEquals(result, 40);
        result = e20E29.getNumberPrime(-79, 1601);
        Assert.assertEquals(result, 80);
        result = e20E29.getE27(1000, 1000);
        Assert.assertEquals(result, -59231);
        System.out.print(result);
    }

    @Test
    public void testE28(){
        System.out.print("\ntest E28 ");
        long result = e20E29.getE28(3);
        Assert.assertEquals(result, 25);
        result = e20E29.getE28(5);
        Assert.assertEquals(result, 101);
        result = e20E29.getE28(7);
        Assert.assertEquals(result, 261);
        result = e20E29.getE28(1001);
        Assert.assertEquals(result, 669171001);
        System.out.print(result);
    }

    @Test
    public void testE29(){
        System.out.print("\ntest E29 ");
        long result = e20E29.getE29(5, 5);
        Assert.assertEquals(result, 15);
        result = e20E29.getE29(100, 100);
        Assert.assertEquals(result, 9183);
        System.out.print(result);
    }

}
