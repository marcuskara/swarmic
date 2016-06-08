/*******************************************************************************
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
 ******************************************************************************/

package org.swarmic.samples.camel;

import com.codahale.metrics.Meter;
import org.apache.camel.Exchange;
import org.apache.camel.RuntimeExchangeException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UnreliableService {

    @Inject
    private Meter attempt;

    //@Metered
    // TODO: activate global interceptor when PAXCDI-216 is fixed
    public void attempt(Exchange exchange) {
        attempt.mark();

        if (Math.random() < 0.5)
            throw new RuntimeExchangeException("Random failure", exchange);
    }
}
