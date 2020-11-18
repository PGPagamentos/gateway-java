package br.com.paygo.gateway.sdk.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class Card {

    int type = 0;
    boolean capture = true;
    int installments;
    String softDescriptor;
    boolean saveCard;
    boolean recurrent;
    String provider;
    String providerVersion;
    String codAuthorization;
    String providerReference;
    String providerCode;
    String providerMessage;
    CardInfo cardInfo;

    public Card withCreditCard() {
        this.type = 1;
        return this;
    }

    public Card withDebitCard() {
        this.type = 2;
        return this;
    }

    public Card allTypes() {
        this.type = 0;
        return this;
    }

    public Card authorizeOnly() {
        this.capture = false;
        return this;
    }

    public Card installments(int installments) {
        this.installments = installments;
        return this;
    }
}
