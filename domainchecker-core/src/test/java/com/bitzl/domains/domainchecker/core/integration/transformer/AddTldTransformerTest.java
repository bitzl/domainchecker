package com.bitzl.domains.domainchecker.core.integration.transformer;


import com.bitzl.domains.domainchecker.core.model.Domain;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AddTldTransformerTest {

    @Test
    public void transformShouldSetTld() {
        DomainTransformer transformer = new AddTldTransformer();
        Domain domain = transformer.transform(new Domain("djaksdhasdhk.xdf"));
        assertThat(domain.getTld(), is("xdf"));
    }

}
