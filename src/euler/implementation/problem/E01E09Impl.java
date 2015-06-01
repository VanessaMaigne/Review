package problem;

import common.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class E01E09Impl implements E01E09 {

    public E01E09Impl() {
    }

    /**
     * Euler Problem 01 : Multiples of 3 and 5
     * Remove the common multiple of 3 AND 5
     * @param limit
     * @return
     */
    public int getE01(final int limit){
        int result = 0;

        for(int i=0, j=0; i<limit || j<limit; i +=3, j+=5)
        {
            if(i<limit)
                result += i;
            if(j<limit && j%3!=0)
                result += j;
        }
        return result;
    }

    /**
     * Euler Problem 02 : Even Fibonacci numbers
     * @param limit
     * @param fibonacciStart1
     * @param fibonacciStart2
     * @return
     */
    public int getE02(final int limit, int fibonacciStart1, int fibonacciStart2){
        int result = 0;
        int fibo3;

        while(fibonacciStart2 < limit)
        {
            fibo3 = fibonacciStart1 + fibonacciStart2;
            fibonacciStart1 = fibonacciStart2;
            fibonacciStart2 = fibo3;
            if(fibonacciStart1%2==0)
                result += fibonacciStart1;
        }
        return result;
    }

    /**
     * Euler Problem 03 : Largest prime factor
     * @param number
     * @return
     */
    // TODO : NOK
    public long getE03(final long number){
        long result = 1;

        if(Utils.isPrimeNumber(number)) return 1;

        final ArrayList<Long> divisors = Utils.getDivisors(number, false);
        System.out.println("DIVISOER : " + divisors);
        ArrayList<Long> primeDivisors = new ArrayList<Long>();
        for(Long divisor : divisors){
            boolean bob = Utils.isPrimeNumber(divisor);
            if(Utils.isPrimeNumber(divisor))
                primeDivisors.add(divisor);
        }
        System.out.println("PRIME DIVISOER : " + primeDivisors);

//        for(long i=2; i < number; i++){
//            if(number%i == 0 && Utils.isPrimeNumber(i))
//                result = i;
//        }
//        System.out.println(Utils.isPrimeNumber(number));

        return result;

    }

    /**
     * Euler Problem 04 : Largest palindrome product
     * Find with products of all number > 99 : 993*913
     * @param digitNumber
     * @return
     */
    public int getE04(final int digitNumber){
        final double limit = Math.pow(10,digitNumber);
        double i=limit,j;
        ArrayList<Integer> palindromeArray = new ArrayList<Integer>();

        if(digitNumber == 1) return 9;

        while(i >= Math.pow(10,digitNumber-1))
        {
            i--;
            j=i;
            while(j >= Math.pow(10,digitNumber-1))
            {
                j--;
                if(Utils.isPalindromicNumber((int) (i*j)))
                    palindromeArray.add((int) (i*j));
            }
        }

        return palindromeArray.size() > 1 ? Collections.max(palindromeArray) : 0;
    }

    /**
     * Euler Problem 04 : Largest palindrome product
     * Find with all palindrome and check if it is divided by 2 2-digit numbers
     * Find with products of all number > 99 : 993*913
     * @param digitNumber
     * @return
     */
    public int getE04Bis(final int digitNumber){
        final double limit = (Math.pow(10,digitNumber)-1) * (Math.pow(10,digitNumber)-1);
        boolean isPalindrome = false;
        int i= (int) limit;

        while(i >=  0 && !isPalindrome)
        {
            if(Utils.isPalindromicNumber(i) && Utils.has2Factors(i, digitNumber))
                isPalindrome = true;
            i--;
        }
        return i+1;
    }

    /**
     * Euler Problem 05 : Smallest multiple
     * @param limit
     * @return
     */
    public long getE05(final int limit){
        double result = 1;
        HashMap<Long, Integer> allDivisorsAndPower = new HashMap<Long, Integer>();

        for(int i = 1; i<limit; i++){
            HashMap<Long, Integer> divisors = Utils.getPrimeDivisorsAndPowers(i);
            for(Long key : divisors.keySet()){
                if(allDivisorsAndPower.get(key) == null)
                    allDivisorsAndPower.put(key, divisors.get(key));
                else
                    allDivisorsAndPower.put(key, Math.max(allDivisorsAndPower.get(key), divisors.get(key)));
            }
        }

        for(Long key : allDivisorsAndPower.keySet())
            result *= Math.pow(key,allDivisorsAndPower.get(key));
        return (long) result;

    }

    /**
     * Euler Problem 06 : Sum square difference
     * @param limit
     * @param power
     * @return
     */
    public long getE06(final int limit, final int power){
        long powerSum = 0;
        for(int i=1; i<=limit;i++){
            powerSum += Math.pow(i, power);
        }

        long sum = 0;
        for(int i=1; i<=limit; i++)
            sum+=i;

        return (long) (Math.pow(sum, power) - powerSum);
    }

    /**
     * Euler Proble 07 : 10001st prime
     * @param number
     * @return
     */
    public long getE07(final int number){
        long value=2;
        int i=0;

        while(i!= number)
        {
            if(Utils.isPrimeNumber(value))
                i++;
            value++;
        }

        return value-1;
    }

    /**
     * Euler Problem 08 : Largest product in a series
     * @param numberString
     * @return
     */
    public long getE08(final String numberString, final int number){
        if(numberString.length() < number) return 0;

        long max = 1;
        for(int i=0; i < number ; i++){
            max *= Character.getNumericValue(numberString.charAt(i));
        }

        long value = max;
        for(int i=1; i < numberString.length()-number ; i++){
            int previousChar = Character.getNumericValue(numberString.charAt(i-1));
            // Avoid division by 0
            if(previousChar ==0){
                value = 1;
                for(int j=i; j < i+number ; j++)
                    value *= Character.getNumericValue(numberString.charAt(j));
            }
            else
            {
                int nextChar = Character.getNumericValue(numberString.charAt(i-1+number));
                value = value/previousChar*nextChar;
            }
            max = Math.max(max,value);
        }

        return max;
    }

    /**
     * Euler Problem 09 : Special Pythagorean triplet
     * @param value
     * @return
     */
    public long getE09(final int value){
        int a=1,b=2,c=value-a-b;
        boolean isTripletFound = false;
        long result = 0;

        while(a < value && b < value && a < b && b < c && !isTripletFound)
        {
            while(b<value && b < c && !isTripletFound){
                c = value-a-b;
                isTripletFound = Math.pow(a, 2)+Math.pow(b,2) == Math.pow(c,2);
                 if(isTripletFound)
                    result = a*b*c;
                b++;
            }
            a++;
            b=a+1;
            c = value-a-b;
        }

        return result;
    }
}
