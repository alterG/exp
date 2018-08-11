package nfwya.alterg.services.weather.core.screen;


import nfwya.alterg.services.weather.api.ScreenTitle;
import nfwya.alterg.services.weather.api.WeatherScreen;
import org.springframework.stereotype.Component;


/**
 * Statistic screen {@link ScreenTitle#STATISTIC}.
 */
@Component
public class StatisticScreen extends WeatherScreen
{
    @Override
    public void display()
    {

    }


    @Override
    public ScreenTitle getTitle()
    {
        return ScreenTitle.STATISTIC;
    }
}
