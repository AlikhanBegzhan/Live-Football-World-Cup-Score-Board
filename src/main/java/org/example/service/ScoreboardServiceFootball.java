package org.example.service;

import org.example.model.FootballMatch;
import org.example.model.Match;
import org.example.model.Scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreboardServiceFootball implements ScoreboardService {

    @Override
    public void startGame(String teamHomeName, String teamAwayName, Scoreboard scoreboard) {
        long unixTime = System.currentTimeMillis() / 1000L;

        if (scoreboard == null) {
            System.out.println("Scoreboard is not found");
            return;
        }

        if ((teamHomeName != null && !teamHomeName.isBlank())
                || (teamHomeName != null && !teamAwayName.isBlank())) {
            // Check for duplicate matches
            if (findMatchByTeamNames(teamHomeName, teamAwayName, scoreboard) != null) {
                System.out.println("Duplicate match with Home Team name " + teamHomeName
                        + " and Away Team name " + teamAwayName);
            } else {
                Match footballGame = new FootballMatch(teamHomeName, 0, teamAwayName, 0, unixTime);
                scoreboard.getMatches().add(footballGame);
            }
        } else {
            System.out.println("Home Team name or Away Team name cannot be empty");
        }

    }

    @Override
    public void updateScore(Integer teamHomeScore, Integer teamAwayScore, Match match, Scoreboard scoreboard) {

        if (match == null || scoreboard == null) {
            System.out.println("Match or Scoreboard is not found");
            return;
        }

        if (teamHomeScore != null && teamAwayScore != null) {
            if (findMatchByTeamNames(match.getTeamHomeName(), match.getTeamAwayName(), scoreboard) != null) {
                updateMatchScore(teamHomeScore, teamAwayScore, match, scoreboard);
            } else {
                System.out.println("Match with Home Team name " + match.getTeamHomeName()
                        + " and Away Team name " + match.getTeamAwayName() + " is not found");
            }
        } else {
            System.out.println("Home Team score or Away Team score cannot be null");
        }

    }

    @Override
    public void finishGame(Match match, Scoreboard scoreboard) {

        if (match == null || scoreboard == null) {
            System.out.println("Match or Scoreboard is not found");
            return;
        }

        removeMatch(match, scoreboard);
    }

    @Override
    public List<Match> getGamesSummary(Scoreboard scoreboard) {
        if (scoreboard != null) {
            // Comparator for sorting by Sum Score and then by Match Start Time
            Comparator<Match> byScoreSumAndTime =
                    Comparator.comparing(Match::getSumScore).thenComparing(Match::getMatchStartTime);
            scoreboard.getMatches().sort(byScoreSumAndTime.reversed());

            return scoreboard.getMatches();
        } else {
            System.out.println("Scoreboard is not found");
            return new ArrayList<>();
        }
    }

    public Match findMatchByTeamNames(String teamHomeName, String teamAwayName, Scoreboard scoreboard) {
        for (Match match : scoreboard.getMatches()) {
            if (match.getTeamHomeName().equals(teamHomeName) && match.getTeamAwayName().equals(teamAwayName)) {
                return match;
            }
        }
        return null;
    }

    public void updateMatchScore(Integer teamHomeScore, Integer teamAwayScore, Match match, Scoreboard scoreboard) {
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
                return;
            }
        }
        System.out.println("Match is not found on the scoreboard");
    }

}
