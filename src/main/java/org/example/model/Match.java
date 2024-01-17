package org.example.model;

import java.util.Objects;

public class Match {

    String teamHomeName;
    String teamAwayName;

    // Not sure about fractional scores,
    // therefore considering only whole numbers
    int teamHomeScore;
    int teamAwayScore;

    // Timestamp value
    long matchStartTime;

    public String getTeamHomeName() {
        return teamHomeName;
    }

    public void setTeamHomeName(String teamHomeName) {
        this.teamHomeName = teamHomeName;
    }

    public String getTeamAwayName() {
        return teamAwayName;
    }

    public void setTeamAwayName(String teamAwayName) {
        this.teamAwayName = teamAwayName;
    }

    public int getTeamHomeScore() {
        return teamHomeScore;
    }

    public void setTeamHomeScore(int teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }

    public int getTeamAwayScore() {
        return teamAwayScore;
    }

    public void setTeamAwayScore(int teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return teamHomeScore == match.teamHomeScore && teamAwayScore == match.teamAwayScore && matchStartTime == match.matchStartTime && Objects.equals(teamHomeName, match.teamHomeName) && Objects.equals(teamAwayName, match.teamAwayName);
    }
}
