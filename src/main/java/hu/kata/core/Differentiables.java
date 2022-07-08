package hu.kata.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Differentiables<T extends Differentiable> {
    protected List<T> records;

    protected Differentiables(){
        records = new ArrayList<>();
    }

    public void readFromFile(Path path){
        try {
            List<String> lines = Files.readAllLines(path);
            for(int i = 2; i < lines.size(); i++){
                String line = formatInputString(lines.get(i));
                try {
                    T record = fromString(line);
                    records.add(record);
                }catch (Exception e){
                    System.out.println("line " + i + " is not a record");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract T fromString(String line);

    protected abstract String formatInputString(String input);

    public abstract Optional<T> getSmallestDifference();
}
