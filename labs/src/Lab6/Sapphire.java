package Lab6;

public class Sapphire extends Stone{
    float carats;
    float  refraction;
    final int price_per_one_carat = 300;

    int price ;

    public Sapphire(float carats, float refraction){
        this.carats = carats;
        this.refraction = refraction;
        this.price = calcPrice(carats);
    }

    @Override
    public float getRefraction() {
        return refraction;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public float getCarats() {
        return carats;
    }



    @Override
    public int calcPrice(float carats) {
        return (int) (carats*price_per_one_carat);
    }

    @Override
    public String toString() {
        return "\nSapphire " +
                "carats=" + carats +
                ", refraction=" + refraction +
                ", price_per_one_carat=" + price_per_one_carat +
                ", price=" + price +
                '}';
    }
}
