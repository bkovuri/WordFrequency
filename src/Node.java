
public class Node {

    private String word;
    private Integer frequency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (!word.equals(node.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    Node(String word, Integer frequency)
    {
        this.word = word;
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
