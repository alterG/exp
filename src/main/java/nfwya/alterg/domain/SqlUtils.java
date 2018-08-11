package nfwya.alterg.domain;


import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;


/**
 * Sql exception mapping.
 */
public class SqlUtils
{
    public static <T> Optional<T> getOptional(final Supplier<T> supplier)
    {
        if (supplier == null) return Optional.empty();

        try
        {
            return Optional.of(supplier.get());
        }
        catch (EmptyResultDataAccessException e)
        {
            return Optional.empty();
        }

    }


    public static <T> T getOrNull(final Supplier<T> supplier)
    {
        if (supplier == null)  return null;

        try
        {
            return supplier.get();
        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }
}
