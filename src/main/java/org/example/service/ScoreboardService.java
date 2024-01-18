package org.example.service;

import org.example.model.Match;
import org.example.model.Scoreboard;

import java.util.List;

public interface ScoreboardService {

    void startGame(String teamHomeName, String teamAwayName, Scoreboard scoreboard);

    void updateScore(Integer teamHomeScore, Integer teamAwayScore, Match match, Scoreboard scoreboard);

    void finishGame(Match match, Scoreboard scoreboard);

    List<Match> getGamesSummary(Scoreboard scoreboard);
}
