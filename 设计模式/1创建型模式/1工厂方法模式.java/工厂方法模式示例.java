import java.util.Calendar;

public class CalendarFactory {
    public static Calendar createCalendar() {
        return Calendar.getInstance();
    }
}

public class Main {
    public static void main(String[] args) {
        Calendar calendar = CalendarFactory.createCalendar();
        System.out.println(calendar.getTime());
    }
}
