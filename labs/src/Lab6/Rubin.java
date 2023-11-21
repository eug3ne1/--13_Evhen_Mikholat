package Lab6;

public class Rubin extends Stone{
    float carats;
    float  refraction;
    final int price_per_one_carat = 200;

    int price ;

    public Rubin(float carats, float refraction){
        this.carats = carats;
        this.refraction = refraction;
        this.price = calcPrice(carats);
    }

    @Override
    public int calcPrice(float carats) {
        return (int) (carats*price_per_one_carat);
    }

    @Override
    public float getRefraction() {
        return refraction;
    }

    @Override
    public float getCarats() {
        return carats;
    }

    @Override
    public String toString() {
        return "\nRubin " +
                "carats=" + carats +
                ", refraction=" + refraction +
                ", price_per_one_carat=" + price_per_one_carat +
                ", price=" + price +
                '}';
    }

    @Override
    public int getPrice() {
        return price;
    }
}
