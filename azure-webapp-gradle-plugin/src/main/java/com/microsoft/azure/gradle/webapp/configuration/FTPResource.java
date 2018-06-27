package com.microsoft.azure.gradle.webapp.configuration;

import groovy.lang.Closure;

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