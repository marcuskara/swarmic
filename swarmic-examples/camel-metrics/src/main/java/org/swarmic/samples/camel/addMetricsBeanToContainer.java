/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.swarmic.samples.camel;


import io.astefanutti.metrics.cdi.MetricsExtension;
import org.apache.camel.cdi.CdiCamelExtension;
import org.swarmic.core.ContainerConfiguration;
import org.swarmic.core.ContainerConfigurator;

/**
 * Created by antoine on 10/06/2016.
 */
public class addMetricsBeanToContainer implements ContainerConfiguration {
    @Override
    public void configure(ContainerConfigurator configurator) {

        configurator.disableDiscovery()
                .addPackages(true, io.astefanutti.metrics.cdi.MetricsConfiguration.class
                        , org.apache.camel.cdi.CdiCamelContext.class
                        , org.swarmic.samples.camel.Application.class)
                .addExtension(new MetricsExtension())
                .addExtension(new CdiCamelExtension());
    }
}
