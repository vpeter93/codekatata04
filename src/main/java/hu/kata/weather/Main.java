package hu.kata.weather;

import java.nio.file.Paths;
import java.util.Optional;

public class Main {
    public static void main(String[] args){
        Weathers weathers = new Weathers();
        weathers.readFromFile(Paths.get("weather.dat"));
        Optional<Weather> smallestOpt = weathers.getSmallestDifference();
        if(smallestOpt.isPresent()){
            System.out.println(smallestOpt.get().getDay() + " " + smallestOpt.get().getTemperatureSpread());
        } else{
            System.out.println("Not found data");
        }
    }
}
