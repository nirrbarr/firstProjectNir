public class USD extends Coin implements java.io.Serializable{

    final double value = 3.52;


    @Override
    public double getValue() {
        return value;
    }
    public String getConversionType() {
        return "USD to ILS";
    }

    public double calculate(double value) {
        return value * this.value;
    }
}
