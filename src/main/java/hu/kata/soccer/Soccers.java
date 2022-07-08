package hu.kata.soccer;

import hu.kata.core.Differentiables;

import java.util.Comparator;
import java.util.Optional;

public class Soccers extends Differentiables<Soccer>
{

    @Override
    public Soccer fromString(String line)
    {
        return Soccer.fromString(line);
    }

    @Override
    protected String formatInputString(String input){
        return input.replaceAll("\\s+", " ").replaceAll("[*]","").replace(" - ", " ");
    }

    @Override
    public Optional<Soccer> getSmallestDifference()
    {
        return records.stream().min(Comparator.comparing(Soccer::getDifference));
    }
}
