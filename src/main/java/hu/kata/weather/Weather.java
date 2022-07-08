package hu.kata.weather;

import hu.kata.core.Differentiable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Weather implements Differentiable<Float> {
    private String day;
    private float maximumTemperature;
    private float minimumTemperature;

    public static Weather fromString(String line){
        String[] data = line.split(" ");
        return new Weather(data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]));
    }

    @Override
    public Float getDifference() {
        return Math.abs(maximumTemperature - minimumTemperature);
    }
}
