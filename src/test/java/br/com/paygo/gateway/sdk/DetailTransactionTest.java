package br.com.paygo.gateway.sdk;

import br.com.paygo.gateway.sdk.credentials.CredentialsGateway;
import br.com.paygo.gateway.sdk.credentials.Environment;
import br.com.paygo.gateway.sdk.credentials.SimpleCredentialsGateway;
import br.com.paygo.gateway.sdk.domain.Transaction;
import br.com.paygo.gateway.sdk.integration.PayGoGateway;
import br.com.paygo.gateway.sdk.integration.PayGoGatewayImpl;
import org.junit.jupiter.api.Test;

public class DetailTransactionTest {

    @Test
    public void detail() {
        // credenciais do lojista
        CredentialsGateway credentials = new SimpleCredentialsGateway("paygo_1602676071635", "7D2BB95675B36AEE26DB");

        // Interface com acesso a um determinado ambiente
        PayGoGateway payGoGateway = new PayGoGatewayImpl(credentials, Environment.SANDBOX);

        Transaction transaction = payGoGateway.detail("3150a983-b987-45e5-8c2a-968654a3782f");

        System.out.println("Status da transação: "+ transaction.getStatus().getDescription());
    }

}
