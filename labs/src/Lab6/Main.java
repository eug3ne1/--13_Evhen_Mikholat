package Lab6;

public class Main {
    public static void main(String[] args) {
        Stone diamond = new Diamond(1.05f,2.8f);
        Stone rubin = new Rubin(1.89f,1.735f);
        Stone sapphire= new Sapphire(0.7f,1.762f);
        Stone quartz = new Quartz(4.73f,1.45f);
        Stone malachite = new Malachite(6.5f, 1.807f);

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
