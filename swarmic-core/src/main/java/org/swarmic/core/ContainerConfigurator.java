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

package org.swarmic.core;

import org.jboss.logging.Logger;
import org.jboss.weld.environment.se.Weld;

import javax.enterprise.inject.spi.Extension;
import java.lang.annotation.Annotation;

/**
 * This Container configurator class wrap the actual class to remove dangerous method for third party configurator
 *
 * @author Antoine Sabot-Durand
 */
public class ContainerConfigurator {

    final private static Logger LOG = Logger.getLogger(ContainerConfigurator.class);

    private Weld weld;

    public ContainerConfigurator(Weld weld) {
        this.weld = weld;
    }


    public ContainerConfigurator beanClasses(Class<?>... classes) {
        weld.beanClasses(classes);
        return this;
    }

    public ContainerConfigurator addBeanClass(Class<?> beanClass) {
        weld.addBeanClass(beanClass);
        return this;
    }

    public ContainerConfigurator packages(Class<?>... packageClasses) {
        weld.packages(packageClasses);
        return this;
    }

    public ContainerConfigurator addPackages(boolean scanRecursively, Class<?>... packageClasses) {
        weld.addPackages(scanRecursively, packageClasses);
        return this;
    }

    public ContainerConfigurator addPackage(boolean scanRecursively, Class<?> packageClass) {
        weld.addPackage(scanRecursively, packageClass);
        return this;
    }

    public ContainerConfigurator extensions(Extension... extensions) {
        weld.extensions(extensions);
        return this;
    }

    public ContainerConfigurator addExtension(Extension extension) {
        weld.addExtension(extension);
        return this;
    }

    public ContainerConfigurator interceptors(Class<?>... interceptorClasses) {
        weld.interceptors(interceptorClasses);
        return this;
    }

    public ContainerConfigurator addInterceptor(Class<?> interceptorClass) {
        weld.addInterceptor(interceptorClass);
        return this;
    }

    public ContainerConfigurator decorators(Class<?>... decoratorClasses) {
        weld.decorators(decoratorClasses);
        return this;
    }

    public ContainerConfigurator addDecorator(Class<?> decoratorClass) {
        weld.addDecorator(decoratorClass);
        return this;
    }

    public ContainerConfigurator alternatives(Class<?>... alternativeClasses) {
        weld.alternatives(alternativeClasses);
        return this;
    }

    public ContainerConfigurator addAlternative(Class<?> alternativeClass) {
        weld.addAlternative(alternativeClass);
        return this;
    }


    public ContainerConfigurator alternativeStereotypes(Class<? extends Annotation>... alternativeStereotypeClasses) {
        weld.alternativeStereotypes(alternativeStereotypeClasses);
        return this;
    }

    public ContainerConfigurator addAlternativeStereotype(Class<? extends Annotation> alternativeStereotypeClass) {
        weld.addAlternativeStereotype(alternativeStereotypeClass);
        return this;
    }

    public ContainerConfigurator disableDiscovery() {
        LOG.warn("A container configurator disabled bean discovery");
        weld.disableDiscovery();
        return this;
    }
}
