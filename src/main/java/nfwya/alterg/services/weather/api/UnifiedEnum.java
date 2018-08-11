package nfwya.alterg.services.weather.api;


import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import nfwya.alterg.domain.EnumUtils;

import static java.util.Objects.isNull;


/**
 * Interface for unify persist and serialization enums.
 * Note: interface and its realization are linked. It allows us to remove {@link this#getByCode(String)} from enum.
 *
 * @author Shchipanov I.
 */
public interface UnifiedEnum<Child>
{
    /**
     * Get enum by code.
     */
    @JsonCreator
    default Child getByCode(final String code)
    {
        if (isNull(code))
        {
            throw new IllegalArgumentException("Failed to deserialize: code is null");
        }
        return Optional.ofNullable(getEnumMap().get(code.toUpperCase())).orElseThrow(
                () -> new IllegalArgumentException(String.format("Failed to get by code: code=%s", code)));
    }

    /**
     * Get enum code.
     */
    @JsonValue
    String getCode();


    /**
     * Get child enum map to convert from code.
     */
    Map<String, Child> getEnumMap();
}
