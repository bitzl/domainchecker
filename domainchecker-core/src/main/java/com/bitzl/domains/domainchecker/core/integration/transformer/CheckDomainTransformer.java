package com.bitzl.domains.domainchecker.core.integration.transformer;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class CheckDomainTransformer implements GenericTransformer<Domain, Domain> {

    @Override
    public Domain transform(Domain domain) {
        domain.setExists(checkIfDomainExists(domain.getName()));
        return domain;
    }

//    @Override
//    public Message<?> transform(Message<?> message) {
//        Domain domain = (Domain) message.getPayload();
//        domain.setExists(checkIfDomainExists(domain.getName()));
//        return message;
//    }
//
    private boolean checkIfDomainExists(String domain) {
        try {
            InetAddress.getByName(domain);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
