package Lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessor {
    public static void main(String[] args) {
        String textUser = "Ваш, текст тут. Може містити кілька речень тут.";
        String[] wordsToCount = {"текст", "тут", "Ваш"};

        String[] sentencesArray = textUser.split("[.!?]");
        List<Sentence> sentences = new ArrayList<>(); // створення масиву речень
        Text text = new Text(sentences);

        for (String sentenceStr : sentencesArray) { // для кожного речення
            List<Object> components = new ArrayList<>();
            List<Word> words = new ArrayList<>();  // список слів типу Word
            String[] wordsAndPunctuations = sentenceStr.split("[\\s,]+");

            for (String wordPunctuation : wordsAndPunctuations) { // для кожного слова
                List<Letter> letters = new ArrayList<>();         // масив об'єктів типу letters
                for (char c : wordPunctuation.toCharArray()) {     // для кожного char у слові
                    letters.add(new Letter(c));
                }

                if (wordPunctuation.matches("\\p{L}+")) { // якщо слово
                    Word word = new Word(letters);
                    words.add(word);
                    components.add(word);
                } else {                    // якщо знак пунктуації
                    components.add(new Punctuation(wordPunctuation));
                }
            }

            Sentence sentence = new Sentence(components, words);
            text.addSentence(sentence);
            System.out.println(text);
        }


        // Підрахунок кількості згадок кожного слова в реченнях
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : wordsToCount) {
            wordCounts.put(word, 0);
        }

        for (Sentence sentence : text.getSentences()) { // для кожного речення в тексті
            List<Word> sentenceWords = sentence.getWords(); // для кожного слова в тексті
            for (Word word : sentenceWords) {
                List<Letter> letters = word.getLetters();
                StringBuilder wordBuilder = new StringBuilder();
                for (Letter letter : letters) {
                    wordBuilder.append(letter.getCharacter());
                }
                String currentWord = wordBuilder.toString();

                if (wordCounts.containsKey(currentWord)) {
                    wordCounts.put(currentWord, wordCounts.get(currentWord) + 1);
                }
            }
        }

        // Виведення результатів
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println("Слово '" + entry.getKey() + "' зустрічається в " + entry.getValue() + " реченнях.");
        }

    }

}
