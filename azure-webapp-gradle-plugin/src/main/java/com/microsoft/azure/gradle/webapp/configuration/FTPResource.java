/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.gradle.webapp.configuration;

public class FTPResource {
    private String sourcePath;
    private String targetPath;

    public String getSourcePath() {
        return sourcePath;
    }

    public String getTargetPath() {
        return targetPath == null ? "" : targetPath;
    }
}