package nfwya.alterg.services.weather.core;


import java.util.ArrayList;
import java.util.Collection;

import nfwya.alterg.services.weather.api.ScreenTitle;
import nfwya.alterg.services.weather.api.WeatherScreen;


public class Customer
{
    private String name;

    private final Collection<WeatherScreen> screens;


    public Customer(final String name)
    {
        this.name = name;
        this.screens = new ArrayList<>();
    }


    public void addScreen(final ScreenTitle title)
    {
        screens.add(screen);
    }


    public void removeScreen(final ScreenTitle title)
    {
        screens.remove(screen);
    }


    @Override
    public String toString()
    {
        return "Customer{" +
                "name='" + name + '\'' +
                ", screens=" + screens +
                '}';
    }
}
