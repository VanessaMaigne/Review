package problem;

import common.Utils;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class E01E09Test extends TestCase {

    final E01E09 e0109 = new E01E09Impl();

    @Test
    public void testE01()
    {
        System.out.print("test E01 ");
        Integer result = e0109.getE01(1000);
        Assert.assertEquals(result, (Integer)233168);
        System.out.print(result);
    }

    @Test
    public void testE02()
    {
        System.out.print("\ntest E02 ");
        Integer result = e0109.getE02(90, 1, 2);
        Assert.assertEquals(result, (Integer) 44);
        result = e0109.getE02(4000000, 1, 2);
        Assert.assertEquals(result, (Integer)4613732);
        System.out.print(result);
    }

    @Test
    public void testE03()
    {
        System.out.print("\ntest E03 NOK");
//        E01E09Impl e0109 = new E01E09Impl();
//        assertTrue(Utils.isPrimeNumber(13L));
//        assertFalse(Utils.isPrimeNumber(1L));
//        assertTrue(Utils.isPrimeNumber(2L));
//        assertFalse(Utils.isPrimeNumber(25L));

//        long result = e0109.getE03(13195L);
//        Assert.assertEquals(result, 29);
//        System.out.print(result+", ");
//        result = e0109.getE03(600851475143L);
//        Assert.assertEquals(result, (Integer)29);
//        System.out.print(result);

    }

    @Test
    public void testE04(){
        System.out.print("\ntest E04 ");
        assertTrue(Utils.isPalindromicNumber(99));
        assertFalse(Utils.isPalindromicNumber(98657));
        assertTrue(Utils.isPalindromicNumber(8765678));
        int result = e0109.getE04(2);
        Assert.assertEquals(result, 9009);
        result = e0109.getE04(3);
        Assert.assertEquals(result, 906609);
        System.out.print(result);
        result = e0109.getE04Bis(3);
        Assert.assertEquals(result, 906609);
    }

    @Test
    public void testE05(){
        System.out.print("\ntest E05 ");
        assertTrue(Utils.isPrimeNumber(13L));
        assertFalse(Utils.isPrimeNumber(1L));
        assertTrue(Utils.isPrimeNumber(2L));
        assertFalse(Utils.isPrimeNumber(25L));
        assertTrue(Utils.isPrimeNumber(3L));

        long result = e0109.getE05(10);
        Assert.assertEquals(result, 2520);
        result = e0109.getE05(20);
        Assert.assertEquals(result, 232792560);
        System.out.print(result);
    }

    @Test
    public void testE06(){
        System.out.print("\ntest E06 ");
        long result = e0109.getE06(10, 2);
        Assert.assertEquals(result, 2640);
        result = e0109.getE06(100, 2);
        Assert.assertEquals(result, 25164150);
        System.out.print(result);
    }

    @Test
    public void testE07(){
        System.out.print("\ntest E07 ");
        long result = e0109.getE07(6);
        Assert.assertEquals(result, 13);
        result = e0109.getE07(10001);
        Assert.assertEquals(result, 104743);
        System.out.print(result);
    }

    @Test
    public void testE08(){
        System.out.print("\ntest E08 ");
        final String numberString = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843" +
                "858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113" +
                "622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776" +
                "657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482" +
                "839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586" +
                "178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188" +
                "845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
        long result = e0109.getE08(numberString, 4);
        Assert.assertEquals(result, 5832);
        result = e0109.getE08(numberString, 13);
        Assert.assertEquals(result, 23514624000L);
        System.out.print(result);
    }

    @Test
    public void testE09(){
        System.out.print("\ntest E09 ");
        long result = e0109.getE09(12);
        Assert.assertEquals(result, 60);
        result = e0109.getE09(1000);
        Assert.assertEquals(result, 31875000);
        System.out.print(result);
    }
}