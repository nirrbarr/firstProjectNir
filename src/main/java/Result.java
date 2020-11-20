public class Result {
    private String conversion_type;
    private double input;
    private double output;
    public  Result(double input, double output, String conversion_type){
        this.conversion_type = conversion_type;
        this.output = output;
        this.input = input;
    }

    public String toString(){
        return String.valueOf(input) + " " + conversion_type + " = " + String.valueOf(output);
    }
}
