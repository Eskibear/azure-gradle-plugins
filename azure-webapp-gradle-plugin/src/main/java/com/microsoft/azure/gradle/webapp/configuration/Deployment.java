/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.gradle.webapp.configuration;

import groovy.lang.Closure;

import java.util.ArrayList;
import java.util.List;

public class Deployment {
    private DeploymentType type;
    private String warFile;
    private String contextPath;
    private List<FTPResource> resources = new ArrayList<FTPResource>();

    public DeploymentType getType() {
        return this.type;
    }

    public String getWarFile() {
        return this.warFile;
    }

    public List<FTPResource> getResources() {
        return this.resources;
    }

    public void setResources(List<Closure> closures) {
        if (closures != null && !closures.isEmpty()) {
            closures.forEach(closure -> {
                FTPResource item = new FTPResource();
                org.gradle.util.ConfigureUtil.configure(closure, item);
                resources.add(item);
            });
        }
    }

    public String getContextPath() {
        return this.contextPath == null ? "" : this.contextPath;
    }
}
