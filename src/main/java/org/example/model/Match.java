package org.example.model;

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
    public String toString() {
        return "Match{" +
                "teamHomeName='" + teamHomeName + '\'' +
                ", teamAwayName='" + teamAwayName + '\'' +
                ", teamHomeScore=" + teamHomeScore +
                ", teamAwayScore=" + teamAwayScore +
                ", sumScore=" + sumScore +
                ", matchStartTime=" + matchStartTime +
                '}';
    }
}
