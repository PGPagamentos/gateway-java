package br.com.paygo.gateway.sdk.functions;

import java.math.BigDecimal;

public class Converters {

    public static String convertBigDecimalToNumerico(final BigDecimal valor) {
        return valor.toString().replaceAll("\\D", "");
    }
}
