package problem;

import com.sun.tools.javac.util.Pair;
import common.Utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class E10E19Impl implements E10E19 {

    /**
     * Euler Problem 10 : Summation of primes
     */
    public long getE10(final long number){
        long result = 2;
        for(long i=3; i < number ; i+=2){
            if(Utils.isPrimeNumber(i))
                result += i;
        }
        return result;
    }

    /**
     * Euler Problem 10 : Summation of primes
     * With Eratosthène crible : http://fr.wikipedia.org/wiki/Crible_d'%C3%89ratosth%C3%A8ne
     * Much faster solution !
     */
    public long getE10Bis(final long number){
        ArrayList<Long> numbers = new ArrayList<Long>();
        for(long i=3; i <= number; i+=2)
            numbers.add(i);

        ArrayList<Long> primeFactors = new ArrayList<Long>();
        primeFactors.add(2L);
        primeFactors = reduceArray(number, numbers, primeFactors);

        long result = 0;
        for(Long primeFactor : primeFactors)
            result += primeFactor;

        return result;
    }

    private ArrayList<Long> reduceArray(final long number, ArrayList<Long> numbers, ArrayList<Long> primeFactors){
        if(numbers.size() < 1)
            return primeFactors;
        if(Math.pow(numbers.get(0), 2) > numbers.get(numbers.size()-1)){
            primeFactors.addAll(numbers);
            return primeFactors;
        }

        for(Long numb : numbers){
            if(Utils.isPrimeNumber(numb)){
                primeFactors.add(numb);
                ArrayList<Long> newNumbers = new ArrayList<Long>();
                for(long i=numb; i<= number; i+=2)
                    if(i%numb != 0)
                        newNumbers.add(i);
                return reduceArray(number, newNumbers, primeFactors);
            }
        }

        return primeFactors;
    }


    /**
     * Euler Problem 11 : Largest product in a grid
     */
    public long getE11(final String grid, final int number){
        HashMap<Pair, Long> map = new HashMap<Pair, Long>();

        // Fill grid
        String[] rows = grid.split("\n");
        String[] cols = new String[0];
        for(int i=0; i<rows.length ; i++){
            cols = rows[i].split(" ");
            for(int j=0; j<cols.length; j++){
                Pair<Integer, Integer> position = new Pair<Integer, Integer>(i+1,j+1);
                map.put(position, Long.valueOf(cols[j]));
            }
        }

        // Read grid
        long max = 1;
        long valueStart = 1;

        // Left & right
        for(int i=1; i<=rows.length ; i++){
            valueStart = 1;
            for(int j=1; j<=cols.length-number+1 ; j++){
                valueStart = 1;
                for(int k=0; k< number; k++){
                    long value = map.get(new Pair(i,j+k));
                    valueStart *= value;
                }
                max = Math.max(max, valueStart);
            }
        }

        // Up & down
        for(int j=1; j<=cols.length ; j++){
            valueStart = 1;
            for(int i=1; i<=cols.length-number+1 ; i++){
                valueStart = 1;
                for(int k=0; k< number; k++){
                    long value = map.get(new Pair(i+k,j));
                    valueStart *= value;
                }
                max = Math.max(max, valueStart);
            }
        }

        // Diagonally up/left to down/right
        for(int i=1; i<=rows.length-number+1 ; i++){
            valueStart = 1;
            for(int j=1; j<=cols.length-number+1 ; j++){
                valueStart = 1;
                for(int k=0; k< number; k++){
                    long value = map.get(new Pair(i+k,j+k));
                    valueStart *= value;
                }
                max = Math.max(max, valueStart);
            }
        }

        // Diagonally up/right to down/left
        for(int i=1; i<=rows.length-number+1 ; i++){
            valueStart = 1;
            for(int j=cols.length; j>=number ; j--){
                valueStart = 1;
                for(int k=0; k< number; k++){
                    long value = map.get(new Pair(i+k,j-k));
                    valueStart *= value;
                }
                max = Math.max(max, valueStart);
            }
        }

        return max;
    }


    /**
     * Euler Problem 12 : Highly divisible triangular number
     */
    public long getE12(final int number){
        boolean hasNumberDivisor = false;
        int i=1;
        long triangle = 0;

        while(!hasNumberDivisor){
            triangle +=i;
            ArrayList<Long> divisors = Utils.getDivisors(triangle, false);
            hasNumberDivisor = divisors.size() >= number;
            i++;
        }
        return triangle;
    }


    /**
     * Euler Problem 13 : Large sum
     */
    public String get13(final String numberStr){
        String[] numbers = numberStr.split("\n");
        BigInteger sum = new BigInteger("0");
        for(String number : numbers){
            sum = sum.add(new BigInteger(number));
        }
        return sum.toString().substring(0,10);
    }


    /**
     * Euler Problem 14 : Longest Collatz sequence
     */
    public long getE14(final int limit){
        int number = 0;
        long value;
        int max = 0, newMax = 0;
        long result = 0;

        for(long i=1; i<limit; i++){
            value = i;
            number = 0;
            while(value != 1){
                if(value % 2 == 0)
                    value = value/2;
                else
                    value = 3*value+1;
                number++;
            }
            newMax = Math.max(max, number);
            if(newMax == number)
                result = i;
            max = newMax;
        }
        return result;
    }


    /**
     * Euler Problem 15 : Lattice paths
     * Use of binomial rule --> http://blog.lucaswillems.com/1103/project-euler-probleme-15
     */
    public BigInteger getE15(final int gridSize){
        BigInteger combinatorialUpValue = Utils.factorial(2 * gridSize);
        BigInteger combinatorialDownValue = Utils.factorial(gridSize);
        return combinatorialUpValue.divide(combinatorialDownValue.multiply(combinatorialDownValue));


//        int i=1, j=1;

//        List<List<Pair<Integer, Integer>>> allPairs = new ArrayList<List<Pair<Integer, Integer>>>();
//        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();

        // Fill first line
//        while(i<=gridSize+1){
//            Pair pair = new Pair(i,j);
//            if(!pairs.contains(pair))
//                pairs.add(pair);
//            else if(j<=gridSize)
//                j++;
//            else if(i<=gridSize)
//                i++;
//            if(i==gridSize+1 && j==gridSize+1){
//                pair = new Pair(i,j);
//                pairs.add(pair);
//                allPairs.add(pairs);
//                i++;
//            }
//        }

        // Fill other lines
//        boolean isLastLine = !isLastLine(pairs, gridSize);
//        while(!isLastLine){
//            ArrayList<Pair<Integer, Integer>> newPairs = changeLine(pairs, gridSize);
//            allPairs.add(newPairs);
//            pairs = newPairs;
//            isLastLine = !isLastLine(pairs, gridSize);
//        }
//
//        return allPairs.size();
    }

    // Not use : for practice
    private ArrayList<Pair<Integer, Integer>> changeLine(ArrayList<Pair<Integer, Integer>> pairs, final int gridSize){
        int k=0;
        ArrayList<Pair<Integer, Integer>> changedPairs = new ArrayList<Pair<Integer, Integer>>();
        boolean isLineFullChanged = false;
        while(k<pairs.size() && !isLineFullChanged){
            if(pairs.get(k).snd == gridSize+1 && pairs.get(k).fst < gridSize+1){
                int i = pairs.get(k).fst+1;
                int j = pairs.get(k).snd-1;
                for(int kk=k; kk<pairs.size(); kk++){
                    Pair pair = new Pair(i,j);
                    changedPairs.add(pair);
                    if(j<=gridSize)
                        j++;
                    else if(i<=gridSize)
                        i++;
                    if(i==gridSize+1 && j==gridSize+1){
                        pair = new Pair(i,j);
                        changedPairs.add(pair);
                        kk++;
                        isLineFullChanged = true;
                    }
                }
            } else {
                Pair pair = pairs.get(k);
                changedPairs.add(pair);
            }
            k++;
        }
        return changedPairs;
    }

    // Not use : for practice
    private boolean isLastLine(ArrayList<Pair<Integer, Integer>> pairs, final int gridSize){
        boolean isLastLine = false;
        int i=0;
        int firstElementValue = pairs.get(i).fst;
        while(!isLastLine && i<pairs.size()){
            i++;
            isLastLine = firstElementValue+1 != pairs.get(i).fst;
            firstElementValue = pairs.get(i).fst;
        }

        return isLastLine;
    }


    /**
     * Euler Problem 16 : Power digit sum
     * Not Understood : I find 2^1000 = 10715086071862673200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
     * And result = 68, no 1366
     */
    public long getE16(final int number, final int power){
        BigDecimal value = BigDecimal.valueOf(Math.pow(number, power));
        String valueStr = value.toPlainString();
        long result = 0;
        for(int i=0; i<valueStr.length(); i++){
            if(Character.getNumericValue(valueStr.charAt(i)) > 0)
                result += Character.getNumericValue(valueStr.charAt(i));
        }
        return result;
    }


    /**
     * Euler Problem 17 : Number letter counts
     * Choose not to do
     */


    /**
     * Euler Problem 18 : Maximum path sum I
     */
    public long getE18(final String triangleStr){
        String[] triangleArray = triangleStr.split("\n");
        HashMap<Pair<Integer, Integer>, Long> map = new HashMap<Pair<Integer, Integer>, Long>();

        // Fill map
        for(int i= 0; i< triangleArray.length; i++){
            String[] triangleValues = triangleArray[i].split(" ");
            for(int j=1; j<=i+1; j++){
                Pair position = new Pair(i+1,j);
                map.put(position, Long.parseLong(triangleValues[j - 1]));
            }
        }

        // Find max : if we have to get from top to down
//        long result = map.get(new Pair<Integer, Integer>(1,1));
//        ArrayList<Long> bob = new ArrayList<Long>();
//        int j=1;
//        bob.add(result);
//        for(int i=2; i<=triangleArray.length; i++){
//            long value1 = map.get(new Pair<Integer, Integer>(i,j));
//            long value2 = map.get(new Pair<Integer, Integer>(i,j+1));
//            long max = Math.max(value1, value2);
//            bob.add(max);
//            if(max == value2)
//                j++;
//            result += max;
//        }

        // Find max for all possibilities : we start with the n-1 line and replace each value by the possible max with the n line
        for(int i=triangleArray.length-1; i>0; i--){
            for(int j=1; j<=i; j++){
                long value1 = map.get(new Pair<Integer, Integer>(i + 1, j));
                long value2 = map.get(new Pair<Integer, Integer>(i+1,j+1));
                long value = map.get(new Pair<Integer, Integer>(i, j));
                map.put(new Pair(i,j), Math.max(value1, value2)+value);
            }
        }
        return map.get(new Pair(1,1));
    }


    /**
     * Euler Problem 19 : Counting Sundays
     */
    public int getE19(final Calendar beginDate, final Calendar endDate){
        int result = 0;
        Calendar date = beginDate;
        while(date.before(endDate)){
            if(date.get(Calendar.DAY_OF_WEEK) == 1)
                result++;
            date.add(Calendar.MONTH, 1);
        }

        return result;
    }
}
