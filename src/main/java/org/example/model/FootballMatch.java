package org.example.model;

public class FootballMatch extends Match {

    public FootballMatch(String teamHomeName, int teamHomeScore, String teamAwayName, int teamAwayScore, long matchStartTime) {
        super.teamHomeName = teamHomeName;
        super.teamHomeScore = teamHomeScore;
        super.teamAwayName = teamAwayName;
        super.teamAwayScore = teamAwayScore;
        super.matchStartTime = matchStartTime;
    }

    @Override
    public String toString() {
        return "FootballMatch{" +
                "teamHomeName='" + teamHomeName + '\'' +
                ", teamAwayName='" + teamAwayName + '\'' +
                ", teamHomeScore=" + teamHomeScore +
                ", teamAwayScore=" + teamAwayScore +
                ", sumScore=" + sumScore +
                ", matchStartTime=" + matchStartTime +
                '}';
    }
}
