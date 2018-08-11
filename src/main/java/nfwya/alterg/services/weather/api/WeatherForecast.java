package nfwya.alterg.services.weather.api;


import java.util.Map;

import nfwya.alterg.domain.EnumUtils;


public enum WeatherForecast implements UnifiedEnum
{
    SUNNY("SUNNY"),
    RAIN("RAIN"),
    STRING_WING("STRING_WING");

    private static final Map<String, WeatherForecast> ENUM_MAP = EnumUtils.getEnumMap(WeatherForecast.class);

    private final String code;


    WeatherForecast(final String code)
    {
        this.code = code;
    }


    @Override
    public String getCode()
    {
        return code;
    }


    @Override
    public Map getEnumMap()
    {
        return ENUM_MAP;
    }
}
