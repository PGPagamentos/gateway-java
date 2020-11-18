package br.com.paygo.gateway.sdk.credentials;

public class SimpleCredentialsGateway implements CredentialsGateway {

    private final String api;
    private final String key;

    public SimpleCredentialsGateway(String api, String key) {
        this.api = api;
        this.key = key;
    }

    @Override
    public String getApi() {
        return api;
    }

    @Override
    public String getKey() {
        return key;
    }
}
