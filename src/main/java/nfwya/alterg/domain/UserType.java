package nfwya.alterg.domain;


import java.util.Map;

import nfwya.alterg.services.weather.api.UnifiedEnum;


public enum UserType implements UnifiedEnum
{
    CUSTOMER("CUSTOMER"),
    STAFF("STAFF"),
    BUSINESS("BUSINESS");

    private final String code;


    UserType(final String code)
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
        return EnumUtils.getEnumMap(UserType.class);
    }

}
