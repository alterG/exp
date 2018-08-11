package nfwya.alterg.services.weather.api;


import nfwya.alterg.domain.User;


/**
 * Observable object.
 */
public interface Observable<T>
{
    void update(final T data);


    boolean subscribe(final User staff, final Observer<T> observer);


    boolean leave(final User staff, final Observer<T> observer);
}
