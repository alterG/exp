package nfwya.alterg.domain;


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import com.google.common.collect.Ordering;
import nfwya.alterg.services.weather.api.UnifiedEnum;

import static java.util.stream.Collectors.toMap;


/**
 * Util class for enum.
 */
public class EnumUtils
{
    /**
     * Get map which provides convert string code to enum.
     */
    public static <E extends UnifiedEnum> Map<String, E> getEnumMap(final Class<E> clazz)
    {
        final BinaryOperator<E> mergeOperator = (value1, value2) ->
        {
            throw new IllegalStateException(String.format("Duplicate keys for values: %s, %s", value1, value2));
        };
        return Arrays.stream(clazz.getEnumConstants())
                .collect(toMap(
                        elem -> elem.getCode().toUpperCase(),
                        Function.identity(),
                        mergeOperator,
                        () -> new TreeMap<>(Ordering.usingToString().reverse())));
    }
}