package com.solid.principles.openclosed;

import java.util.List;

public class ISPSubscriber extends Subscriber {

    private long freeUsage;

    public ISPSubscriber() {
    }

    @Override
    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions (subscriberId);
        long totalData = sessions.stream ().mapToLong (InternetSessionHistory.InternetSession::getDataUsed).sum ();
        long chargeableData = totalData - freeUsage;
        return chargeableData * baseRate / 100;
    }


}