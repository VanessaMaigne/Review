package problem;

import java.util.ArrayList;
import java.util.List;

public class E230239Impl implements E303E39{

    /**
     * Euler Problem 30 : Digit fifth powers
     * To find the max limit number
     * --> http://theburningmonk.com/2010/09/project-euler-problem-30-solution/
     * -->http://www.mathblog.dk/project-euler-30-sum-numbers-that-can-be-written-as-the-sum-fifth-powers-digits/
     */

    public long getE30(final int power){
        long result = 0;
        long limit = getLimitNumber(power);

        for(long number = 2; number<limit; number++ ){
            char[] numbers = String.valueOf(number).toCharArray();
            long value = 0;
            for(char numberChar : numbers)
                value += Math.pow(Character.getNumericValue(numberChar), power);

            if(value == number)
                result += value;
        }

        return result;
    }

    public long getLimitNumber(final int power){
        int powerValue = 1;
        boolean isLimit = false;
        while(!isLimit){
            long minValue = (long) Math.pow(10, powerValue);
            long maxValue = (long) (powerValue*Math.pow(9,power));
            isLimit = minValue >= maxValue;
            powerValue++;
        }
        powerValue--;
        return (long) (powerValue*Math.pow(9,power));
    }


    /**
     * Euler Problem 31 : Coin sums
     */
    public long getE31(int initValue){
        // 200 = a1 + 2a2 + 5a5 + 10a10 + 20a20 + 50a50 + 100a1 + 200a2
        // long sum = a1 + 2*a2 + 5*a5 + 10*a10 + 20*a20 + 50*a50 + 100*aA1 + 200*aA2;
        long number = 1;
        int value = initValue;

        for(int a200 = 0; a200<=value+1; a200+=200){
            value = initValue -a200;
            for(int a100 = 0; a100<=initValue -a200+1; a100+=100){
                value = initValue -a200 -a100;
                for(int a50 = 0; a50<=initValue -a200 -a100+1; a50+=50){
                    value = initValue -a200 -a100 -a50;
                    for(int a20 = 0; a20<=initValue -a200 -a100 -a50+1; a20+=20){
                        value = initValue -a200 -a100 -a50 -a20;
                        for(int a10 = 0; a10<=initValue -a200 -a100 -a50 -a20+1; a10+=10){
                            value = initValue -a200 -a100 -a50 -a20 -a10;
                            for(int a5 = 0; a5<=initValue -a200 -a100 -a50 -a20 -a10+1; a5+=5){
                                value = initValue -a200 -a100 -a50 -a20 -a10 -a5;
                                for(int a2 = 0; a2<=initValue -a200 -a100 -a50 -a20 -a10 -a5+1; a2+=2){
                                    value = initValue -a200 -a100 -a50 -a20 -a10 -a5 -a2;
                                    for(int a1 = 0; a1<=initValue -a200 -a100 -a50 -a20 -a10 -a5 -a2+1; a1++){
                                        if(initValue -a200 -a100 -a50 -a20 -a10 -a5 -a2 -a1 == 0)
                                            number++;
                                    }
                                }
                            }
                            String pif = "paf";
                        }
                        String pif = "paf";
                    }
                }
            }

        }

        return number;
    }

    // TODO : NOT FINISHED
    public void shiftArray(long maxValue, final List<Integer> arrayToShift, final List<Integer> weightArray){
        boolean isShifted = false;
        int i=arrayToShift.size()-1;

        while(i>0 && !isShifted ){
            if(arrayToShift.get(i) != 0)
                if(arrayToShift.get(i) * weightArray.get(i) == maxValue){
                    arrayToShift.set(i, arrayToShift.get(i)-1);
                    maxValue -= weightArray.get(i) * arrayToShift.get(i);
                    arrayToShift.set(i-1, (int) (maxValue / weightArray.get(i-1)));
                    if(maxValue % weightArray.get(i-1) != 0){
                        maxValue -= (int) (maxValue / weightArray.get(i-1)) * weightArray.get(i-1);
                        List<Integer> subArrayToShift = arrayToShift.subList(0, i-1);
                        List<Integer> subWeightArray = weightArray.subList(0, i-1);
                        fillArray(maxValue, subArrayToShift, subWeightArray);
                    }
                    isShifted = true;
                } else if(i==1){
                    arrayToShift.set(i, arrayToShift.get(i)-1);
                    maxValue -= weightArray.get(i) * arrayToShift.get(i);
                    List<Integer> subArrayToShift = arrayToShift.subList(0, 1);
                    List<Integer> subWeightArray = weightArray.subList(0, 1);
                    fillArray(maxValue, subArrayToShift, subWeightArray);
                } else {
                    maxValue -= arrayToShift.get(i)*weightArray.get(i);

                }
            i--;
        }
    }

    // TODO : NOT FINISHED
    public void fillArray(long maxValue, final List<Integer> arrayToFill, final List<Integer> weightArray){
        int i=arrayToFill.size()-1;
        boolean isFilled = false;

        while(i>=0 && !isFilled){
            arrayToFill.set(i, (int) maxValue / weightArray.get(i));
            if(maxValue%weightArray.get(i) != 0 && i > 1){
                maxValue -= (int) maxValue / weightArray.get(i);
                fillArray(maxValue, arrayToFill.subList(0, i-1), weightArray.subList(0, i-1));
            } else
                isFilled = true;
            i--;
        }

    }
}
