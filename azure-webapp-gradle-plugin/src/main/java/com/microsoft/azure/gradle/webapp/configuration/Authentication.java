package com.microsoft.azure.gradle.webapp.configuration;

public class Authentication {
    private AuthenticationType type;
    private String file;
    private String client;
    private String tenant;
    private String key;
    private String certificate;
    private String certificatePassword;
    private String environment = "AZURE";


    public String getFile() {
        return file;
    }

    public String getClient() {
        return client;
    }

    public String getTenant() {
        return tenant;
    }

    public String getKey() {
        return key;
    }

    public String getEnvironment() {
        return environment;
    }

    public AuthenticationType getType() {
        return type;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }
}
