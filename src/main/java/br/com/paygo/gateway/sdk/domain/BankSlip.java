package br.com.paygo.gateway.sdk.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class BankSlip {

    String expirationDate;
    String instructions;
    String guarantor;
    String provider;

}
