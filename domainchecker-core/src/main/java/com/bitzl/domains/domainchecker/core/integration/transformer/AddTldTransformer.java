package com.bitzl.domains.domainchecker.core.integration.transformer;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class AddTldTransformer implements Transformer {

    @Override
    public Message<?> transform(Message<?> message) {
        Domain domain = (Domain) message.getPayload();
        domain.setTld(extractTld(domain.getName()));
        return message;
    }

    private String extractTld(String domain) {
        return domain.substring(domain.lastIndexOf(".") + 1);
    }
}
