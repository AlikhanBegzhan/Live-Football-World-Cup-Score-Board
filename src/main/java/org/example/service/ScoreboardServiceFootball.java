package org.example.service;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;

import java.util.List;

public class ScoreboardServiceFootball implements ScoreboardService {

    // Unix timestamp
    private long unixTime;

    @Override
    public void startGame(String teamHomeName, String teamAwayName, Scoreboard scoreboard) {
        unixTime = System.currentTimeMillis() / 1000L;

        // Check for duplicate matches
        if (findMatchByTeamNames(teamHomeName, teamAwayName, scoreboard) != null) {
            System.out.println("Duplicate match with Home Team name " + teamHomeName
                    + " and Away Team name " + teamAwayName);
        } else {
            Match footballGame = new FootballMatch(teamHomeName, 0, teamAwayName, 0, unixTime);
            scoreboard.getMatches().add(footballGame);
        }
    }

    @Override
    public void updateScore(int teamHomeScore, int teamAwayScore, Match match, Scoreboard scoreboard) {

        if (findMatchByTeamNames(match.getTeamHomeName(), match.getTeamAwayName(), scoreboard) != null) {
            updateMatchScore(teamHomeScore, teamAwayScore, match, scoreboard);
        } else {
            System.out.println("Match with Home Team name " + match.getTeamHomeName()
                    + " and Away Team name " + match.getTeamAwayName() + " was not found");
        }
    }

    @Override
    public void finishGame(Match match, Scoreboard scoreboard) {
        removeMatch(match, scoreboard);
    }

    @Override
    public List<Match> getGamesSummary(Scoreboard scoreboard) {
        return null;
    }

    public Match findMatch(Match match, Scoreboard scoreboard) {
        for (Match matchSc : scoreboard.getMatches()) {
            if (matchSc.equals(match)) {
                return match;
            }
        }
        return null;
    }

    public Match findMatchByTeamNames(String teamHomeName, String teamAwayName, Scoreboard scoreboard) {
        for (Match match : scoreboard.getMatches()) {
            if (match.getTeamHomeName().equals(teamHomeName) && teamAwayName.equals(teamAwayName)) {
                return match;
            }
        }
        return null;
    }

    public void updateMatchScore(int teamHomeScore, int teamAwayScore, Match match, Scoreboard scoreboard) {
        for (Match matchSc : scoreboard.getMatches()) {
            if (matchSc.equals(match)) {
                match.setTeamHomeScore(teamHomeScore);
                match.setTeamAwayScore(teamAwayScore);
                matchSc = match;
                break;
            }
        }
    }

    public void removeMatch(Match match, Scoreboard scoreboard) {
        for (Match matchSc : scoreboard.getMatches()) {
            if (matchSc.equals(match)) {
                scoreboard.getMatches().remove(matchSc);
                break;
            }
        }
    }

}
