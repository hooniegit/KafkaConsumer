package com.example.KafkaConsumer.Disruptor;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class EventOneProducer
{
    private final RingBuffer<EventOne> ringBuffer;

    public EventOneProducer(RingBuffer<EventOne> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    private final EventTranslatorOneArg<EventOne, ConsumerRecord<byte[], byte[]>> TRANSLATOR =
        new EventTranslatorOneArg<EventOne, ConsumerRecord<byte[], byte[]>>()
        {
            @Override
            public void translateTo(EventOne event, long sequence, ConsumerRecord<byte[], byte[]> record)
            {
                event.setRecord(record);
            }
        };

    public void onData(ConsumerRecord<byte[], byte[]> record)
    {
        ringBuffer.publishEvent(TRANSLATOR, record);
    }
}

