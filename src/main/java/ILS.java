public class ILS extends Coin implements java.io.Serializable  {

    final double value = 0.28;


    @Override
    public double getValue() {
        return value;
    }

    public String getConversionType() {
        return "ILS to USD";
    }

    public double calculate(double value) {
        return value * this.value;
    }
}
