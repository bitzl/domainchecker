package com.bitzl.domains.domainchecker.core.integration.gateways;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway
public interface CheckDomainGateway {

    @Gateway(requestChannel="checkDomain")
    Domain check(Domain domain);

    @Gateway(requestChannel = "checkDomain")
    Domain addOrUpdate(Domain domain);

    // @Gateway(requestChannel = "retrieve")
    // Domain get(String hostname);
}
