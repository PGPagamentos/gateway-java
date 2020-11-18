package br.com.paygo.gateway.sdk.credentials;

public enum Environment implements EnvironmentInterface {

    PRODUCTION("https://api.gate2all.com.br"), SANDBOX("https://apidemo.gate2all.com.br");

    private String api;

    Environment(String api) {
        this.api = api;
    }

    @Override
    public String getApiUrl() {
        return api;
    }

    @Override
    public String getApiUrlByPath(String path) {
        return this.api + path;
    }
}
