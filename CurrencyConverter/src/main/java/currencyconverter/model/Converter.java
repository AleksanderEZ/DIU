package currencyconverter.model;

public class Converter {

    public static String decimalDotSeparation(String text) {
        return text.replace(',', '.');
    }

    public static Float convertEurosToDollars(float amount){
        float euroToDolarConversionRate = new EuroDolar().getConversionRate();
        Float amountInDollars = euroToDolarConversionRate * amount;
        return amountInDollars;
    }

    public static Float convertDollarsToEuros(float amount) {
        float dollarToEuroConversionRate = new DolarEuro().getConversionRate();
        Float amountInEuros = dollarToEuroConversionRate * amount;
        return amountInEuros;
    }
}
