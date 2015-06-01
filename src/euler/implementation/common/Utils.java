package common;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Utils {

    /** Algorithm founded at http://www.gecif.net/articles/mathematiques/nombres_premiers/ **/
    public static boolean isPrimeNumber(final Long number){
        if(number == 2) return true;
        if(number == 0 || number == 1 || number % 2 == 0) return false;

        boolean isPrime = false;
        boolean stopLoop = false;
        int a = 3;

        while(a <= number && !isPrime && !stopLoop){
            if(a >= Math.sqrt(number) +1)
                isPrime = true;
            if(number % a == 0)
                stopLoop = true;
            a=a+2;
        }
        return isPrime;
    }

    /** This method return the divisors not necessary prime factor **/
    public static ArrayList<Long> getDivisors(long number, boolean insertExtremum){

        ArrayList divisors = new ArrayList();
        Long inf = 1L;
        if (insertExtremum)
            inf = 2L;

        for(Long i = inf; i < Math.sqrt(number)+1;i++){
            long remainder = number%i;
            long quotient = number / i;
            if(remainder == 0){
                if(quotient >= i)
                    divisors.add(i);
                if(quotient > i)
                    divisors.add(number / i);
            }
        }
        return divisors;


//    def divisors(nb, extremum = False):
//    divisors = []
//    inf = 1 if extremum else 2

//            for i in range(inf, int(nb**0.5)+1):
//    q, r = divmod(nb, i)
//    if r == 0:
//            if q >= i:
//            divisors.append(i)
//            if q > i:
//            divisors.append(nb//i)
//    return divisors
    }

    /** This method returns an array of prime factors of number */
    public static ArrayList<Long> getPrimeDivisors(long number){
        ArrayList<Long> primeDivisors = new ArrayList<Long>();
        ArrayList<Long> divisors = getDivisors(number, false);
        for(long divisor : divisors)
        {
            if(isPrimeNumber(divisor))
                primeDivisors.add(divisor);
        }
        return primeDivisors;
    }

    /** This method returns a hashMap of prime factors of number and their power */
    /* y=x^n   ->   ln(y)=ln(x^n)   ->    ln(y)=nln(x)    ->     n=ln(y)/ln(x)  */
    public static HashMap<Long, Integer> getPrimeDivisorsAndPowers(long number){
        HashMap<Long, Integer> primeDivisorsAndPowers = new HashMap<Long, Integer>();
        ArrayList<Long> divisors = getPrimeDivisors(number);
        for(long divisor : divisors)
        {
            int power = getPower(number, divisor);
            primeDivisorsAndPowers.put(divisor, power);
        }
        return primeDivisorsAndPowers;
    }

    /** This method return the power of a divisor */
    public static int getPower(long number, long divisor){
        double power = (Math.log(number)/Math.log(10))/(Math.log(divisor)/Math.log(10));
        if(power == (int) power)
            return (int)power;
        else {
            int i=0;
            while(number % divisor ==0)
            {
                i++;
                number = number / divisor;
            }
            return i;
        }
    }

    /** This method check if number is a palindrome **/
    public static boolean isPalindromicNumber(final int number){
        boolean isPalindrome = true;
        final String numberStr = String.valueOf(number);
        int i=0;

        while(i < numberStr.length()/2 && isPalindrome){
            char firstChar = numberStr.charAt(i);
            char lastChar = numberStr.charAt(numberStr.length()-1-i);
            isPalindrome = firstChar == lastChar;
            i++;
        }

        return isPalindrome;
    }

    /** This method check if the number is a digitNumer-number **/
    public static boolean isDigitNumber(final int number, final int digitNumber){
        return String.valueOf(number).length() == digitNumber;
    }

    /** This method check if number has 2 digitNumber-digit factors */
    public static boolean has2Factors(final int number, final int digitNumber){
        if(digitNumber <1) return false;
        int i= (int) (Math.pow(10,digitNumber-1)+1);
        int limit = (int) (Math.pow(10,digitNumber+1)-1);
        boolean has2Factors = false;
        while(i < Math.sqrt(number)+1 && i<limit && !has2Factors){
            int remainder = number%i;
            int quotient = number / i;
            has2Factors = (remainder == 0 && isDigitNumber(quotient, digitNumber) && isDigitNumber(i, digitNumber));
            i++;
        }
        return has2Factors;
    }

    /** This method return the factorial value **/
    public static BigInteger factorial(long n) {
        BigInteger result = new BigInteger("1");
        for (long i = 1; i <= n; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }

    public static int factorialForInt(int n) {
        int result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long getFibonacci(final long n){
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;

        return getFibonacci(n-1) + getFibonacci(n-2);
    }

    public static BigInteger getFibonacciWithoutRecursive(final long n){
        if(n==0)
            return new BigInteger("0");
        if(n==1 || n==2)
            return new BigInteger("1");

        BigInteger fibonacciN = new BigInteger("0");
        BigInteger fibonacciNN = new BigInteger("1");
        long i=3;
        while(i <= n)
        {
            BigInteger fibo = fibonacciN;
            fibonacciN = fibonacciNN;
            fibonacciNN = fibo.add(fibonacciNN);
            i++;
        }

        return fibonacciN.add(fibonacciNN);
    }

    public static String getPeriod(final String str){
        int i=str.length()-1;
        String subStr = str.substring(i, str.length());
        String period = subStr;
        while(i>=0 && getDisplayTimePeriod(str, subStr) > 1 && (str.lastIndexOf(subStr) == str.length() - subStr.length()))
        {
            period = str.substring(i, str.length());
            i--;
            subStr = str.substring(i, str.length());
        }

        if(i==str.length() -1)
            return str;
        else if(Utils.getDisplayTimePeriod(period, period.substring(0, 1)) == period.length())
            return period.substring(0, 1);
        else
            return period;
    }

    public static int getDisplayTimePeriod(String str, final String period){
        int result = 0;
        boolean isContained = str.contains(period);
        while(isContained)
        {
            result ++;
            str = str.replaceFirst(period, "");
            isContained = str.contains(period);
        }
        return result;
    }

    // http://www.mathblog.dk/project-euler-26-find-the-value-of-d-1000-for-which-1d-contains-the-longest-recurring-cycle/
    public static int getNumberOfDigitPeriodWithRemainder(long number){
        int numberOfDigitInPeriod = 0;
        long remainder = 10;
        long oldRemainder = 0;
        while(number%remainder == number){
            remainder *=10;
            numberOfDigitInPeriod++;
        }

        while(remainder%number !=1 && oldRemainder!=remainder){
            oldRemainder = remainder;
            remainder = 10*(remainder%number);
            numberOfDigitInPeriod ++;
        }

        if(oldRemainder == remainder)
            numberOfDigitInPeriod --;
        else
            numberOfDigitInPeriod ++;
        return numberOfDigitInPeriod;

//        int sequenceLength = 0;
//
//        for (int i = 10; i > 1; i--) {
////        for (int i = 1; i < 1000; i++) {
//            if (sequenceLength >= i) {
//                break;
//            }
//
//            int[] foundRemainders = new int[i];
//            int value = 1;
//            int position = 0;
//
//            while (foundRemainders[value] == 0 && value != 0) {
//                foundRemainders[value] = position;
//                value *= 10;
//                value %= i;
//                position++;
//            }
//
//            if (position - foundRemainders[value] > sequenceLength) {
//                sequenceLength = position - foundRemainders[value];
//            }
//        }
//        return sequenceLength;
    }
}
