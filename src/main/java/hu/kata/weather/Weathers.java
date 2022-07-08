package hu.kata.weather;

import hu.kata.core.Differentiables;

import java.util.Comparator;
import java.util.Optional;

public class Weathers extends Differentiables<Weather>
{
    @Override
    public Weather fromString(String line)
    {
        return Weather.fromString(line);
    }

    @Override
    protected String formatInputString(String input){
        return input.replaceAll("\\s+", " ").replaceAll("[*]","");
    }

    @Override
    public Optional<Weather> getSmallestDifference()
    {
        return records.stream().min(Comparator.comparing(Weather::getTemperatureSpread));
    }
}
