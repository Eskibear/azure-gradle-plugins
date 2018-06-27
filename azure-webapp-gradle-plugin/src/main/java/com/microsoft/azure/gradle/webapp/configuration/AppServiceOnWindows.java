/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.gradle.webapp.configuration;

import com.microsoft.azure.management.appservice.JavaVersion;
import com.microsoft.azure.management.appservice.WebContainer;
import org.apache.commons.lang3.StringUtils;

public class AppServiceOnWindows {
    private String javaWebContainer;
    private String javaVersion;

    public WebContainer getJavaWebContainer() {
        return StringUtils.isEmpty(javaWebContainer)
                ? WebContainer.TOMCAT_8_5_NEWEST
                : WebContainer.fromString(javaWebContainer);
    }

    public JavaVersion getJavaVersion() {
        return StringUtils.isEmpty(javaVersion) ? null : JavaVersion.fromString(javaVersion);
    }
}
