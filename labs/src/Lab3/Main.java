package Lab3;
// Заліковка  №1318
//C3 = 1318 % 3 =1; // StringBuffer
//C17 = 1318 % 17 = 9; // Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.

import java.util.HashMap;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class Main {
    public static void main(String[] args) {
        String text = "Це приклад тексту. містить декілька речень, розділені комами! Речення також можуть містити слова, які шукаємо. Текст містить текст.";
        String[] words = {"текст","речення","Це"};

        Map<String, Integer> wordCounts = new HashMap<>();
        if (text.isEmpty()){
            System.out.println("Текст є порожнім");
        } else if (words.length==0) {
            System.out.println("Масив слів є порожнім");

        } else{
            // Розділяємо текст на речення за допомогою крапки або коми як роздільника
            String[] sentences = text.split("[.,!?]");

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
                    int count = 0; // Лічильник кількості входжень слова в речення
                    while (index != -1) {
                        int sentenceEndIndex = sentenceBuffer.indexOf(" ", index);
                        if (sentenceEndIndex == -1) {
                            // Якщо слово в реченні знаходиться в кінці речення
                            sentenceEndIndex = sentenceBuffer.length();
                        }
                        String matchedWord = sentenceBuffer.substring(index, sentenceEndIndex);
                        wordCounts.put(matchedWord, wordCounts.getOrDefault(matchedWord, 0) + 1);

                        count++; // Збільшуємо кількість входжень слова в речення
                        if (count >= 2) {
                            // Якщо слово зустрілося більше ніж один раз у реченні, пропускаємо його
                            wordCounts.put(matchedWord, wordCounts.get(matchedWord) - 1);
                        }

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
    }
}


