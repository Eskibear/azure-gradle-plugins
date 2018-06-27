/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.gradle.webapp.handlers;

import com.microsoft.azure.gradle.webapp.DeployTask;
import com.microsoft.azure.gradle.webapp.configuration.*;
import com.microsoft.azure.gradle.webapp.helpers.WebAppUtils;
import org.gradle.api.GradleException;
import org.gradle.api.Project;

public class HandlerFactoryImpl extends HandlerFactory {
    private static final String RUNTIME_CONFIG_CONFLICT = "'appServiceOnWindows' is for Web App on Windows; " +
            "'appServiceOnLinux' is for Web App on Linux; " +
            "'containerSettings' is for Web App for Containers; only one can be specified at the same time.";
    private static final String IMAGE_NAME_MISSING = "'imageName' not found within 'containerSettings'.";
    public static final String DEPLOYMENT_TYPE_NOT_FOUND = "deployment.type is not configured in build.gradle.";
    public static final String UNKNOWN_DEPLOYMENT_TYPE = "Unknown value from deployment.type configured in build.gradle.";

    @Override
    public RuntimeHandler getRuntimeHandler(final DeployTask task) throws GradleException {
        AppServiceOnWindows appServiceOnWindows = task.getAzureWebAppExtension().getAppServiceOnWindows();

        AppServiceOnLinux appServiceOnLinux = task.getAzureWebAppExtension().getAppServiceOnLinux();
        final ContainerSettings containerSettings = task.getAzureWebAppExtension().getContainerSettings();
        // No configuration is specified
        if (appServiceOnLinux == null && appServiceOnWindows == null && containerSettings == null ) {
            return new NullRuntimeHandlerImpl();
        }

        // More than one configuration specified
        if ((appServiceOnLinux != null && containerSettings != null) || (containerSettings != null && appServiceOnWindows != null) ||
                (appServiceOnLinux != null && appServiceOnWindows != null))  {
            throw new GradleException(RUNTIME_CONFIG_CONFLICT);
        }

        if (appServiceOnWindows != null) {
            return new JavaRuntimeHandlerImpl(task);
        }

        if (appServiceOnLinux != null) {
            return new LinuxRuntimeHandlerImpl(task);
        }

        final DockerImageType imageType = WebAppUtils.getDockerImageType(containerSettings);
        task.getLogger().quiet("imageType: " + imageType);
        switch (imageType) {
            case PUBLIC_DOCKER_HUB:
                return new PublicDockerHubRuntimeHandlerImpl(task);
            case PRIVATE_DOCKER_HUB:
                return new PrivateDockerHubRuntimeHandlerImpl(task);
            case PRIVATE_REGISTRY:
                return new PrivateRegistryRuntimeHandlerImpl(task);
            case NONE:
                throw new GradleException(IMAGE_NAME_MISSING);
        }

        throw new GradleException(NullRuntimeHandlerImpl.NO_RUNTIME_CONFIG);
    }

    @Override
    public SettingsHandler getSettingsHandler(final Project project) throws GradleException {
        return new SettingsHandlerImpl(project);
    }

    @Override
    public ArtifactHandler getArtifactHandler(final DeployTask task) throws GradleException {
        Deployment deployment = task.getAzureWebAppExtension().getDeployment();
        switch (deployment.getType()) {
            case NONE:
                throw new GradleException(DEPLOYMENT_TYPE_NOT_FOUND);
            case UNKNOWN:
                throw new GradleException(UNKNOWN_DEPLOYMENT_TYPE);
            case WAR:
                return new WarDeployHandlerImpl(task);
            case FTP:
            default:
                return new FTPArtifactHandlerImpl(task.getProject());
        }
    }
}
