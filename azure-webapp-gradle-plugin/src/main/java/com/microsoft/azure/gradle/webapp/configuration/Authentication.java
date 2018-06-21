package com.microsoft.azure.gradle.webapp.configuration;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Optional;

public class Authentication {
    @Input
    private AuthenticationType type;
    @Input
    @Optional
    public String file;
    @Input
    @Optional
    public String client;
    @Input
    @Optional
    public String tenant;
    @Input
    @Optional
    public String key;
    @Input
    @Optional
    public String certificate;
    @Input
    @Optional
    public String certificatePassword;
    @Input
    @Optional
    public String environment = "AZURE";


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
