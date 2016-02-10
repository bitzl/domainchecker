package com.bitzl.domains.domainchecker.feeder.integration.transformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.integration.transformer.Transformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class HunspellWordTransformer implements Transformer {

    private final static Pattern PATTERN = Pattern.compile("^(\\w+)");

    public String extractWord(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
    
    @Override
    public Message<?> transform(Message<?> message) {
        String line = (String) message.getPayload();
        String word = extractWord(line);
        return MessageBuilder.createMessage(word, message.getHeaders());
    }

}
