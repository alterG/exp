package nfwya.alterg.services.weather.core.verify;


import nfwya.alterg.domain.User;


/**
 * Administrate customer subscriptions.
 */
public interface SubscriptionService
{
    /**
     * Check customer is subscription paid or not.
     */
    boolean isSubscriptionPaid(final User customer);
}
