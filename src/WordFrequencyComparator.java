import java.util.Comparator;
import java.util.Map;

public class WordFrequencyComparator implements Comparator<Node> {

    public int compare(Node node1, Node node2)
    {
        if(node1.getFrequency() > node2.getFrequency())
        {
            return -1;
        }
        else if(node1.getFrequency() < node2.getFrequency())
        {
            return 1;
        }
        return 0;
    }
}
