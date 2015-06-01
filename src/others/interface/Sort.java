import java.util.List;

public interface Sort {

    public void sortByInsertion(List<Integer> elements);
    public void sortByInsertion2(List<Integer> input);

    public void sortByBubble(List<Integer> elements);
    public void sortByBubble2(List<Integer> elements);

    public void sortByGnome(List<Integer> elements);
    public void sortByGnome2(List<Integer> elements);

    public void sortBySelection(List<Integer> elements);

    public List<Integer> sortByMerge(List<Integer> elements);

    public List<Integer> sortByQuick(List<Integer> elements);
}
