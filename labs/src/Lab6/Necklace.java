package Lab6;

import Lab4.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Necklace {

    private List <Stone> stones = new ArrayList<>();
    private float weight;
    private int price;

    public void addStone(Stone stone){
        stones.add(stone);
    }

    public List<Stone> getStones() {
        return stones;
    }

    public float calcWeight(){
        for(Stone stone: stones){
            weight +=stone.getCarats();
        }
        return weight;
    }

    public int priceAll(){
        for(Stone stone: stones){
            price +=stone.getPrice();
        }
        return price;
    }

    public void sortByPrice(){
        stones.sort(Comparator.comparingInt(Stone::getPrice));

        System.out.println("Сортування за ціною:");
        for (Stone stone : stones) {
            System.out.println(stone);
        }
    }

    public List<Stone> findByRefraction(float minValue, float maxValue){
        List <Stone> result = new ArrayList<>();
        for (Stone stone: stones){
            if(stone.getRefraction()>minValue & stone.getRefraction()<maxValue){
                result.add(stone);
            }
        }
        return result;


    }


}
