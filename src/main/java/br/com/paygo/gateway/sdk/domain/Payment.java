package br.com.paygo.gateway.sdk.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class Payment {

    Card card;
    BankSlip bankSlip;
    Pix pix;

}
