import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTest {

//    Sort sort = new SortImpl();
    Sort sort = new SortImpl2();
    List<Integer> elements = new ArrayList<Integer>(){{add(2); add(5); add(7); add(3); add(11); add(11); add(9); add(1); add(7); add(8);}};

    @Test
    public void testInsertionSort(){
        System.out.print("TEST INSERTION SORT : ");
        System.out.println("\nArray : "+elements);
        sort.sortByInsertion(elements);
        System.out.println("\nMethod 1 : " + elements);
        elements = new ArrayList<Integer>(){{add(2); add(5); add(7); add(3); add(11); add(11); add(9); add(1); add(7); add(8);}};
        sort.sortByInsertion2(elements);
        System.out.println("Method 2 : " + elements);
    }

    @Test
    public void testBubbleSort(){
        System.out.print("\n\nTEST BUBBLE SORT : ");
        System.out.println("\nArray : "+elements);
        sort.sortByBubble(elements);
        System.out.println("Method 1 : "+elements);
        elements = new ArrayList<Integer>(){{add(2); add(5); add(7); add(3); add(11); add(11); add(9); add(1); add(7); add(8);}};
        sort.sortByBubble2(elements);
        System.out.println("Method 2 : "+elements);
    }

    @Test
    public void testGnomeSort(){
        System.out.print("\n\nTEST GNOME SORT : ");
        System.out.println("\nArray : "+elements);
        sort.sortByGnome(elements);
        System.out.println("Method 1 : "+elements);
        elements = new ArrayList<Integer>(){{add(2); add(5); add(7); add(3); add(11); add(11); add(9); add(1); add(7); add(8);}};
        sort.sortByGnome2(elements);
        System.out.println("Method 2 : "+elements);
    }

    @Test
    public void testMergeSort(){
        System.out.print("\n\nTEST MERGE SORT : ");
        System.out.println("\nArray : " + elements);
        elements = sort.sortByMerge(elements);
        System.out.println("Method : "+elements);
    }

    @Test
    public void testSelectionSort(){
        System.out.print("\n\nTEST SELECTION SORT : ");
        System.out.println("\nArray : "+elements);
        sort.sortBySelection(elements);
        System.out.println("Method : "+elements);
    }

    @Test
    public void testQuickSort(){
        System.out.print("\n\nTEST QUICK SORT : ");
        System.out.println("\nArray : "+elements);
        elements = sort.sortByQuick(elements);
        System.out.println("Method : " + elements);
    }
}
