/*
 * Copyright 2016 Hammock and its contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ws.ament.hammock.web.base;

import ws.ament.hammock.web.spi.FilterDescriptor;
import ws.ament.hammock.web.spi.ServletDescriptor;
import ws.ament.hammock.web.spi.WebServer;
import ws.ament.hammock.web.spi.WebServerConfiguration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWebServer implements WebServer {
    private final List<ServletDescriptor> servletDescriptors = new ArrayList<>();
    private final List<FilterDescriptor> filterDescriptors = new ArrayList<>();
    private final Map<String, Object> servletContextAttributes = new HashMap<>();
    private final WebServerConfiguration webServerConfiguration;
    private final Map<String, String> initParams = new HashMap<>();

    protected AbstractWebServer(WebServerConfiguration webServerConfiguration) {
        this.webServerConfiguration = webServerConfiguration;
    }

    @Override
    public void addServlet(ServletDescriptor servletDescriptor) {
        this.servletDescriptors.add(servletDescriptor);
    }

    @Override
    public void addServletContextAttribute(String name, Object value) {
        servletContextAttributes.put(name, value);
    }

    @Override
    public void addFilter(FilterDescriptor filterDescriptor) {
        this.filterDescriptors.add(filterDescriptor);
    }

    @Override
    public void addInitParameter(String key, String value) {
        initParams.put(key, value);
    }

    protected List<ServletDescriptor> getServletDescriptors() {
        return Collections.unmodifiableList(servletDescriptors);
    }

    protected Map<String, Object> getServletContextAttributes() {
        return Collections.unmodifiableMap(servletContextAttributes);
    }

    protected Map<String, String> getInitParams() {
        return Collections.unmodifiableMap(initParams);
    }

    protected List<FilterDescriptor> getFilterDescriptors() {
        return Collections.unmodifiableList(filterDescriptors);
    }

    public WebServerConfiguration getWebServerConfiguration() {
        return webServerConfiguration;
    }
}
