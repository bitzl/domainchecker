package com.bitzl.domains.domainchecker.core.integration.transformer;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class IndexTransformer implements DomainTransformer {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexTransformer.class);

    @Override
    public Domain transform(Domain domain) {
        domain.setExists(true);
        LOGGER.info("Indexed " + domain.getName() + ".");
        return domain;
    }

}
