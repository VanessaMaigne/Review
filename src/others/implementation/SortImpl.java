import java.util.ArrayList;
import java.util.List;

/**
 * http://lwh.free.fr/pages/algo/tri/tri.htm
 * http://www.java2novice.com/java-sorting-algorithms/
 */
public class SortImpl implements Sort{

    /**
     * Insertion sort : card player
     * O(n^2)
     */
    public void sortByInsertion(List<Integer> elements){
        for(int j=1; j<elements.size(); j++){
            Integer element = elements.get(j);
            int i=0;
            while(i<elements.size()-1 && element > elements.get(i)){
                i++;
            }
            for(int k=j; k>=i+1; k--){
                elements.set(k, elements.get(k-1));
            }
            elements.set(i, element);
        }
    }

    public void sortByInsertion2(List<Integer> input){
        for (int i = 1; i < input.size(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(input.get(j) < input.get(j-1)){
                    Integer temp = input.get(j);
                    input.set(j, input.get(j-1));
                    input.set(j-1, temp);
                }
            }
        }
    }


    /**
     * Bubble sort or sinking sort : permutations
     * O(n^2)
     */
    public void sortByBubble(List<Integer> elements){
        boolean isLastCycle = false;
        boolean hasPermutationDone = false;
        int i=0;
        int index = 0;
        while(i < elements.size() && !isLastCycle){
            index++;
            if(i != elements.size()-1 && elements.get(i) > elements.get(i+1)){
                Integer temp = elements.get(i);
                elements.set(i, elements.get(i+1));
                elements.set(i+1, temp);
                hasPermutationDone = true;
            }
            i++;
            if (i==elements.size()-1)
                if(hasPermutationDone){
                    i=0;
                    hasPermutationDone = false;
                }
                else
                    isLastCycle = true;
        }
        System.out.println("\nNumber of loop : "+index);
    }

    public void sortByBubble2(List<Integer> elements){
        int n = elements.size();
        int index = 0;
        int k;
        for (int m = n; m >= 0; m--) {
            for (int i = 0; i < n - 1; i++) {
                index++;
                k = i + 1;
                if (elements.get(i) > elements.get(k)) {
                    int temp;
                    temp = elements.get(i);
                    elements.set(i, elements.get(k));
                    elements.set(k, temp);
                }
            }
        }
        System.out.println("Number of loop : "+index);
    }


    /**
     * Gnome sort : Dutch dwarf
     * Insertion sort with permutations
     * O(n2)
     */
    public void sortByGnome(List<Integer> elements){
        for(int i = 0; i<elements.size()-1; i++){
            if(elements.get(i) > elements.get(i+1)){
                int j = i;
                while(j >= 0 && elements.get(j) > elements.get(j+1) && j<elements.size()-1){
                    Integer temp = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j+1, temp);
                    j--;
                }
            }
        }
    }

    public void sortByGnome2(List<Integer> elements){
        int i = 0;
        while(i < elements.size()-1){
            if(elements.get(i) > elements.get(i+1)){
                Integer temp = elements.get(i);
                elements.set(i, elements.get(i+1));
                elements.set(i+1, temp);
                if(i> 1)
                    i--;
            } else
                i++;
        }
    }


    /**
     * Selection sort : find min and permute with the ieme element
     * O(n^2)
     * Tri non stable (ne respecte pas l'ordre initial pour les éléments égaux)
     */
    public void sortBySelection(List<Integer> elements){
        for(int i=0; i < elements.size()-1; i++){
            Integer min = elements.get(i+1);
            Integer index = i+1;
            for(int j=i+2; j<elements.size(); j++){
                if(elements.get(j) < min){
                    min = elements.get(j);
                    index = j;
                }
            }
            if(min < elements.get(i)){
                elements.set(index, elements.get(i));
                elements.set(i, min);
            }
        }
    }


    /**
     * Merge sort : dichotomie -> subdivise array into 2 arrays, sort these arrays then merge
     * O(n*log(n))
     */
    public List<Integer> sortByMerge(List<Integer> elements){
        if(elements.size() > 1){
            List<Integer> tempElements = new ArrayList<Integer>();

            List<Integer> leftElements = elements.subList(0, elements.size() / 2);
            List<Integer> rightElements = elements.subList(elements.size() / 2, elements.size());

            leftElements = sortByMerge(leftElements);
            rightElements = sortByMerge(rightElements);

            int leftIndex = 0;
            int rightIndex = 0;
            for(int i=0; i<elements.size(); i++){
                if(rightIndex >= rightElements.size() || (leftIndex < leftElements.size() && leftElements.get(leftIndex) < rightElements.get(rightIndex))){
                    tempElements.add(leftElements.get(leftIndex));
                    leftIndex++;
                } else {
                    tempElements.add(rightElements.get(rightIndex));
                    rightIndex++;
                }
            }
            return tempElements;
        } else
            return elements;
    }


    /**
     * Quick sort, Hoare sort : find pivot and put elements above and belove, then sort the new arrays with new pivot
     * O(nlog(n)) -> O(n^2)
     */
    public List<Integer> sortByQuick(List<Integer> elements){
        if(elements.size()>1){
            Integer pivot = elements.get(elements.size() - 1);

            List<Integer> belowElements = new ArrayList<Integer>();
            List<Integer> aboveElements = new ArrayList<Integer>();
            List<Integer> sameElements = new ArrayList<Integer>();

            for(int i = 0; i<elements.size(); i++){
                if(elements.get(i) < pivot)
                    belowElements.add(elements.get(i));
                else if(elements.get(i) > pivot)
                    aboveElements.add(elements.get(i));
                else
                    sameElements.add(elements.get(i));
            }

            belowElements = sortByQuick(belowElements);
            aboveElements = sortByQuick(aboveElements);

            belowElements.addAll(sameElements);
            belowElements.addAll(aboveElements);
            return belowElements;

        } else
            return elements;
    }
}
