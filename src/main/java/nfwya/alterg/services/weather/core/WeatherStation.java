package nfwya.alterg.services.weather.core;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import nfwya.alterg.domain.User;
import nfwya.alterg.domain.UserType;
import nfwya.alterg.services.weather.api.Observable;
import nfwya.alterg.services.weather.api.Observer;
import nfwya.alterg.services.weather.api.WeatherData;
import nfwya.alterg.services.weather.core.verify.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// todo: create weather data supplying thread
public class WeatherStation implements Observable<WeatherData>
{
    private static final Logger logger = LoggerFactory.getLogger(WeatherStation.class);

    private final Map<Long, Observer<WeatherData>> observers = new HashMap<>();

    private final SubscriptionService subscriptionService;


    public WeatherStation(final SubscriptionService subscriptionService)
    {
        this.subscriptionService = subscriptionService;
    }


    @Override
    public void update(final WeatherData data)
    {
        logger.info("weather station send the new data: {}", data);
        observers.forEach((observerId, observer) ->
        {
            final User user = User.createCustomer(observerId);
            final boolean isSubscriptionPaid = subscriptionService.isSubscriptionPaid(user);
            if (!isSubscriptionPaid)
            {
                logger.debug("Observer has not paid subscription: {}", user);
            }
            else
            {
                observer.send(data);
                logger.debug("weather data is sent successfully: {}", user);
            }
        });
    }


    @Override
    public boolean subscribe(final User staff, final Observer<WeatherData> observer)
    {
        if (UserType.STAFF != staff.getUserType())
        {
            logger.debug("Subscription is rejected, userType is wrong: {}", staff);
            return false;
        }

        observers.put(staff.getId(), observer);
        logger.info("observer is subscribed: {}", staff);
        return true;
    }


    @Override
    public boolean leave(final User staff, final Observer<WeatherData> observer)
    {
        if (UserType.STAFF != staff.getUserType())
        {
            logger.debug("Subscription leaving is rejected, userType is wrong: {}", staff);
            return false;
        }

        observers.remove(staff.getId());
        logger.info("observer decline subscription: {}", staff);
        return true;
    }
}
