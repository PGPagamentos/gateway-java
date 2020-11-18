package br.com.paygo.gateway.sdk.domain;

import br.com.paygo.gateway.sdk.functions.Converters;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class Intention {

    String referenceId;
    String amount;
    String description;
    String redirectUrl;
    String postBackUrl;
    String dtExpiration;

    Payment payment;

    public Intention (String referenceId, BigDecimal amount) {
        this.referenceId = referenceId;
        this.amount = Converters.convertBigDecimalToNumerico(amount);
        this.payment = new Payment();
    }

    public Intention withPostBackUrl(String postBackUrl) {
        this.postBackUrl = postBackUrl;
        return this;
    }
}
