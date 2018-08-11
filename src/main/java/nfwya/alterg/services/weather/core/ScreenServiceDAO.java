package nfwya.alterg.services.weather.core;


import java.util.Optional;

import nfwya.alterg.services.weather.api.ScreenTitle;
import nfwya.alterg.services.weather.api.WeatherScreen;


/**
 * Administrate weather screens.
 */
public interface ScreenServiceDAO
{
    Optional<WeatherScreen> getByTitle(final ScreenTitle title);
}
