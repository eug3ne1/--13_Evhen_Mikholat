package Lab5;

import java.util.List;
import java.util.Set;

public class Sentence {
    private List<Object> components;
    private Set<Word> words;

    public Sentence(List<Object> components, Set<Word> words) {
        this.components = components;
        this.words = words;
    }

    public List<Object> getComponents() {
        return components;
    }

    public Set<Word> getWords() {
        return words;
    }
}
