package com.bitzl.domains.domainchecker.core.integration.transformer;

import com.bitzl.domains.domainchecker.core.model.Domain;
import org.springframework.integration.transformer.GenericTransformer;

public interface DomainTransformer extends GenericTransformer<Domain, Domain> {
}
