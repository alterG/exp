package nfwya.alterg.services.weather.core.staff;


import nfwya.alterg.domain.User;
import nfwya.alterg.services.weather.api.Observer;
import nfwya.alterg.services.weather.api.Report;
import nfwya.alterg.services.weather.api.Statistic;
import nfwya.alterg.services.weather.api.WeatherData;
import nfwya.alterg.services.weather.api.WeatherForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;


@Component
public class WeatherTracker implements Observer<WeatherData>
{
    private static final Logger logger = LoggerFactory.getLogger(WeatherTracker.class);

    private final User staff = User.createStaff(94L);

    private Report report;

    private Statistic statistic;

    private WeatherForecast forecast;

    private Double temperatureSumm;

    @Override
    public void send(final WeatherData data)
    {
        logger.info("weather tracker received the data: {}", data);
        handle(data);
    }


    public WeatherTracker()
    {
        this.report = Report.builder()
                .withHumidity(50)
                .withIsPressureUp(false)
                .withPressure(750)
                .withTemperature(60)
                .build();

        this.statistic = Statistic.builder()
                .withMin(0)
                .withMax(0)
                .withAverage(0)
                .withWorkDays(0)
                .build();

        this.forecast = WeatherForecast.SUNNY;

        this.temperatureSumm = 0.0;
    }


    /**
     * handle incoming messages.
     */
    private void handle(final WeatherData data)
    {
        final boolean isTemperatureDecrease = report.getTemperature() - data.getTemperature() >= 5;
        final boolean isHumidityHigh = data.getHumidity() > 70;

        final Report report = Report.builder()
                .withTemperature(data.getTemperature())
                .withIsPressureUp(this.report.getIsPressureUp() && data.getPressure() > report.getPressure())
                .withPressure(data.getPressure())
                .withHumidity(data.getHumidity())
                .build();

        final Statistic statistic = Statistic.builder()
                .withMin(Math.min(this.statistic.getMin(), data.getTemperature()))
                .withMax(Math.max(this.statistic.getMax(), data.getTemperature()))
                .withWorkDays(this.statistic.getWorkDays() + 1)
                .withAverage(Math.round(((temperatureSumm + data.getTemperature()) * 1.0f) / statistic.getWorkDays()))
                .build();


        if (isTemperatureDecrease && isHumidityHigh)
        {
            forecast = WeatherForecast.RAIN;
        }
        else if (isTemperatureDecrease && this.report.getIsPressureUp())
        {
            forecast = WeatherForecast.STRING_WING;
        }
        else
        {
            forecast = WeatherForecast.SUNNY;
        }
    }


    public void printReport()
    {
        logger.info("Current weather:\ntemp: {}C\n humidity: {}%\n pressure: {}\n------------------------------\n",
                report.getTemperature(), report.getHumidity(), report.getIsPressureUp());

    }
  

    public void printStatistic()
    {
        logger.info("Temperature statistic:\n average: {}\n max: {}\n min {}\n---------------------------\n",
                statistic.getAverage(), statistic.getMax(), statistic.getMin());
    }


    public void printForecast()
    {
        logger.info("Forecast: {}", forecast);
    }
}
