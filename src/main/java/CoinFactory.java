public class CoinFactory {
    public static Coin getCoinInstance(Coins coins){
        switch (coins){
            case ILS:
                return new ILS();
            case USD:
                return  new USD();
            default:
                throw  new RuntimeException("Invalid currency");
        }
    }
}
