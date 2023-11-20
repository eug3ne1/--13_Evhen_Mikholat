package Lab5;

import java.util.List;

public class Text {
    @Override
    public String toString() {
        return "Text{" +
                "sentences=" + sentences +
                '}';
    }

    private List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }
    public void addSentence(Sentence sentence){
        sentences.add(sentence);

    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}

