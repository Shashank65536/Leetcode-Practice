package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventScheduler {

    // Function that returns the maximum number of events a person can attend
    public static int maxEvents(int[][] events) {
        // Edge case: no events
        if (events == null || events.length == 0) {
            return 0;
        }

        // Convert the array to a List so that we can use Collections.sort
        List<int[]> eventList = new ArrayList<>();
        for (int[] e : events) {
            eventList.add(e);
        }

        // Sort events by their end time (ascending).
        // If end times are equal, sort by start time.
        Collections.sort(eventList, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return Integer.compare(a[1], b[1]); // compare end times
                }
                return Integer.compare(a[0], b[0]);     // tie-breaker: start times
            }
        });

        int count = 0;                    // number of events we can attend
        int lastEndTime = Integer.MIN_VALUE; // end time of the last attended event

        // Greedily pick events
        for (int[] event : eventList) {
            int start = event[0];
            int end = event[1];

            // We can attend this event if it starts at or after
            // the end of the last attended event.
            // (start >= lastEndTime because end time is exclusive.)
            if (start >= lastEndTime) {
                count++;
                lastEndTime = end;  // update the boundary
            }
        }

        return count;
    }

    // Simple main to test the function with the examples
    public static void main(String[] args) {
        int[][] events1 = { {1, 4}, {2, 5}, {5, 8}, {3, 6}, {7, 9} };
        int[][] events2 = { {1, 3}, {2, 6}, {8, 10}, {7, 8}, {4, 7} };

        System.out.println(maxEvents(events1)); // expected: 3
        System.out.println(maxEvents(events2)); // expected: 4
    }
}
