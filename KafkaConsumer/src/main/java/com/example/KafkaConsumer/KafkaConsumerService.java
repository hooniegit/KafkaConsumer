package com.example.KafkaConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	private Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
	
    @KafkaListener(topics = "SampleTopic", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<byte[], byte[]> record, Consumer<?, ?> consumer) {
    	
    	// Do Tasks Here..
    	
        currentOffsets.put(
            new TopicPartition(record.topic(), record.partition()), 
            new OffsetAndMetadata(record.offset() + 1, null)
        );
        consumer.commitAsync((offsets, exception) -> {
            if (exception != null) {
                System.err.printf("Failed to commit offsets: %s%n", exception.getMessage());
            } else {
                System.out.printf("Offsets committed: %s%n", offsets);
            }
        });
    }
	
}
