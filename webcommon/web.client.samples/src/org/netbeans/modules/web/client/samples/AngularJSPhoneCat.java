/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.web.client.samples;

import org.netbeans.api.templates.TemplateRegistration;
import org.netbeans.modules.web.client.samples.wizard.iterator.OnlineSampleWizardIterator;
import org.netbeans.modules.web.client.samples.wizard.iterator.OnlineSiteTemplate;
import org.netbeans.modules.web.clientproject.createprojectapi.CreateProjectProperties;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;

/**
 *
 * @author Martin Janicek
 */
@NbBundle.Messages({
    "AngularJSSample=AngularJS Phone Catalog Tutorial"
})
@TemplateRegistration(
    position = 600,
    folder = "Project/Samples/HTML5",
    displayName = "#AngularJSSample",
    iconBase = "org/netbeans/modules/web/client/samples/resources/HTML5_project_icon.png",
    description = "/org/netbeans/modules/web/client/samples/resources/AngularJSPhoneCat.html"
)
public class AngularJSPhoneCat extends OnlineSampleWizardIterator {

    @Override
    protected OnlineSiteTemplate getSiteTemplate() {
        return new AngularJSTemplate(
                getProjectName(),
                getProjectZipURL(),
                "angular-angular-phonecat-step-11-0-g9aebada.zip"); // NOI18N
    }

    @Override
    protected String getProjectName() {
        return "AngularJSPhoneCat"; // NOI18N
    }

    @Override
    protected String getProjectZipURL() {
        return "https://github.com/angular/angular-phonecat/archive/master.zip"; // NOI18N
    }

    private static class AngularJSTemplate extends OnlineSiteTemplate {

        public AngularJSTemplate(String name, String url, String zipName) {
            super(name, url, zipName);
        }

        @Override
        public void configure(CreateProjectProperties projectProperties) {
            projectProperties.setSiteRootFolder("app") // NOI18N
                    .setTestFolder("test") // NOI18N
                    .setJsTestingProvider("Karma"); // NOI18N
        }

        @Override
        protected FileObject getTargetDir(FileObject projectDir, CreateProjectProperties projectProperties) {
            return projectDir;
        }
    }
}