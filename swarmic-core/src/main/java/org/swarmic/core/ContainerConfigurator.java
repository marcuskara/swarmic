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

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.experimental.InterceptorBuilder;

import javax.enterprise.inject.spi.Extension;
import java.lang.annotation.Annotation;

/**
 *
 * This Container configurator class wrap the actual class to remove dangerous method for third party configurator
 *
 * @author Antoine Sabot-Durand
 */
public class ContainerConfigurator {

    private Weld weld;

    public ContainerConfigurator(Weld weld) {
        this.weld = weld;
    }


    public Weld beanClasses(Class<?>... classes) {
        return weld.beanClasses(classes);
    }

    public Weld addBeanClass(Class<?> beanClass) {
        return weld.addBeanClass(beanClass);
    }

    public Weld packages(Class<?>... packageClasses) {
        return weld.packages(packageClasses);
    }

    public Weld addPackages(boolean scanRecursively, Class<?>... packageClasses) {
        return weld.addPackages(scanRecursively, packageClasses);
    }

    public Weld addPackage(boolean scanRecursively, Class<?> packageClass) {
        return weld.addPackage(scanRecursively, packageClass);
    }

    public Weld extensions(Extension... extensions) {
        return weld.extensions(extensions);
    }

    public Weld addExtension(Extension extension) {
        return weld.addExtension(extension);
    }

    public Weld interceptors(Class<?>... interceptorClasses) {
        return weld.interceptors(interceptorClasses);
    }

    public Weld addInterceptor(Class<?> interceptorClass) {
        return weld.addInterceptor(interceptorClass);
    }

    public Weld decorators(Class<?>... decoratorClasses) {
        return weld.decorators(decoratorClasses);
    }

    public Weld addDecorator(Class<?> decoratorClass) {
        return weld.addDecorator(decoratorClass);
    }

    public Weld alternatives(Class<?>... alternativeClasses) {
        return weld.alternatives(alternativeClasses);
    }

    public Weld addAlternative(Class<?> alternativeClass) {
        return weld.addAlternative(alternativeClass);
    }


    public Weld alternativeStereotypes(Class<? extends Annotation>... alternativeStereotypeClasses) {
        return weld.alternativeStereotypes(alternativeStereotypeClasses);
    }

    public Weld addAlternativeStereotype(Class<? extends Annotation> alternativeStereotypeClass) {
        return weld.addAlternativeStereotype(alternativeStereotypeClass);
    }

    public InterceptorBuilder addInterceptor() {
        return weld.addInterceptor();
    }
}
