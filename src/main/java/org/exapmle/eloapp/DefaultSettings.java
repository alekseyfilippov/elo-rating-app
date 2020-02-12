package org.exapmle.eloapp;

public class DefaultSettings {
    private int proRatingBoundry;
    private int starterBoundary;
    private int defaultRating;
    private int defaultKFactor;


    public DefaultSettings() {
        proRatingBoundry = 2400;
        starterBoundary = 30;
        defaultRating = 2000;
        defaultKFactor = 10;
    }

    public int getProRatingBoundry() {
        return proRatingBoundry;
    }

    public int getstarterBoundary() {
        return starterBoundary;
    }

    public int getDefaultRating() {
        return defaultRating;
    }

    public int getDefaultKFactor() {
        return defaultKFactor;
    }

    public void setstarterBoundary(int starterBoundary) {
        this.starterBoundary = starterBoundary;
    }
}
