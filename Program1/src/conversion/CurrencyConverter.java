package conversion;

public class CurrencyConverter {

    public static final double IOF = 0.06;

    public static double dollarToReal(double cotacao, double valorEmDolar){
        double valorSemIOF = cotacao * valorEmDolar;
        double valorComIOF = valorSemIOF * (1 + IOF);
        return valorComIOF;
    }
}
