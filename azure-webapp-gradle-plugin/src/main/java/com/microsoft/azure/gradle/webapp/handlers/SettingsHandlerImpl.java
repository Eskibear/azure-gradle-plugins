/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.gradle.webapp.handlers;

import com.microsoft.azure.management.appservice.WebApp.DefinitionStages.WithCreate;
import com.microsoft.azure.management.appservice.WebApp.Update;
import org.gradle.api.GradleException;
import org.gradle.api.Project;

public class SettingsHandlerImpl implements SettingsHandler {
    private Project project;

    public SettingsHandlerImpl(final Project project) {
        this.project = project;
    }

    @Override
    public void processSettings(WithCreate withCreate) throws GradleException {
    }

    @Override
    public void processSettings(Update update) throws GradleException {
    }
}
