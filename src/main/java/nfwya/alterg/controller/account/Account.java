package nfwya.alterg.controller.account;


import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import nfwya.alterg.domain.AccountServiceError;
import nfwya.alterg.domain.ApplicationError;
import nfwya.alterg.domain.Result;


public class Account
{
    @NotNull
    @Min(1)
    private final Long id;

    @Pattern(regexp = "[a-zA-Z]{3}")
    @NotBlank
    private final String currency;


    @Max(500)
    @Positive
    @NotNull
    private final BigDecimal amount;


    public Account(@JsonProperty("id") final Long id,
                   @JsonProperty("currency") final String currency,
                   @JsonProperty("amount") final BigDecimal amount)
    {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
    }


    public Long getId()
    {
        return id;
    }


    public String getCurrency()
    {
        return currency;
    }


    public BigDecimal getAmount()
    {
        return amount;
    }


    @Override
    public String toString()
    {
        return "Account{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
