package hu.kata.soccer;

import java.nio.file.Paths;
import java.util.Optional;

public class Main {
    public static void main(String[] args){
        Soccers soccers = new Soccers();
        soccers.readFromFile(Paths.get("football.dat"));
        Optional<Soccer> smallestOpt = soccers.getSmallestDifference();
        if(smallestOpt.isPresent()){
            Soccer smallest = smallestOpt.get();
            System.out.println(smallest.getTeam() + " " + smallest.getDifference());
        } else{
            System.out.println("Not found data");
        }
    }
}
