package com.example.KafkaConsumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.example.KafkaConsumer.Class.RAW;
import com.example.KafkaConsumer.Class.RAW_BODY;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lmax.disruptor.EventHandler;

public class EventOneHandler implements EventHandler<EventOne>
{
    @Override
    public void onEvent(EventOne event, long sequence, boolean endOfBatch)
    {
    	refactor(event.getRecord());
    	System.out.println("[SAMPLE] Task Finished");
    }
    
	public void refactor(ConsumerRecord<byte[], byte[]> record) {
		try {
			Map<String, List<RAW_BODY>> newMap = deserialize(record);
	
			newMap = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, List<RAW_BODY>> deserialize(ConsumerRecord<byte[], byte[]> record) throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
	    byte[] value = record.value();
	    RAW raw = objectMapper.readValue(value, RAW.class);
	
	    Map<String, List<RAW_BODY>> map = new HashMap<>();
	    map.put(raw.getHEADER().getLOCATION(), raw.getBODY());
	    
	    return map;
	}
	
    
}

