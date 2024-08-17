package com.example.KafkaConsumer.Consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.KafkaConsumer.Disruptor.EventOneProducer;

@Service
public class KafkaConsumerService {
	private Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<>();
	private final EventOneProducer producer;
	
    @Autowired
    public KafkaConsumerService(EventOneProducer producer) {
        this.producer = producer;
    }

	
    @KafkaListener(topics = "WAT", containerFactory = "kafkaListenerContainerFactory")
    public void consume(ConsumerRecord<byte[], byte[]> record, Consumer<?, ?> consumer) {
    	
    	producer.onData(record);
    	
        TopicPartition partition = new TopicPartition(record.topic(), record.partition());
        OffsetAndMetadata offset = new OffsetAndMetadata(record.offset() + 1, null);
        currentOffsets.put(partition, offset);
    	
        consumer.commitAsync((offsets, exception) -> {
            if (exception != null) {
                System.err.printf("[Consumer] Failed to commit offsets: %s%n", exception.getMessage());
            } else {
            	// System.out.printf("[Consumer] Offsets committed: %s%n", offsets);
                currentOffsets.remove(partition);
            }
        });
    }
	
}
