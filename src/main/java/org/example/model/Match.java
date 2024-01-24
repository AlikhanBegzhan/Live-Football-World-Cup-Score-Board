package org.example.model;

import java.util.Objects;

public class Match {

    String teamHomeName;
    String teamAwayName;

    // Not sure about fractional scores,
    // therefore considering only whole numbers
    Integer teamHomeScore;
    Integer teamAwayScore;

    Integer sumScore;

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

    public Integer getTeamHomeScore() {
        return teamHomeScore;
    }

    public void setTeamHomeScore(Integer teamHomeScore) {
        this.teamHomeScore = teamHomeScore;
    }

    public Integer getTeamAwayScore() {
        return teamAwayScore;
    }

    public void setTeamAwayScore(Integer teamAwayScore) {
        this.teamAwayScore = teamAwayScore;
    }

    public Integer getSumScore() {
        return teamHomeScore + teamAwayScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }

    public long getMatchStartTime() {
        return matchStartTime;
    }

    public void setMatchStartTime(long matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return matchStartTime == match.matchStartTime && Objects.equals(teamHomeName, match.teamHomeName) && Objects.equals(teamAwayName, match.teamAwayName) && Objects.equals(teamHomeScore, match.teamHomeScore) && Objects.equals(teamAwayScore, match.teamAwayScore) && Objects.equals(sumScore, match.sumScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamHomeName, teamAwayName, teamHomeScore, teamAwayScore, sumScore, matchStartTime);
    }
}
