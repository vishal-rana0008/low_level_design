package com.interview.interview2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class App {


    // Stripe Round 1 question
    public static void main(String[] args) {
        String logs = "Y Y N Y";
        int closingHours = 4;

        int bestClosingTime = find_best_closing_time(logs);

        System.out.println("bestClosingTime : " + bestClosingTime);
    }

    public static int find_best_closing_time(String logs) {
        String spaceRemovedLogs = logs.replace(" ", "");
        int maxClosingHour = spaceRemovedLogs.length();

        int minPenaltyClosingHour = -1;
        int minPenalty = Integer.MAX_VALUE;

        for (int closingHour = 0; closingHour <= maxClosingHour; closingHour++) {
            int penalty = findPenalty(logs, closingHour);
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minPenaltyClosingHour = closingHour;
            }
        }

        return minPenaltyClosingHour;
    }

    public static int findPenalty(String logs, int closingHours) {
        logs = logs.replace(" ", "");
        int n = logs.length();

        int penalty = 0;

        for (int hour = 1; hour <= n; hour++) {
            int indx = hour - 1;
            if (hour <= closingHours && logs.charAt(indx) == 'N') {
                penalty++;
            } else if (hour > closingHours && logs.charAt(indx) == 'Y')
                penalty++;
        }

        return penalty;
    }
}


