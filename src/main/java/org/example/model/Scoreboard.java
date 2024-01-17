package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public Scoreboard(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

}
