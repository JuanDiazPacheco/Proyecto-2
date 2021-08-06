package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringCurrency {
    private static Locale usa = new Locale("en", "US");
    // Create a formatter given the Locale
    private static NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);

    /**
     * @param dinero
     * @return String
     */
    public static String getMoney(Double dinero) {
        return dollarFormat.format(dinero);
    }
}
