package com.example.KafkaConsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventOne {
	private ConsumerRecord<byte[], byte[]> record;
	
	public void clear() {
		this.record = null;
	}

}
