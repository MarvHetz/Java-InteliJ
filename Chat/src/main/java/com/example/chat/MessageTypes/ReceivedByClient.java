package com.example.chat.MessageTypes;

import com.example.chat.Message;

import java.lang.reflect.Type;

public class ReceivedByClient extends Message
{
    private String name;
    public ReceivedByClient(String name)
    {
        super(ReceivedByClient.class);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
