package com.example.javafxuebung;

import java.util.Locale;

public class Language
{
    private static Locale locale;

    public static Locale getLocale()
    {
        if (locale == null)
        {
            locale = new Locale("de", "DE");
        }

        return locale;
    }

    public static void setLocale(Locale locale1)
    {
        locale = locale1;
    }
}
