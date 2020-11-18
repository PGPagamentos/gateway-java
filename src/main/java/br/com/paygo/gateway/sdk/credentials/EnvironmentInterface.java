package br.com.paygo.gateway.sdk.credentials;

public interface EnvironmentInterface {

    String getApiUrl();

    String getApiUrlByPath(String path);

}
