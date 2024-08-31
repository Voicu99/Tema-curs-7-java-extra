import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler {
    private List<Event> events;

    public Scheduler() {
        this.events = new ArrayList<>();
    }

    // Add an event
    public void addEvent(Event e) {
        events.add(e);
    }

    // Remove an event by its name
    public void removeEvent(String eventName) {
        events.removeIf(event -> event.getEventName().equalsIgnoreCase(eventName));
    }

    // Get the next n upcoming events
    public List<Event> getUpcomingEvents(int n) {
        return events.stream()
                .filter(event -> event.getEventDateTime().isAfter(LocalDateTime.now()))
                .sorted((e1, e2) -> e1.getEventDateTime().compareTo(e2.getEventDateTime()))
                .limit(n)
                .collect(Collectors.toList());
    }

    // Get events on a specific date
    public List<Event> getEventsOn(LocalDate date) {
        return events.stream()
                .filter(event -> event.getEventDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    // Get pending reminders in the next 24 hours
    public List<Event> getPendingReminders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime in24Hours = now.plusHours(24);
        return events.stream()
                .filter(event -> event.getReminderDateTime().isAfter(now) &&
                        event.getReminderDateTime().isBefore(in24Hours))
                .collect(Collectors.toList());
    }
}
