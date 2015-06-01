import java.util.ArrayList;
import java.util.List;

/**
 * http://lwh.free.fr/pages/algo/tri/tri.htm
 * http://www.java2novice.com/java-sorting-algorithms/
 */
public class SortImpl2 implements Sort{

    /**
     * Insertion sort : card player
     */
    public void sortByInsertion(List<Integer> elements){
        for(int i=0; i< elements.size()-1; i++){
            if(elements.get(i+1) < elements.get(i)){
                int j=i;
                while(j>=0 && elements.get(j+1) < elements.get(j)){
                    Integer temp = elements.get(j+1);
                    elements.set(j+1, elements.get(j));
                    elements.set(j, temp);
                    j--;
                }
            }
        }
    }

    public void sortByInsertion2(List<Integer> input) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void sortByBubble(List<Integer> elements) {
        boolean hasDonePermutation = false;
        boolean isLastCycle = false;
        int i=0;

        while(i<elements.size()-1 && !isLastCycle){
            if(elements.get(i) > elements.get(i+1)){
                Integer temp = elements.get(i+1);
                elements.set(i+1, elements.get(i));
                elements.set(i, temp);
                hasDonePermutation = true;
            }
            i++;

            if(i==elements.size()-1)
                if(hasDonePermutation){
                    i=0;
                    hasDonePermutation = false;
                } else
                    isLastCycle = true;
        }
    }

    public void sortByBubble2(List<Integer> elements) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void sortByGnome(List<Integer> elements) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void sortByGnome2(List<Integer> elements) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Integer> sortByMerge(List<Integer> elements) {
        if(elements.size() <=1)
            return elements;
        else {
            List<Integer> leftElements = elements.subList(0, elements.size()/2);
            List<Integer> rightElements = elements.subList(elements.size()/2, elements.size());
            leftElements = sortByMerge(leftElements);
            rightElements = sortByMerge(rightElements);


            int leftIndex = 0;
            int rightIndex = 0;

            List<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i<elements.size(); i++){
                if(rightIndex >= rightElements.size() || leftIndex < leftElements.size() && leftElements.get(leftIndex) < rightElements.get(rightIndex)){
                    temp.add(leftElements.get(leftIndex));
                    leftIndex++;
                } else {
                    temp.add(rightElements.get(rightIndex));
                    rightIndex++;
                }
            }
            return temp;
        }
    }

    public void sortBySelection(List<Integer> elements) {
        for(int i=0; i<elements.size(); i++){
            Integer min = elements.get(i);
            for(int j=i+1; j<elements.size(); j++){
                if(elements.get(j) < min){
                    min = elements.get(j);
                    elements.set(j, elements.get(i));
                    elements.set(i, min);
                }
            }
        }
    }

    public List<Integer> sortByQuick(List<Integer> elements) {
        if(elements.size() <= 1)
            return elements;
        else {
            Integer pivot = elements.get(0);
            List<Integer> leftElements = new ArrayList<Integer>();
            List<Integer> sameElements = new ArrayList<Integer>();
            List<Integer> rightElements = new ArrayList<Integer>();

            for(int i=0; i<elements.size(); i++){
                if(elements.get(i) < pivot)
                    leftElements.add(elements.get(i));
                else if(elements.get(i) > pivot)
                    rightElements.add(elements.get(i));
                else
                    sameElements.add(elements.get(i));
            }

            leftElements = sortByQuick(leftElements);
            rightElements = sortByQuick(rightElements);

            leftElements.addAll(sameElements);
            leftElements.addAll(rightElements);
            return leftElements;
        }
    }

}
