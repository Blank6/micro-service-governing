package org.springcloud.eureka.server.bean;

public class ApplicationEntity {

    private String token;
    private String app;
    private String status;
    private String registryUrl;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistryUrl() {
        return registryUrl;
    }

    public void setRegistryUrl(String registryUrl) {
        this.registryUrl = registryUrl;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "token='" + token + '\'' +
                ", app='" + app + '\'' +
                ", status='" + status + '\'' +
                ", registryUrl='" + registryUrl + '\'' +
                '}';
    }
}
