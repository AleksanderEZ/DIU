package currencyconverter.model;

public class DolarEuro implements Converter{
    private final float CONVERSION_RATE = 0.85f;

    @Override
    public float getConversionRate() {
        return CONVERSION_RATE;
    }
}
