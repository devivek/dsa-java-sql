import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LocalDateCalender {
    public static void main(String[] args) {
        String date = "2021-07-01";

        // using LocalDate: introduced in Java 8 : immutable and has no concept of time or timezone
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate =  LocalDate.parse(date, formatter).plusDays(9);
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));

        // using Calendar : mutable and has the concept of time and timezone
        Calendar cal = Calendar.getInstance();
        /*cal.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 4)));
        cal.set(Calendar.MONTH, Integer.parseInt(date.substring(5, 7)));
        cal.set(Calendar.DATE, Integer.parseInt(date.substring(8, 10)));
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));*/
       
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(date);
            cal.setTime(dt);
            cal.add(Calendar.DATE, 9);
            System.out.println(sdf.format(cal.getTime()));

        } catch(Exception exception){
            exception.printStackTrace();

        }

    }
}
