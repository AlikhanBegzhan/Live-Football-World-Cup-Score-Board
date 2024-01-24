package service;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;
import org.example.service.ScoreboardServiceFootball;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreboardServiceTestStartGame {

    ScoreboardServiceFootball scoreboardServiceFootball = new ScoreboardServiceFootball();
    static Scoreboard scoreboard;

    @BeforeAll
    static void init() {
        scoreboard = new Scoreboard();
    }

    @Test
    void testStartGame() {

        Match match = new FootballMatch("Mexico", 0,
                "Canada", 0, 123L);

        scoreboardServiceFootball.startGame("Mexico", "Canada", scoreboard);
        // timestamp might differ, therefore set same timestamp
        scoreboard.getMatches().get(0).setMatchStartTime(123L);

        assertEquals(match, scoreboard.getMatches().get(0));
    }

    @Test
    void testStartGameDuplicate() {

        // Trying to add same match again
        scoreboardServiceFootball.startGame("Mexico", "Canada", scoreboard);

        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    void testStartGameBlankTeamName() {

        // Trying to add match with blank team names
        scoreboardServiceFootball.startGame("", "", scoreboard);

        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    void testStartGameNullTeamName() {

        // Trying to add match with null team names
        scoreboardServiceFootball.startGame(null, null, scoreboard);

        assertEquals(1, scoreboard.getMatches().size());
    }

    @Test
    void testStartGameNullScoreboard() {

        // Trying to start game on null scoreboard
        scoreboardServiceFootball.startGame("Mexico", "Canada", null);
    }

}
