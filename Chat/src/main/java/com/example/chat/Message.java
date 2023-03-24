package com.example.chat;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Message
{
    private final String sender;
    private String message;
    private ImageView image;

    public Message(String sender, String message, ImageView image)
    {
        this.sender = sender;
        this.message = message;
        this.image = image;

        this.image.setFitHeight(25);
        this.image.setFitWidth(20);
    }

    public Message(String sender, String message)
    {
        this.sender = sender;
        this.message = message;
    }

    public Message(String sender, ImageView image)
    {
        this.sender = sender;
        this.image = image;
    }
    public ImageView getImage()
    {
        return image;
    }

    public String getSender()
    {
        return sender;
    }

    public String getMessage()
    {
        return message;
    }
}
