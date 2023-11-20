package Lab5;

import java.util.List;

public class Sentence {
    private List<Object> components;
    private List<Word> words;

    public Sentence(List<Object> components, List<Word> words) {
        this.components = components;
        this.words = words;
    }

    public List<Object> getComponents() {
        return components;
    }

    public List<Word> getWords() {
        return words;
    }
}
