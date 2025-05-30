package com.path2prod;

import java.time.LocalDateTime;
import java.util.List;

public record Event(String name, LocalDateTime scheduledAt) {
    public static List<Event> buildEvents(){
        return List.of(
            new Event("event1", LocalDateTime.now().minusDays(2)),
            new Event("event2", LocalDateTime.now().minusDays(1)),
            new Event("event3", LocalDateTime.now().plusMonths(2)),
            new Event("event4", LocalDateTime.now().plusDays(2)),
            new Event("event5", LocalDateTime.now().minusDays(4)),
            new Event("event6", LocalDateTime.now().plusMonths(3)),
            new Event("event7", LocalDateTime.now().plusMonths(3)),
            new Event("event8", LocalDateTime.now().minusYears(1)),
            new Event("event9", LocalDateTime.now().plusDays(15)),
            new Event("event10", LocalDateTime.now().plusDays(19))
        );
    }
}
