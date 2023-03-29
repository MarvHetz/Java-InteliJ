package com.example.chat;

import java.io.Serializable;
import java.lang.reflect.Type;

public abstract class Message implements Serializable
{
    private final Type type;
    public Message(Type type)
    {
        this.type = type;
    }

    public Type getType()
    {
        return type;
    }
}
