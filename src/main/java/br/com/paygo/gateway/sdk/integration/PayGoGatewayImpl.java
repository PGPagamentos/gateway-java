package br.com.paygo.gateway.sdk.integration;

import br.com.paygo.gateway.sdk.credentials.CredentialsGateway;
import br.com.paygo.gateway.sdk.credentials.EnvironmentInterface;
import br.com.paygo.gateway.sdk.domain.Intention;
import br.com.paygo.gateway.sdk.domain.IntentionResponse;
import br.com.paygo.gateway.sdk.domain.Transaction;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PayGoGatewayImpl implements PayGoGateway {

    private static final String AUTHENTICATION_API = "authenticationApi";
    private static final String AUTHENTICATION_KEY = "authenticationKey";

    private final CredentialsGateway credentials;
    private final EnvironmentInterface environment;
    private final RestTemplate restTemplate;

    public PayGoGatewayImpl(CredentialsGateway credentials, EnvironmentInterface environment) {
        this.credentials = credentials;
        this.environment = environment;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public IntentionResponse createIntention(Intention intention) {
        return restTemplate.exchange(
                environment.getApiUrlByPath("/v1/intention"),
                HttpMethod.POST,
                new HttpEntity(intention, getCredentialsHeaders()),
                IntentionResponse.class).getBody();
    }

    @Override
    public Transaction detail(String transactionId) {
        return restTemplate.exchange(
                environment.getApiUrlByPath("/v1/transactions/"+ transactionId),
                HttpMethod.GET,
                new HttpEntity(null, getCredentialsHeaders()),
                Transaction.class).getBody();
    }

    @Override
    public Transaction capture(String transactionId, String amount) {
        return restTemplate.exchange(
                environment.getApiUrlByPath("/v1/transactions/" + transactionId + "/capture"),
                HttpMethod.PUT,
                new HttpEntity<>(null, getCredentialsHeaders()),
                Transaction.class).getBody();
    }

    @Override
    public Transaction refund(String transactionId, String amount) {
        return restTemplate.exchange(
                environment.getApiUrlByPath("/v1/transactions/" + transactionId + "/void"),
                HttpMethod.PUT,
                new HttpEntity<>(null, getCredentialsHeaders()),
                Transaction.class).getBody();
    }

    private MultiValueMap<String, String> getCredentialsHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHENTICATION_API, credentials.getApi());
        headers.add(AUTHENTICATION_KEY, credentials.getKey());
        return headers;
    }
}
