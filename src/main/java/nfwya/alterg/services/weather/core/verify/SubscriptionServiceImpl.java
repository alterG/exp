package nfwya.alterg.services.weather.core.verify;


import javax.xml.ws.ServiceMode;

import nfwya.alterg.domain.User;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionServiceImpl implements SubscriptionService
{
    @Override
    public boolean isSubscriptionPaid(final User customer)
    {
        return true;        // mocked for now
    }
}
