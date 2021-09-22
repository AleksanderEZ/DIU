package currencyconverter.model;

public class EuroDolar implements ExchangeRate{
    private final float CONVERSION_RATE = 1.17f;

    @Override
    public float getConversionRate() {
        return CONVERSION_RATE;
    }
}
