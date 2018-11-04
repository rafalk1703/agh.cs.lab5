package agh.cs.lab5;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String [] directions){
        List <MoveDirection> resDirections = new LinkedList<>();

        for(String x: directions)
            if (x.equals("f") || x.equals("forward")) {
                resDirections.add(MoveDirection.FORWARD);

            } else if (x.equals("b") || x.equals("backward")) {
                resDirections.add(MoveDirection.BACKWARD);

            } else if (x.equals("l") || x.equals("left")) {
                resDirections.add(MoveDirection.LEFT);

            } else if (x.equals("r") || x.equals("right")) {
                resDirections.add(MoveDirection.RIGHT);

            }
        MoveDirection[] finalCountdown = resDirections.toArray(new MoveDirection[resDirections.size()]);

        return finalCountdown;
    }
}