package Lab6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stone diamond = new Diamond(1.05f,2.8f);
        Stone rubin = new Rubin(1.89f,1.735f);
        Stone sapphire= new Sapphire(0.7f,1.762f);
        Stone quartz = new Quartz(4.73f,1.45f);
        Stone malachite = new Malachite(6.5f, 1.807f);
//        List<Stone> collection = new ArrayList<>();
//        collection.add(diamond);
//        collection.add(malachite);
//        List<Stone> customLinkedList= new CustomLinkedList<>(collection);
//        customLinkedList.add(rubin);
//        System.out.println(customLinkedList);

//        CustomLinkedList<Stone> customList = new CustomLinkedList<>();
//        customList.add(diamond);
//        customList.add(malachite);
////        customList.add(quartz);
//
//        System.out.println("Custom List: " + customList);
//        System.out.println("Size: " + customList.size());
//
//        customList.remove(1);
//        System.out.println("After removing index 1: " + customList);
//
//        customList.add(1, malachite);
//        System.out.println("After adding malachite at index 1: " + customList);
//
//        System.out.println("Index of malachite: " + customList.indexOf(malachite));
////        customList.removeAll(collection);
//        customList.reverse();
//        System.out.println(customList);


        // створюємо об'єкт класу намисто
        Necklace necklace = new Necklace();
        // додаємо до намиста камні
        necklace.addStone(diamond);
        necklace.addStone(sapphire);
        necklace.addStone(quartz);
        necklace.addStone(malachite);
        necklace.addStone(rubin);

        System.out.println(necklace.getStones());

        System.out.println("\nЗагальна вага намиста "+necklace.calcWeight()+ " карат");
        System.out.println("Загальна ціна намиста "+necklace.priceAll()+" $");
        necklace.sortByPrice();
        System.out.println("Каміння в намисті, що відповідає папарметрам пошуку");
        System.out.println(necklace.findByRefraction(1.7f,2.333f));


    }
}
