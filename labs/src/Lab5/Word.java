package Lab5;

import java.util.List;

public class Word {
    private List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    public List<Letter> getLetters() {
        return letters;
    }
}
