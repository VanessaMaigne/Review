package problem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import static java.math.BigDecimal.ROUND_FLOOR;

public class E500E509Impl implements E500E509{

    /**
     * Euler Problem 505 : Bidirectional Recurrence
     */
    public double getE505(final double n){
        return functionA(n);
    }

    public double functionX(final double value){
        if(value == 0.0)
            return 0;
        if(value == 1.0)
            return 1;
        if(value%2==0){
            double k = value/2;
            return (3*functionX(k)+ 2*functionX(Math.floor(k/2)))%Math.pow(2,60);
        } else {
            double k = (value-1) / 2;
            return (2*functionX(k) + 3*functionX(Math.floor(k/2)))%Math.pow(2, 60);
        }
    }

    public double functionY(final double n, final double k){
        if(k>=n)
            return functionX(k);
        else {
            double bob = functionY(n, 2*k);
            double bob1 = functionY(n, 2*k+1);
            return Math.pow(2,60) - 1 -Math.max(bob, bob1);
        }
    }

    public double functionA(final double n){
        return functionY(n, 1);
    }


    public BigDecimal getE505WithBD(final BigDecimal n){
        return functionAWithBD(n);
    }

    public BigDecimal functionXWithBD(final BigDecimal value){
        if(value.equals(new BigDecimal("0")))
            return new BigDecimal("0");
        if(value.equals(new BigDecimal("1")))
            return new BigDecimal("1");
        if(value.equals(new BigDecimal("2")))
            return new BigDecimal("3");
        if(value.equals(new BigDecimal("3")))
            return new BigDecimal("2");
        if(value.equals(new BigDecimal("4")))
            return new BigDecimal("11");

        if(value.remainder(new BigDecimal("2")).equals(new BigDecimal("0"))){
            BigDecimal k = value.divide(new BigDecimal("2"));
            BigDecimal floorValue = k.divide(new BigDecimal("2")).setScale(0, RoundingMode.FLOOR);
            return (new BigDecimal("3").multiply(functionXWithBD(k)).add(new BigDecimal("2").multiply(functionXWithBD(floorValue)))).remainder(new BigDecimal("2").pow(60));
        } else {
            BigDecimal k = value.subtract(new BigDecimal("1")).divide(new BigDecimal("2"));
            BigDecimal floorValue = k.divide(new BigDecimal("2")).setScale(0, RoundingMode.FLOOR);
            return (functionXWithBD(k).multiply(new BigDecimal("2")).add(new BigDecimal("3").multiply(functionXWithBD(floorValue)))).remainder(new BigDecimal("2").pow(60));
        }
    }

    public BigDecimal functionYWithBD(final BigDecimal n, final BigDecimal k){
        if(k.compareTo(n) >= 0)
            return functionXWithBD(k);
        else {
            BigDecimal bob = functionYWithBD(n, k.multiply(new BigDecimal("2")));
            BigDecimal bob1 = functionYWithBD(n, k.multiply(new BigDecimal("2")).add(new BigDecimal("1")));
            return new BigDecimal("2").pow(60).subtract(new BigDecimal("1")).subtract(bob.max(bob1));
        }
    }

    public BigDecimal functionAWithBD(final BigDecimal n){
        return functionYWithBD(n, new BigDecimal("1"));
    }
}
