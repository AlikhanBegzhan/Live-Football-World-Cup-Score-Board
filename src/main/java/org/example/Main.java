package org.example;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;
import org.example.service.ScoreboardService;
import org.example.service.ScoreboardServiceFootball;

public class Main {
    public static void main(String[] args) {

//        Match match1 = new FootballMatch("1", 1, "2", 2, 123L);
//        Match match2 = new FootballMatch("3", 3, "4", 4, 456L);
//        Match match3 = new FootballMatch("1", 1, "2", 2, 123L);
//        Match match4 = new FootballMatch("1", 1, "2", 2, 456L);
//        Match match5 = new FootballMatch("2", 1, "2", 2, 123L);
//
//        System.out.println(match1.equals(match2));
//        System.out.println(match1.equals(match3));
//        System.out.println(match1.equals(match4));
//        System.out.println(match1.equals(match5));


        ScoreboardService scoreboardServiceFootball = new ScoreboardServiceFootball();

        Scoreboard scoreboard = new Scoreboard();

        scoreboardServiceFootball.startGame("Mexico", "Canada", scoreboard);

        System.out.println(scoreboard.getMatches());
    }
}