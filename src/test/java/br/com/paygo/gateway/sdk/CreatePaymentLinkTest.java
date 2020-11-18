package br.com.paygo.gateway.sdk;

import br.com.paygo.gateway.sdk.credentials.CredentialsGateway;
import br.com.paygo.gateway.sdk.credentials.Environment;
import br.com.paygo.gateway.sdk.credentials.SimpleCredentialsGateway;
import br.com.paygo.gateway.sdk.domain.Card;
import br.com.paygo.gateway.sdk.domain.Intention;
import br.com.paygo.gateway.sdk.domain.IntentionResponse;
import br.com.paygo.gateway.sdk.integration.PayGoGateway;
import br.com.paygo.gateway.sdk.integration.PayGoGatewayImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreatePaymentLinkTest {

    @Test
    public void createLink() {
        // credenciais do lojista
        CredentialsGateway credentials = new SimpleCredentialsGateway("paygo_1602676071635", "7D2BB95675B36AEE26DB");

        // Interface com acesso a um determinado ambiente
        PayGoGateway payGoGateway = new PayGoGatewayImpl(credentials, Environment.SANDBOX);

        // Criando um link de pagamento (Intenção de venda)
        Intention intention = new Intention("001", BigDecimal.valueOf(1000));
        intention.setDescription("Teste Link de Pagamento.");
        Card card = new Card().allTypes().installments(6).authorizeOnly();
        intention.getPayment().setCard(card);

        IntentionResponse intentionResponse = payGoGateway.createIntention(intention);

        System.out.println("Compartilhe o link com o pagador para efetuar o pagamento: "+ intentionResponse.getUrl());
    }

}
