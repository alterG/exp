package nfwya.alterg.services.weather.api;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Weather everyday report.
 */
public final class Report
{
    private final Integer temperature;

    private final Integer humidity;

    private final Integer pressure;

    private final Boolean isPressureUp;


    @JsonCreator
    private Report(@JsonProperty("temperature") final Integer temperature,
                   @JsonProperty("humidity") final Integer humidity,
                   @JsonProperty("pressure") final Integer pressure,
                   @JsonProperty("isPressureUp") final Boolean isPressureUp)
    {
        this.temperature = Objects.requireNonNull(temperature);
        this.humidity = Objects.requireNonNull(humidity);
        this.pressure = Objects.requireNonNull(pressure);
        this.isPressureUp = Objects.requireNonNull(isPressureUp);
    }


    public static Builder builder()
    {
        return new Builder();
    }


    @JsonProperty("temperature")
    public Integer getTemperature()
    {
        return temperature;
    }


    @JsonProperty("humidity")
    public Integer getHumidity()
    {
        return humidity;
    }


    @JsonProperty("pressure")
    public Integer getPressure()
    {
        return pressure;
    }


    @JsonProperty("isPressureUp")
    public Boolean getIsPressureUp()
    {
        return isPressureUp;
    }


    @Override
    public String toString()
    {
        return "Report{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", isPressureUp=" + isPressureUp +
                '}';
    }


    public static final class Builder
    {
        private Integer temperature;

        private Integer humidity;

        private Integer pressure;

        private Boolean isPressureUp;


        public Builder withTemperature(final Integer temperature)
        {
            this.temperature = temperature;
            return this;
        }


        public Builder withHumidity(final Integer humidity)
        {
            this.humidity = humidity;
            return this;
        }


        public Builder withPressure(final Integer pressure)
        {
            this.pressure = pressure;
            return this;
        }


        public Builder withIsPressureUp(final Boolean isPressureUp)
        {
            this.isPressureUp = isPressureUp;
            return this;
        }


        public Report build()
        {
            return new Report(temperature, humidity, pressure, isPressureUp);
        }
    }
}
