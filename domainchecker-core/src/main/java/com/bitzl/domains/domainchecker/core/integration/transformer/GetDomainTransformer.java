package com.bitzl.domains.domainchecker.core.integration.transformer;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.stereotype.Component;

@Component
public class GetDomainTransformer implements GenericTransformer<String, Domain> {

    @Override
    public Domain transform(String name) {
        return new Domain(name);
    }

}
