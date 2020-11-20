import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Welcome to currency converter!");
        List<Result> resultList = new ArrayList<Result>();
        while(true) {
            Coin coin = choose_currency();
            Result result = enter_amount_screen(coin);
            resultList.add(result);
            if (!show_result_screen(result)){
                System.out.println("Thanks for using the program!");
                print_past_results(resultList);
                write_results_to_file(resultList);
                return;
            }
        }
    }
    static void print_past_results(List<Result> resultList){
        for (Result res: resultList){
            System.out.println(res.toString());
        }
    }

    static void write_results_to_file(List<Result> resultList) {
        try {
            FileOutputStream out = new FileOutputStream("results.txt");
            for (Result res : resultList) {
                out.write((res.toString()+"\n").getBytes());
            }
            out.close();
        }
        catch (Exception exception){
            System.out.println("Error writing results to file");
        }
    }

    static boolean show_result_screen(Result result){
        Scanner scanner = new Scanner(System.in);
        System.out.println(result.toString());
        while(true){
            System.out.println("Start over? (Y/N)");
            String input = scanner.next();
            if(input.toUpperCase().equals("Y")) return true;
            if(input.toUpperCase().equals("N")) return false;
            System.out.println("Invalid selection");
        }
    }


    public static Coin choose_currency(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Please choose an option(1/2):");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    return CoinFactory.getCoinInstance(Coins.ILS);
                case 2:
                    return CoinFactory.getCoinInstance(Coins.USD);
                default:
                    System.out.println("Invalid choice, try again");
            }
        }

    }

    private static Result enter_amount_screen(Coin coin){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount to convert:");
        double input = scanner.nextDouble();
        double output = coin.calculate(input);
        return new Result(input, output, coin.getConversionType());
    }

}
