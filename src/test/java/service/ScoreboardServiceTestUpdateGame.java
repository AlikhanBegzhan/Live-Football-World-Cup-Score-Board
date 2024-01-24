package service;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;
import org.example.service.ScoreboardServiceFootball;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardServiceTestUpdateGame {

    ScoreboardServiceFootball scoreboardServiceFootball = new ScoreboardServiceFootball();
    static Scoreboard scoreboard;
    static List<Match> matches;
    static Match match1;
    static Match match2;
    static Match match3;


    @BeforeAll
    static void init() {
        scoreboard = new Scoreboard();

        match1 = new FootballMatch("Mexico", 0,
                "Canada", 5, 123L);
        match2 = new FootballMatch("Spain", 10,
                "Brazil", 2, 234L);
        match3 = new FootballMatch("Germany", 2,
                "France", 2, 345);

        matches = new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        scoreboard.setMatches(matches);
    }

    @Test
    void testUpdateScore() {

        scoreboardServiceFootball.updateScore(11, 11, match2, scoreboard);

        Match match4 = new FootballMatch("Spain", 11,
                "Brazil", 11, 234L);
        assertEquals(match4, scoreboard.getMatches().get(1));
    }

    @Test
    void testUpdateNullMatch() {

        // Null match
        scoreboardServiceFootball.updateScore(22, 22, null, scoreboard);

        Match match4 = new FootballMatch("Spain", 11,
                "Brazil", 11, 234L);
        matches.set(1, match4);
        assertEquals(matches, scoreboard.getMatches());
    }

    @Test
    void testUpdateNullScoreboard() {

        // Null scoreboard
        scoreboardServiceFootball.updateScore(33, 33, match2, null);

        assertEquals(matches, scoreboard.getMatches());
    }

    @Test
    void testUpdateNullHomeScore() {

        // Null home score
        scoreboardServiceFootball.updateScore(null, 33, match2, scoreboard);

        assertEquals(matches, scoreboard.getMatches());
    }
}
