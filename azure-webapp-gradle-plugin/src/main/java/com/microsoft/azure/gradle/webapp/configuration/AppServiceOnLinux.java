/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.azure.gradle.webapp.configuration;

public class AppServiceOnLinux {
    /**
     * Docker image name
     */
    private String runtimeStack;
    private String urlPath;

    public String getRuntimeStack() {
        return runtimeStack;
    }

    public String getUrlPath() {
        return urlPath;
    }
}
