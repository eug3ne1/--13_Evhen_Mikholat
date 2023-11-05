package Lab3;
// Заліковка  №1318
//C3 = 1318 % 3 =1; // StringBuffer
//C17 = 1318 % 17 = 9; // Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.


import java.util.HashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static  void main(String[] args) {

            String text = "Привіт,Це приклад тексту. Текст містить декілька речень. Речення розділяються крапками.";
            String[] words = {"текст", "речення","Привіт"};

            Map<String, Integer> wordCounts = new HashMap<>();
        try {

            // Розділяємо текст на речення за допомогою крапки як роздільника
            String[] sentences = text.split("[.,]");

            for (String sentence : sentences) {
                for (String word : words) {
                    // Перетворюємо слово та речення в нижній регістр для регістронезалежного пошуку
                    word = word.toLowerCase();
                    sentence = sentence.toLowerCase();

                    // Використовуємо StringBuffer для збереження речення та слова
                    StringBuffer sentenceBuffer = new StringBuffer(sentence);
                    StringBuffer wordBuffer = new StringBuffer(word);

                    // Видаляємо з речення зайві пробіли на початку і в кінці


                    // Шукаємо входження слова в речення
                    int index = sentenceBuffer.indexOf(wordBuffer.toString());
                    while (index != -1) {
                        int sentenceEndIndex = sentenceBuffer.indexOf(" ", index);
                        if (sentenceEndIndex == -1) {
                            // Якщо слово в реченні знаходиться в кінці речення
                            sentenceEndIndex = sentenceBuffer.length();
                        }
                        String matchedWord = sentenceBuffer.substring(index, sentenceEndIndex);
                        wordCounts.put(matchedWord, wordCounts.getOrDefault(matchedWord, 0) + 1);

                        // Пересуваємо індекс для пошуку інших входжень слова в речення
                        index = sentenceBuffer.indexOf(wordBuffer.toString(), index + 1);
                    }
                }
            }

            // Виводимо результати
            for (String word : words) {
                System.out.println("Слово '" + word + "' зустрічається в " + wordCounts.getOrDefault(word.toLowerCase(), 0) + " реченнях.");
            }
        }
        catch (PatternSyntaxException e) {
            System.err.println("Помилка у регулярному виразі для розділення тексту на речення: " + e.getMessage());
        }
        catch (NullPointerException e) {
            System.err.println("Помилка: текст або масив слів не можуть бути null.");
        }
    }
}

