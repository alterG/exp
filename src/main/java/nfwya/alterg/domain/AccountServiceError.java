package nfwya.alterg.domain;


import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import static java.util.stream.Collectors.*;


public enum AccountServiceError implements ApplicationError
{
    TECHNICAL_ERROR("TECHNICAL_ERROR");

    private String code;


    AccountServiceError(final String code)
    {
        this.code = code;
    }


    @Override
    @JsonValue
    public String getCode()
    {
        return code;
    }


    private static final Map<String, AccountServiceError> ENUM_MAP = Arrays.stream(AccountServiceError.values())
            .collect(toMap(error -> error.getCode().toUpperCase(), Function.identity()));


    @JsonCreator
    public AccountServiceError getByCode(final String code)
    {
        return Optional.ofNullable(ENUM_MAP.get(code.toUpperCase())).orElseThrow(
                () -> new IllegalArgumentException("Failed to get by code: code=" + code));
    }
}
