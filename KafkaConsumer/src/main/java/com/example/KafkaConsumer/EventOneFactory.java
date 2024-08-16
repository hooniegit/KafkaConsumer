package com.example.KafkaConsumer;

import com.lmax.disruptor.EventFactory;

public class EventOneFactory implements EventFactory<EventOne>
{
    @Override
    public EventOne newInstance()
    {
        return new EventOne();
    }
}
