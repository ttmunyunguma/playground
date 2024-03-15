package defaultt.hackerank;

/**
 * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 */
public class TimeConversion {

    public static String timeConversion(String s) {
        // Write your code here

        String[] parts = s.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2].substring(0, 2));
        String meridiem = parts[2].substring(2);

        if (meridiem.equals("AM")) {
            if (hours == 12) {
                hours = 0;
            }
        } else {
            if (hours != 12) {
                hours += 12;
            }
        }

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }

}
