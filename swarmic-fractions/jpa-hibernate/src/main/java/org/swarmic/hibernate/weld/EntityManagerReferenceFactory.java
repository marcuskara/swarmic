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

package org.swarmic.hibernate.weld;

import org.jboss.weld.injection.spi.ResourceReference;
import org.jboss.weld.injection.spi.ResourceReferenceFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Implementation of {@link ResourceReferenceFactory} to provide {@link EntityManager} instances
 *
 * @author Antoine Sabot-Durand
 */
public class EntityManagerReferenceFactory implements ResourceReferenceFactory<EntityManager> {

    private String unitName;
    private EntityManagerFactory emf;

    public EntityManagerReferenceFactory(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public ResourceReference<EntityManager> createResource() {
        return new ResourceReference<EntityManager>() {

            private EntityManager em;

            @Override
            public EntityManager getInstance() {
                if(emf == null)
                    emf = Persistence.createEntityManagerFactory(unitName);
                if(em == null)
                    em = emf.createEntityManager();
                return em;
            }

            @Override
            public void release() {
                em.close();
            }
        };
    }
}
