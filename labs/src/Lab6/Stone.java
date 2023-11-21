package Lab6;

public abstract class Stone {
    float carats;
    int price;
    float  refraction;
    int price_per_one_carat;

    public float getRefraction() {
        return refraction;
    }

    public int getPrice() {
        return price;
    }

    public float getCarats() {
        return carats;
    }

    public abstract int calcPrice(float carats);

}
