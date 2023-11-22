package Lab6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomLinkedListTest {
    Stone quartz = new Quartz(4.73f,1.45f);
    Stone quartz2 = new Quartz(7.73f,2.45f);
    Stone rubin = new Rubin(1.89f,1.735f);
    Stone sapphire= new Sapphire(0.7f,1.762f);
    Stone diamond = new Diamond(1.05f,2.8f);
    Stone malachite = new Malachite(6.5f, 1.807f);

    /**
     * тест методу Add(), що перевіряє, чи додався елемент
     */
    @Test
    void testAdd() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();

        assertTrue(list.isEmpty());
        list.add(diamond);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    /**
     * тест методу testAddAtIndex(), що перевіряє, чи додався елемент по вказаному індексу
     */
    @Test
    void testAddAtIndex() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(rubin);
        list.add(sapphire);
        list.add(1, rubin);
        assertEquals(rubin, list.get(1));
    }
    /**
     * тест методу testAddAll(), що перевіряє, чи додався елемент по вказаному індексу
     */
    @Test
    void testAddAll() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        List<Stone> addList = Arrays.asList(quartz, quartz2);
        list.addAll(addList);
        assertEquals(2, list.size());
    }


    /**
     * тест методу Remove(), що перевіряє, чи не містить колекція елемента, що був видалений по індексу
     */
    @Test
    void testRemove() {

        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(quartz);
        list.add(quartz2);
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals(quartz2, list.get(0));
    }

    /**
     * тест методу Clear(), що перевіряє, чи є масив порожнім після очищування
     */
    @Test
    void testClear() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();

        list.add(quartz);
        list.add(quartz2);
        list.clear();
        assertTrue(list.isEmpty());
    }
    /**
     * тест методу Clear(), що перевіряє, чи є масив порожнім після очищування
     */
    @Test
    void testRemoveAll() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        List<Stone> removeList = Arrays.asList(quartz, quartz2);
        list.add(quartz);
        list.add(quartz2);
        list.removeAll(removeList);
        assertTrue(list.isEmpty());
    }

    /**
     * тест методу СontainsAll(), що первіряє, чи є колекція значень в колекції
     */

    @Test
    void testContainsAll() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(diamond);
        list.add(quartz);
        List<Stone> testList = Arrays.asList(diamond, quartz);
        assertTrue(list.containsAll(testList));
    }

    /**
     * тест методу Сontains(), що первіряє, чи є задане значення в колекції
     */
    @Test
    void testContains() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(diamond);
        assertTrue(list.contains(diamond));
    }

    /**
     * тест викидання виключення, що виникає через спробу доступу по індексу до елемента що не існує
     */
    @Test
    void testExceptionForInvalidIndex() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(diamond);
        list.add(quartz);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    /**
     * тест методу Reverse(), що інвертує порядок елементів у списку
     */
    @Test
    void testReverse() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(sapphire);
        list.add(diamond);
        list.add(quartz);
        list.reverse();
        assertEquals(quartz, list.get(0));
        assertEquals(diamond, list.get(1));
        assertEquals(sapphire, list.get(2));
    }

    /**
     * Тестує метод retainAll() для збереження елементів, що належать до певної колекції.
     * Перевіряє, чи список містить тільки елементи з переданої колекції.
     */
    @Test
    void testRetainAll() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(sapphire);
        list.add(diamond);
        list.add(rubin);
        List<Stone> retainList = Arrays.asList(diamond, rubin, quartz);
        list.retainAll(retainList);
        assertEquals(2, list.size());
        assertEquals(diamond, list.get(0));
        assertEquals(rubin, list.get(1));
    }

    /**
     * Тестує метод subList() для отримання підсписку.
     * Перевіряє, чи отриманий підсписок має очікувану кількість елементів та значення.
     */
    @Test
    void testSubList() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(rubin);
        list.add(quartz);
        list.add(diamond);
        CustomLinkedList<Stone> subList = list.subList(1, 3);
        assertEquals(2, subList.size());
        assertEquals(quartz, subList.get(0));
        assertEquals(diamond, subList.get(1));
    }

    /**
     * Тестує метод toArray() для перетворення списку у масив.
     * Перевіряє, чи отриманий масив містить очікувані елементи списку.
     */
    @Test
    void testToArray() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(diamond);
        list.add(quartz);
        list.add(rubin);
        Object[] array = list.toArray();
        assertArrayEquals(new Object[]{diamond, quartz, rubin}, array);
    }

    /**
     * Тестує метод equals() для порівняння двох списків.
     * Перевіряє, чи вони містять однакові елементи в однаковому порядку.
     */
    @Test
    void testEquals() {
        CustomLinkedList<Stone> list1 = new CustomLinkedList<>();
        list1.add(quartz);
        list1.add(rubin);
        list1.add(sapphire);
        CustomLinkedList<Stone> list2 = new CustomLinkedList<>();
        list2.add(quartz);
        list2.add(rubin);
        list2.add(sapphire);
        assertTrue(list1.equals(list2));
    }

    /**
     * Тестує метод set() для встановлення елементу за певним індексом.
     * Перевіряє, чи встановлений елемент збігається з очікуваним значенням.
     */
    @Test
    void testSet() {
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(diamond);
        list.add(sapphire);
        list.set(1, quartz);
        assertEquals(quartz, list.get(1));
    }

    @Test
    void testToString(){
        CustomLinkedList<Stone> list = new CustomLinkedList<>();
        list.add(rubin);
        assertEquals("[\nRubin carats=1.89, refraction=1.735, price_per_one_carat=200, price=378}]",list.toString());

    }










}
