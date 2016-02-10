package com.bitzl.domains.domainchecker.feeder.integration.transformer;

import org.junit.Before;
import org.junit.Test;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by marcu on 08.02.2016.
 */
public class HunspellWordTransformerTest {

    private HunspellWordTransformer wordTransformer;

    @Before
    public void setUp() {
        wordTransformer = new HunspellWordTransformer();
    }


    private String transform(String word) {
        Message<String> message = MessageBuilder.withPayload(word).build();
        Message<?> response = wordTransformer.transform(message);
        return (String) response.getPayload();
    }

    @Test
    public void extractShouldReturnNothingForEmptyLine() {
        assertThat(transform(""), is(nullValue()));
    }

    @Test
    public void extractShouldReturnNothingForXMLLine() {
        assertThat(transform("<div id='cgit'><table id='header'>"), is(nullValue()));
    }

    @Test
    public void extractShouldReturnWordForLineWithSingleWord() {
        assertThat(transform("Wasser"), is("Wasser"));
    }

    @Test
    public void extractShouldReturnWordForLineWithSlash() {
        assertThat(transform("Yuletide/5      1"), is("Yuletide"));
    }

    @Test
    public void extractShouldReturnWordForLineWithoutSlash() {
        assertThat(transform("yum     1"), is("yum"));
    }

}
