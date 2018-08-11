package nfwya.alterg.services.weather.api;


/**
 *  Pattern observer.
 */
public interface Observer<T>
{
    /**
     * Receive the message from observable object.
     */
    void send(final T data);
}
