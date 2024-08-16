package com.example.KafkaConsumer;

import com.lmax.disruptor.EventHandler;

public class ClearingEventHandler implements EventHandler<EventOne>
{
    @Override
    public void onEvent(EventOne event, long sequence, boolean endOfBatch)
    {
        event.clear(); 
    }
}
