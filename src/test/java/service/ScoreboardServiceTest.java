package service;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;
import org.example.service.ScoreboardServiceFootball;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardServiceTest {

    ScoreboardServiceFootball scoreboardServiceFootball = new ScoreboardServiceFootball();

    @Test
    public void testStartGame() {

        Scoreboard scoreboard = new Scoreboard();
        Match match = new FootballMatch("Mexico", 0,
                "Canada", 0, 123L);

        scoreboardServiceFootball.startGame("Mexico", "Canada", scoreboard);
        // timestamp might differ, therefore set same timestamp
        scoreboard.getMatches().get(0).setMatchStartTime(123L);

        assertEquals(match, scoreboard.getMatches().get(0));
    }

    @Test
    public void testStartGameDuplicate() {
    }

    @Test
    public void testStartGameNullOrEmpty() {
    }

    @Test
    public void testStartGameBlankTeamName() {
    }

    @Test
    public void testUpdateScore() {

        Match match1 = new FootballMatch("Mexico", 0,
                "Canada", 5, 123L);
        Match match2 = new FootballMatch("Spain", 10,
                "Brazil", 2, 234L);
        Match match3 = new FootballMatch("Germany", 2,
                "France", 2, 345);

        Scoreboard scoreboard = new Scoreboard();
        List<Match> matches = new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        scoreboard.setMatches(matches);

        scoreboardServiceFootball.updateScore(11, 11, match2, scoreboard);

        Match match4 = new FootballMatch("Spain", 11,
                "Brazil", 11, 234L);
        assertEquals(match4, scoreboard.getMatches().get(1));
    }

    @Test
    public void testFinishGame() {

        Match match1 = new FootballMatch("Mexico", 0,
                "Canada", 5, 123L);
        Match match2 = new FootballMatch("Spain", 10,
                "Brazil", 2, 234L);
        Match match3 = new FootballMatch("Germany", 2,
                "France", 2, 345);

        Scoreboard scoreboard = new Scoreboard();
        List<Match> matches = new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        scoreboard.setMatches(matches);

        scoreboardServiceFootball.finishGame(match3, scoreboard);

        assertEquals(2, scoreboard.getMatches().size());
    }

    @Test
    public void testGetGamesSummary() {

        Match match1 = new FootballMatch("Mexico", 0,
                "Canada", 5, 888L);
        Match match2 = new FootballMatch("Spain", 10,
                "Brazil", 2, 888L);
        Match match3 = new FootballMatch("Germany", 2,
                "France", 2, 554L);
        Match match4 = new FootballMatch("Uruguay", 6,
                "Italy", 6, 999L);
        Match match5 = new FootballMatch("Argentina", 3,
                "Australia", 1, 555L);
        Match match6 = new FootballMatch("Kazakhstan", 11,
                "Galaxy", 11, 111L);

        Scoreboard scoreboard = new Scoreboard();
        List<Match> matches = new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
        matches.add(match4);
        matches.add(match5);
        matches.add(match6);
        scoreboard.setMatches(matches);

        // Sorted matches scoreboard
        Scoreboard scoreboard2 = new Scoreboard();
        List<Match> matches2 = new ArrayList<>();
        matches2.add(match6);
        matches2.add(match4);
        matches2.add(match2);
        matches2.add(match1);
        matches2.add(match5);
        matches2.add(match3);
        scoreboard2.setMatches(matches2);

        scoreboardServiceFootball.getGamesSummary(scoreboard);

        assertEquals(scoreboard2.getMatches(), scoreboard.getMatches());
    }

}
