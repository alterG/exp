package nfwya.alterg.services.weather.api;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Temperature statistic.
 */
public final class Statistic
{
    private final Integer average;

    private final Integer max;

    private final Integer min;

    private final Integer workDays;


    @JsonCreator
    private Statistic(@JsonProperty("average") final Integer average,
                      @JsonProperty("max") final Integer max,
                      @JsonProperty("min") final Integer min,
                      @JsonProperty("workDays") final Integer workDays)
    {
        this.average = Objects.requireNonNull(average);
        this.max = Objects.requireNonNull(max);
        this.min = Objects.requireNonNull(min);
        this.workDays = Objects.requireNonNull(workDays);
    }


    public static Builder builder()
    {
        return new Builder();
    }


    @JsonProperty("average")
    public Integer getAverage()
    {
        return average;
    }


    @JsonProperty("max")
    public Integer getMax()
    {
        return max;
    }


    @JsonProperty("min")
    public Integer getMin()
    {
        return min;
    }


    @JsonProperty("workDays")
    public Integer getWorkDays()
    {
        return workDays;
    }


    @Override
    public String toString()
    {
        return "Statistic{" +
                "average=" + average +
                ", max=" + max +
                ", min=" + min +
                ", workDays=" + workDays +
                '}';
    }


    public static final class Builder
    {
        private Integer average;

        private Integer max;

        private Integer min;

        private Integer workDays;


        public Builder withAverage(final Integer average)
        {
            this.average = average;
            return this;
        }


        public Builder withMax(final Integer max)
        {
            this.max = max;
            return this;
        }


        public Builder withMin(final Integer min)
        {
            this.min = min;
            return this;
        }


        public Builder withWorkDays(final Integer workDays)
        {
            this.workDays = workDays;
            return this;
        }


        public Statistic build()
        {
            return new Statistic(average, max, min, workDays);
        }
    }
}
