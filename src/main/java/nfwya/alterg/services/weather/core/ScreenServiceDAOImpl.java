package nfwya.alterg.services.weather.core;


import java.util.Map;
import java.util.Optional;

import com.google.common.collect.ImmutableMap;
import nfwya.alterg.services.weather.api.ScreenTitle;
import nfwya.alterg.services.weather.api.WeatherScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 * Temporary implementation using local map.
 */
@Repository
public class ScreenServiceDAOImpl implements ScreenServiceDAO
{
    private static final Logger logger = LoggerFactory.getLogger(ScreenServiceDAOImpl.class);

    private final Map<ScreenTitle, WeatherScreen> storage = ImmutableMap.of(
            ScreenTitle.REPORT,
    )

    @Override
    public Optional<WeatherScreen> getByTitle(final ScreenTitle title)
    {
        logger.trace("getByTitle(): {}", title);
        return Optional.ofNullable(storage.get(title));
    }
}
