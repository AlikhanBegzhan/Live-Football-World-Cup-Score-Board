package org.example.service;

import org.example.model.Match;
import org.example.model.Scoreboard;

import java.util.List;

public interface ScoreboardService {

    void startGame(String teamHomeName, String teamAwayName, Scoreboard scoreboard);

    void updateScore(int teamHomeScore, int teamAwayScore, Match match, Scoreboard scoreboard);

    void finishGame(Match match, Scoreboard scoreboard);

    // Games summary ordered by total score, then by most recently started
    List<Match> getGamesSummary(Scoreboard scoreboard);
}
