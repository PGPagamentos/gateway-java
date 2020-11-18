package br.com.paygo.gateway.sdk.integration;

import br.com.paygo.gateway.sdk.domain.Intention;
import br.com.paygo.gateway.sdk.domain.IntentionResponse;
import br.com.paygo.gateway.sdk.domain.Transaction;

public interface PayGoGateway {

    IntentionResponse createIntention(Intention intention);

    Transaction detail(String transactionId);

    Transaction capture(String transactionId, String amount);

    Transaction refund(String transactionId, String amount);

}
