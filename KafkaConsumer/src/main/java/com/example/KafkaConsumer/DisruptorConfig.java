package com.example.KafkaConsumer;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DisruptorConfig {

    @Bean
    public Disruptor<EventOne> disruptor() {
        int bufferSize = 1024;

        Disruptor<EventOne> disruptor = new Disruptor<>(
        		EventOne::new, 
        		bufferSize, 
        		DaemonThreadFactory.INSTANCE,
        		ProducerType.SINGLE,
        		new SleepingWaitStrategy());
        EventOneHandler handlerOne = new EventOneHandler();
        ClearingEventHandler handlerTwo = new ClearingEventHandler();
        
        disruptor.handleEventsWith(handlerOne)
        		 .then(handlerTwo);
        disruptor.start();
        
        handlerOne = null;
        handlerTwo = null;
        
        return disruptor;
    }

    @Bean
    public RingBuffer<EventOne> ringBuffer(Disruptor<EventOne> disruptor) {
    	System.out.println("[Config] Will Return Ring Buffer");
        return disruptor.getRingBuffer();
    }

    @Bean
    public EventOneProducer eventProducer(RingBuffer<EventOne> ringBuffer) {
    	System.out.println("[Config] Will Return EventProducer");
        return new EventOneProducer(ringBuffer);
    }
}


