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

import org.jboss.logging.Logger;
import org.swarmic.sample.rest.jpa.HelloEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class HelloWorldService {

    @PersistenceContext(unitName = "Swarmic")
    private EntityManager entityManager;

    private static final Logger LOG = Logger.getLogger(HelloWorldService.class);

    public String getHello(String msg) {
        LOG.info("Entity manager is " + (entityManager.isJoinedToTransaction() ? "in a transaction" : "not in a transaction"));
        entityManager.merge(new HelloEntity(msg));
        return "Hello : " + msg;
    }

}