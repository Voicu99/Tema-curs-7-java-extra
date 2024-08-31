import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        // Create events
        Event event1 = new Event("Meeting", "Project discussion",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(1).minusHours(1));
        Event event2 = new Event("Conference", "Annual tech conference",
                LocalDateTime.now().plusDays(2),
                LocalDateTime.now().plusDays(2).minusHours(1));
        Event event3 = new Event("Dinner", "Family dinner party",
                LocalDateTime.now().plusHours(8),
                LocalDateTime.now().plusHours(7));

        // Add events to the scheduler
        scheduler.addEvent(event1);
        scheduler.addEvent(event2);
        scheduler.addEvent(event3);

        // Display upcoming events
        System.out.println("Upcoming Events:");
        for (Event e : scheduler.getUpcomingEvents(3)) {
            System.out.println("Event: " + e.getEventName() +
                    ", Description: " + e.getEventDescription() +
                    ", Date: " + e.getEventDateTime() +
                    ", Reminder: " + e.getReminderDateTime());
        }

        // Display events on a specific date
        LocalDate date = LocalDate.now().plusDays(1);
        System.out.println("\nEvents on " + date + ":");
        for (Event e : scheduler.getEventsOn(date)) {
            System.out.println("Event: " + e.getEventName() +
                    ", Description: " + e.getEventDescription() +
                    ", Date: " + e.getEventDateTime() +
                    ", Reminder: " + e.getReminderDateTime());
        }

        // Display pending reminders
        System.out.println("\nPending Reminders:");
        for (Event e : scheduler.getPendingReminders()) {
            System.out.println("Event: " + e.getEventName() +
                    ", Description: " + e.getEventDescription() +
                    ", Reminder: " + e.getReminderDateTime());
        }
    }
}