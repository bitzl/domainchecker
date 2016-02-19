package com.bitzl.domains.domainchecker.core.integration.config;

import com.bitzl.domains.domainchecker.core.integration.transformer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;


@Configuration
public class IntegrationConfig {

    @Autowired
    private IndexTransformer index;

    @Autowired
    private CheckDomainTransformer checkDomain;

    @Autowired
    private AddTldTransformer addTld;

    @Autowired
    private GetDomainTransformer getDomain;

    @Autowired
    private DirectChannel retrieve;

    @Bean
    public DirectChannel checkDomain() {
        return new DirectChannel();
    }

    //@Bean(name = PollerMetadata.DEFAULT_POLLER)
    //public PollerMetadata poller() {
    //    return Pollers.fixedRate(100).get();
    //}

    @Bean
    public IntegrationFlow checkDomainFlow() {
        return IntegrationFlows
                .from(checkDomain())
                .transform(checkDomain)
                .transform(addTld)
                .transform(index)
                .get();
    }

    @Bean
    public IntegrationFlow retrieveDomainFlow() {
        return IntegrationFlows
                .from(retrieve)
                .transform(getDomain)
                .get();
    }

}
