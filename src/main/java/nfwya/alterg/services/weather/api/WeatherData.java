package nfwya.alterg.services.weather.api;


import java.util.Objects;


/**
 * Daily whether representation.
 */
public class WeatherData
{
    private final Integer temperature;

    private final Integer humidity;

    private final Integer pressure;


    private WeatherData(final int temperature, final int humidity, final int pressure)
    {
        this.temperature = Objects.requireNonNull(temperature);
        this.humidity = Objects.requireNonNull(humidity);
        this.pressure = Objects.requireNonNull(pressure);
    }


    public static Builder builder()
    {
        return new Builder();
    }


    public int getTemperature()
    {
        return temperature;
    }


    public int getHumidity()
    {
        return humidity;
    }


    public int getPressure()
    {
        return pressure;
    }


    @Override
    public String toString()
    {
        return "WeatherData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }


    public static final class Builder
    {
        private int temperature;

        private int humidity;

        private int pressure;


        public Builder withTemperature(final int temperature)
        {
            this.temperature = temperature;
            return this;
        }


        public Builder withHumidity(final int humidity)
        {
            this.humidity = humidity;
            return this;
        }


        public Builder withPressure(final int pressure)
        {
            this.pressure = pressure;
            return this;
        }


        public WeatherData build()
        {
            return new WeatherData(temperature, humidity, pressure);
        }
    }
}
