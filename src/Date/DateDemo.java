package Date;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class  DateDemo {
    public static void main(String[] args) {
        // Get today's date
        Date today = new Date();

        // Get the date of the day after tomorrow
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 2);  // Add 2 days to the current date
        Date dayAfterTomorrow = calendar.getTime();

        // Define different date formats
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  // ISO format
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");  // DD/MM/YYYY format
        SimpleDateFormat format3 = new SimpleDateFormat("EEEE, MMMM d, yyyy");  // Full date with day and month
        SimpleDateFormat format4 = new SimpleDateFormat("MM-dd-yyyy");  // MM-DD-YYYY format

        // Print today's date in different formats
        System.out.println("Today's Date (yyyy-MM-dd): " + format1.format(today));
        System.out.println("Today's Date (dd/MM/yyyy): " + format2.format(today));
        System.out.println("Today's Date (Full format): " + format3.format(today));
        System.out.println("Today's Date (MM-dd-yyyy): " + format4.format(today));

        // Print day after tomorrow's date in different formats
        System.out.println("\nDay after Tomorrow's Date (yyyy-MM-dd): " + format1.format(dayAfterTomorrow));
        System.out.println("Day after Tomorrow's Date (dd/MM/yyyy): " + format2.format(dayAfterTomorrow));
        System.out.println("Day after Tomorrow's Date (Full format): " + format3.format(dayAfterTomorrow));
        System.out.println("Day after Tomorrow's Date (MM-dd-yyyy): " + format4.format(dayAfterTomorrow));
    }
}
