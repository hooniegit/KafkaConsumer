package com.example.KafkaConsumer.Disruptor;

import com.lmax.disruptor.EventFactory;

public class EventOneFactory implements EventFactory<EventOne>
{
    @Override
    public EventOne newInstance()
    {
        return new EventOne();
    }
}
