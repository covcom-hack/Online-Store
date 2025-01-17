package com.zufar.onlinestore.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Aws-Profile")
@Service
@RequiredArgsConstructor
public class SqsMessageSender {
    private static final String QUEUE_URL = System.getProperty("AWS_QUEUE_URL");

    private final AmazonSQS sqsClient;

    public void send(final String messageBody) {
        final SendMessageRequest message = new SendMessageRequest()
                .withQueueUrl(QUEUE_URL)
                .withMessageBody(messageBody)
                .withDelaySeconds(5);

        sqsClient.sendMessage(message);
    }
}
