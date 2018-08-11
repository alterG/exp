package nfwya.alterg.services.weather.api;


public abstract class WeatherScreen
{
    /**
     * Display weather info.
     */
    public abstract void display();


    /**
     * Return screen title.
     */
    public abstract ScreenTitle getTitle();


    @Override
    public String toString()
    {
        return getTitle().getCode();
    }
}
