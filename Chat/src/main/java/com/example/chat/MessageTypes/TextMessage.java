package com.example.chat.MessageTypes;

import com.example.chat.ChatClientController;
import com.example.chat.Message;

public class TextMessage extends Message
{
    private final String text;
    private final String name;

    public TextMessage(String text, String name)
    {
        super(TextMessage.class);
        this.text = text;
        this.name = name;
    }

    public String getText()
    {
        return text;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name + ": " + text;
    }
}
