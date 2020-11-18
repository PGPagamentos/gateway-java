package br.com.paygo.gateway.sdk.notification;

import br.com.paygo.gateway.sdk.credentials.CredentialsGateway;
import br.com.paygo.gateway.sdk.credentials.Environment;
import br.com.paygo.gateway.sdk.credentials.SimpleCredentialsGateway;
import br.com.paygo.gateway.sdk.domain.Transaction;
import br.com.paygo.gateway.sdk.integration.PayGoGateway;
import br.com.paygo.gateway.sdk.integration.PayGoGatewayImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NotificationResource {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/paygo/notification")
    public ResponseEntity<?> receiveNotification(@RequestBody Notification notification) {
        log.info("transactionId: {} - referenceId: {}", notification.getTransactionId(), notification.getReferenceId());

        //Validamos se o transactionId e/ou referenceId existem do nosso lado.

        //Realizar a consulta
        // credenciais do lojista
        CredentialsGateway credentials = new SimpleCredentialsGateway("paygo_1602676071635", "7D2BB95675B36AEE26DB");

        // Interface com acesso a um determinado ambiente
        PayGoGateway payGoGateway = new PayGoGatewayImpl(credentials, Environment.SANDBOX);

        Transaction transaction = payGoGateway.detail(notification.getTransactionId());

        log.info("Status da transação: {}", transaction.getStatus().getDescription());

        return ResponseEntity.ok().build();
    }

}
