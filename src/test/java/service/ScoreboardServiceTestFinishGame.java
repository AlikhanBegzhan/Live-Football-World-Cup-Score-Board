package service;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;
import org.example.service.ScoreboardServiceFootball;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScoreboardServiceTestFinishGame {

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
    @Order(1)
    void testFinishGame() {

        scoreboardServiceFootball.finishGame(match3, scoreboard);

        assertEquals(2, scoreboard.getMatches().size());
    }

    @Test
    @Order(2)
    void testFinishGameNullMatch() {

        scoreboardServiceFootball.finishGame(null, scoreboard);

        assertEquals(2, scoreboard.getMatches().size());
    }

    @Test
    @Order(3)
    void testFinishGameNullScoreboard() {

        scoreboardServiceFootball.finishGame(match1, null);

        assertEquals(2, scoreboard.getMatches().size());
    }

    @Order(4)
    @Test
    void testFinishGameNotOnScoreboard() {

        scoreboardServiceFootball.finishGame(match3, scoreboard);

        assertEquals(2, scoreboard.getMatches().size());
    }
}
