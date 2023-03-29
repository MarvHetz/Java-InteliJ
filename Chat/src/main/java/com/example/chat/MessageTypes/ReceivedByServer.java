package com.example.chat.MessageTypes;

import com.example.chat.Message;

import java.lang.reflect.Type;

public class ReceivedByServer extends Message
{
    public ReceivedByServer()
    {
        super(ReceivedByServer.class);
    }
}
