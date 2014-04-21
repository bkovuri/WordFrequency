import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WordFrequency {

    Map<String, Node> map;
    Node[] sortedArray;

    WordFrequency()
    {
         map = new HashMap<String,Node>();
    }

    void readInputDataFromFile(String fileName) throws IOException {


        BufferedReader br = null;
        String line;
        String delimiters = "\\s+|,\\s*|\\.\\s*";

        try
        {
            br = new BufferedReader( new FileReader(fileName));
            while((line = br.readLine()) != null)
            {
                String[] tokens = line.split(delimiters);
                for(String element: tokens)
                {
                    buildWordFrequency(element);
                }
            }
            sortedArray = map.values().toArray(new Node[]{});
            Arrays.sort(sortedArray, new WordFrequencyComparator());
        }
        catch(FileNotFoundException fe)
        {
            System.err.println(new StringBuilder("Failed to create/read from given csv file: ")
                    .append(fileName).toString());
            throw fe;
        }
    }

    void buildWordFrequency(String element)
    {
        if(element != null)
        {
            if(map.containsKey(element))
            {
                Node node = map.get(element);
                node.setFrequency(node.getFrequency() + 1);
                map.put(element, node);
            }
            else
            {
                Node node = new Node(element, 1);
                map.put(element, node);
            }
        }
    }

    List<String> findElementsWithMaxFrequency(int k)
    {
        List<String> outputList = new ArrayList<String>();

        if(k >= sortedArray.length)
        {
            System.err.println(new StringBuilder("Input value k:").append(k).
                    append(" ,is greater than list of words in string: ").append(sortedArray.length).toString());
            return Collections.EMPTY_LIST;
        }
        for(int i=0; i < k; i++)
        {
            outputList.add(sortedArray[i].getWord());
        }
        return outputList;
    }

    public static void main(String[] args) throws Exception
    {
        WordFrequency wordFrequency = new WordFrequency();
        if(args != null && args.length >= 1)
        {
           Integer k = 5;
           wordFrequency.readInputDataFromFile(args[0]);
            if(args.length > 1)
            {
                k = Integer.parseInt(args[1]);
            }
            List<String> maxList = wordFrequency.findElementsWithMaxFrequency(k);
           for(String element: maxList)
           {
               System.out.println(element);
           }
        }
    }
}


