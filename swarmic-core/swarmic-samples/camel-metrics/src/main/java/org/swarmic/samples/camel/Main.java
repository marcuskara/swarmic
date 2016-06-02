package org.swarmic.samples.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.MainSupport;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.UnsatisfiedResolutionException;
import javax.enterprise.inject.Vetoed;
import java.util.HashMap;
import java.util.Map;


/**
 * This class starts CDI container and Camel.
 * It based on Camel MainSupport class
 */
@Vetoed
public class Main extends MainSupport {


    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private WeldContainer cdiContainer;

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.run(args);
    }


    @Override
    protected ProducerTemplate findOrCreateCamelTemplate() {
        Instance<CamelContext> contexts=getCamelContextInstances();
        if (contexts.isUnsatisfied()) {
            throw new UnsatisfiedResolutionException("No default Camel context is deployed, cannot create default ProducerTemplate!");
        }
        CamelContext context = contexts.get();
        return context.createProducerTemplate();
    }

    @Override
    protected Map<String, CamelContext> getCamelContextMap() {
        Map<String, CamelContext> answer = new HashMap<>();
        for (CamelContext context : getCamelContextInstances()) {
            answer.put(context.getName(), context);
        }
        return answer;
    }

    private Instance<CamelContext> getCamelContextInstances() {
        return cdiContainer.instance().select(CamelContext.class);
    }

    @Override
    protected void doStart() throws Exception {

        cdiContainer= new Weld()
                .initialize();

        // TODO: Switch to CDI 2.0 boot when available in Weld 3
        super.doStart();
        postProcessContext();
        warnIfNoCamelFound();
    }

    private void warnIfNoCamelFound() {
        // Warn if there is no CDI Camel contexts
        if (getCamelContextInstances().isUnsatisfied()) {
            LOG.warn("Camel CDI main has started with no Camel context!");
        }
    }

    @Override
    protected void doStop() throws Exception {
        super.doStop();
        if (cdiContainer != null) {
            cdiContainer.shutdown();
        }
    }
}
