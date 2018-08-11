package nfwya.alterg.services.weather.api;


import java.util.Map;

import nfwya.alterg.domain.EnumUtils;


public enum ScreenTitle implements UnifiedEnum
{
    STATISTIC("STATISTIC"),
    REPORT("REPORT"),
    FORECAST("FORECAST");

    private static final Map<String, ScreenTitle> ENUM_MAP = EnumUtils.getEnumMap(ScreenTitle.class);

    private final String code;


    ScreenTitle(final String code)
    {
        this.code = code;
    }


    @Override
    public Map getEnumMap()
    {
        return ENUM_MAP;
    }


    @Override
    public String getCode()
    {
        return code;
    }
}
