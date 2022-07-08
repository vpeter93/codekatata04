package hu.kata.soccer;

import hu.kata.core.Differentiable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Soccer implements Differentiable<Integer>
{
    private String team;
    private int forGoals;
    private int againstGoals;

    public static Soccer fromString(String line){
        String[] data = line.split(" ");
        return new Soccer(data[2], Integer.parseInt(data[7]), Integer.parseInt(data[8]));
    }

    public int getDifferenceForAndAgainstGoals(){
        return Math.abs(forGoals - againstGoals);
    }

    @Override
    public Integer getDifference()
    {
        return getDifferenceForAndAgainstGoals();
    }
}
