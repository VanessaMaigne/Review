package problem;

import common.Utils;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E20E29Impl implements E20E29{

    /**
     * Euler Problem 20 : Factorial digit sum
     */
    public long getE20(final long number){
        BigInteger factorial = Utils.factorial(number);
        String valueStr = factorial.toString();
        long result = 0;
        for(int i=0; i<valueStr.length(); i++){
            if(Character.getNumericValue(valueStr.charAt(i)) > 0)
                result += Character.getNumericValue(valueStr.charAt(i));
        }
        return result;
    }


    /**
     * Euler Problem 21 : Amicable numbers
     */
    public long getE21(final long number){
        long result = 0;
        ArrayList<Long> amicableNumbers = new ArrayList<Long>();
        long a=1;
        while(a<number){
            if(!amicableNumbers.contains(a)){
                long b = functionD(a);
                long c = functionD(b);
                if(c == a && a != b){
                    amicableNumbers.add(a);
                    amicableNumbers.add(b);
                }
            }
            a++;
        }

        // Calcul sum
        for(Long amicableNumber : amicableNumbers )
            result+=amicableNumber;

        return result;
    }

    public long functionD(final long value){
        ArrayList<Long> divisors = Utils.getDivisors(value, true);
        long sum = 1; // To add divisor 1
        for(Long divisor : divisors){
            sum += divisor;
        }
        return sum;
    }


    /**
     * Euler Problem 22 : Names scores
     */
    public long getE22(final String filePath){
        long result = 0;
        try {
            // Read file
            FileInputStream fis = new FileInputStream(new File(filePath));
            String content = "";
            while (fis.available() > 0) {
                content += (char) fis.read();
            }

            // Content to String array
            String[] names = content.replaceAll("\"", "").split(",");
            Arrays.sort(names);

            for(int i=0; i<names.length; i++){
                result += getScoreName(names[i])*(i+1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error to find file : "+filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error to read file : "+filePath);
            e.printStackTrace();
        }

        return result;
    }

    // Return the sum of position of all chars in alphabet
    public long getScoreName(final String name){
        long result = 0;
        final String alphabet="abcdefghijklmnopqrstuvwxyz".toUpperCase();
        for(char charValue : name.toCharArray()){
            result += alphabet.indexOf(charValue)+1;
        }
        return result;
    }


    /**
     * Euler Problem 23 : Non-abundant sums
     */
    public long getE23(final long limit){
        long result = 0;
        for(long i=1; i<limit; i++){
            boolean isSumOfAbundantNumber = isSumOfTwoAbundantNumber(i);
            if(!isSumOfAbundantNumber)
                result += i;
        }

        return result;
    }

    public boolean isAbundantNumber(final long number){
        if(number < 12) return false;
        long sum = 1;
        ArrayList<Long> divisors = Utils.getDivisors(number, true);
        for(Long divisor : divisors){
            sum += divisor;
        }
        return sum > number;
    }

    public boolean isSumOfTwoAbundantNumber(final long number){
        if(number < 24) return false;
        boolean isSum = false;
        long i=12;
        while (!isSum && i<=number){
            isSum = isAbundantNumber(i) && isAbundantNumber(number - i);
            i++;
        }
        return isSum;
    }


    /**
     * Euler Problem 24 : Lexicographic permutations
     * http://www.mathblog.dk/project-euler-24-millionth-lexicographic-permutation/
     */
    public String getE24(final String numberStr, int position){
        String result = "";

        ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(numberStr.split(" ")));
        final int limit = numbers.size();
        for(int i=0; i<limit; i++){
            String element = "";

            if(numbers.size() <= 1){
                element = numbers.get(0);

            } else {
                int factorial = Utils.factorialForInt(numbers.size() - 1);
                if(factorial == 1 && position > 0){
                    element = numbers.get(position - 1);
                } else if(position > factorial){
                    if(position%factorial == 0){ // Last element of the line
                        element = numbers.get(position / factorial -1);
                        position = factorial;
                    }
                    else {
                        element = numbers.get(position / factorial);
                        position = (position%factorial);
                    }
                }
                else
                    element = numbers.get(0);
            }

            result += element;
            numbers.remove(element);
        }

        return result;
    }

    public String getFirstElement(final int position, final List<String> list){
        int factorial = Utils.factorialForInt(list.size() - 1);
        if(position > factorial)
            return list.get(position / factorial);
        else
            return list.get(0);
    }


    /**
     * Euler Problem 25 : 1000-digit Fibonacci number
     */
    public int getE25(final int digitNumber){
        int i=0;
        boolean hasDigitNumber = false;

        while(!hasDigitNumber){
//            long number = Utils.getFibonacci(i);
            BigInteger number = Utils.getFibonacciWithoutRecursive(i);
            hasDigitNumber = String.valueOf(number).length() == digitNumber;
            i++;
        }
        return i-1;
    }


    /**
     * Euler Problem 26 : Reciprocal cycles
     * period : groupe de chiffres qui se répète dans la partie décimale de ce nombre.
     * --> https://www.netmaths.net/lexique/p%C3%A9riode
     * Problem with the decimal precision in BigDecimal which will change the end of the period
     * http://www.mathblog.dk/project-euler-26-find-the-value-of-d-1000-for-which-1d-contains-the-longest-recurring-cycle/
     */
    public long getE26(final long limit, final int precision){
        long max = 0;
        long result = 0;
        for(long i=2; i<=limit; i++){
//            float value = (float) (1./i);
            BigDecimal value = new BigDecimal("1").divide(new BigDecimal(i), precision, BigDecimal.ROUND_FLOOR).stripTrailingZeros();
            String valueStr = value.toPlainString();
            String fractionalStr = valueStr.substring(valueStr.indexOf('.')+1);

            String period = Utils.getPeriod(fractionalStr);
            long size = Math.max(max, period.length());
            if(size == period.length()){
                max = size;
                result = i;
            }
        }
        return result;
    }

    public long getE26(final long limit){
        long max = 0;
        long result = 0;
        for(long i=2; i<=limit; i++){
            int numberOfDigitPeriod = Utils.getNumberOfDigitPeriodWithRemainder(i);

            long size = Math.max(max, numberOfDigitPeriod);
            if(size == numberOfDigitPeriod){
                max = size;
                result = i;
            }
        }

        return result;
    }


    /**
     * Euler Problem 27 : Quadratic primes
     */
    public long getE27(final long limitA, final long limitB){
        long max = 0;
        long resultA = 0;
        long resultB = 0;

        for(long a=-limitA; a<limitA; a++){
            for(long b=-limitB; b <limitB; b++){
                long numberPrime = getNumberPrime(a, b);
                max = Math.max(max, numberPrime);
                if(max == numberPrime){
                    resultA = a;
                    resultB = b;
                }
            }
        }

        return resultA * resultB;
    }

    public long getNumberPrime(final long a, final long b){
        long n=0;
        long numberPrime = 0;
        long value = n*n + a*n + b;
        while(Utils.isPrimeNumber(value)){
            value = n*n + a*n + b;
            n++;
            numberPrime++;
        }
        if(numberPrime != 0)
            numberPrime--;
        return numberPrime;
    }


    /**
     * Euler Problem 28 : Number spiral diagonals
     */
    public long getE28(final int spiralSize){
        long result = 0;
        long lastNumber = 1;
        for(int i=3; i<=spiralSize; i+=2){
            for(long j=lastNumber; j<i*i; j+=i-1){
                result += j;
            }
            lastNumber = i*i;
        }
        result += lastNumber;
        return result;
    }


    /**
     * Euler Problem 29 : Distinct powers
     */
    public long getE29(final int limitA, final int limitB){
        long result = 0;

        List<BigInteger> numbers = new ArrayList<BigInteger>();
        for(int a=2; a<=limitA; a++)
            for(int b=2; b<=limitB; b++){
                BigInteger value = BigInteger.valueOf(a).pow(b);
                if(!numbers.contains(value))
                    numbers.add(value);
        }

        return numbers.size();
    }
}
