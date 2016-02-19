package com.bitzl.domains.domainchecker.core.integration.transformer;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.stereotype.Component;

@Component
public class AddTldTransformer implements DomainTransformer {

    @Override
    public Domain transform(Domain domain) {
        domain.setTld(extractTld(domain.getName()));
        return domain;
    }

    private String extractTld(String name) {
        return name.substring(name.lastIndexOf(".") + 1);
    }
}
