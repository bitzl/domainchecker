package com.bitzl.domains.domainchecker.core.controller;

import com.bitzl.domains.domainchecker.core.integration.gateways.CheckDomainGateway;
import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DomainController {
    
    @Autowired
    private CheckDomainGateway gateway;

    @RequestMapping(path = "/domain/{name:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Domain check(@PathVariable String name) {
        return gateway.check(new Domain(name));
    }


    @RequestMapping(path = "/domain/{domain:.+}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Domain put(@PathVariable String domain) {
        return gateway.check(new Domain(domain));
    }

}
