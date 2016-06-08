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

package org.swarmic.sample.rest;

import org.jboss.resteasy.cdi.ResteasyCdiExtension;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.swarmic.core.config.ConfigurationBootstrap;
import org.swarmic.rest.resteasy.Cdi11InjectorFactory;
import org.swarmic.web.spi.ConfigurationProvider;
import org.swarmic.web.undertow.UndertowWebServer;
import org.swarmic.web.undertow.websocket.UndertowWebSocketExtension;

/**
 * Created by antoine on 07/06/2016.
 */
public class Main {

    private WeldContainer cdiContainer;

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.run(args);
    }

    public void run(String... args) {

        cdiContainer = new Weld()
                .disableDiscovery()
                .addPackages(true
                        , org.jboss.resteasy.cdi.CdiConstructorInjector.class
                        , UndertowWebServer.class
                        , Cdi11InjectorFactory.class
                        , ConfigurationBootstrap.class
                        , ConfigurationProvider.class
                        , HelloWorldRest.class)
                .addExtension(new UndertowWebSocketExtension())
                .addExtension(new ResteasyCdiExtension())
                .initialize();
    }

}
