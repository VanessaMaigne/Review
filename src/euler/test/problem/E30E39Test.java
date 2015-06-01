package problem;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class E30E39Test {

    E303E39 e303E39 = new E230239Impl();

    @Test
    public void testE30(){
        System.out.print("\ntest E30 ");
        long result = e303E39.getE30(4);
        Assert.assertEquals(result, 19316);
        result = e303E39.getE30(5);
        Assert.assertEquals(result, 443839);
        System.out.print(result);
    }

    @Test
    public void testE31(){
        System.out.print("\ntest E31 ");
//        ArrayList<Integer> array = new ArrayList<Integer>(){{ add(0); add(0); add(0); add(0); add(0); add(0); add(0); add(1); }};
//        ArrayList<Integer> weightArray = new ArrayList<Integer>(){{ add(1); add(2); add(5); add(10); add(20); add(50); add(100); add(200); }};

//        while(array.get(0) != weightArray.get(weightArray.size()-1))
//            e303E39.shiftArray(200, array, weightArray);
        long result = e303E39.getE31(200);
        Assert.assertEquals(result, 73682);
        System.out.print(result);

    }
}
