import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class ChangeDateFormat {
    private String date;

    /**
     * Constructor of ChangeDateFormat
     * @param date the date/timing of the task
     */
    public ChangeDateFormat (String date) {
        this.date = date;
    }

    /**
     * This method changes the date format from eg 18/08/1997 1900 to the format in textfile of 18th August 1997 7pm.
     * @param date date/time of the task
     * @return the new date in the format of the textfile
     */
    public String NewFormat(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date newDate = new Date();

        try {
            newDate = sdf.parse(date);
        } catch (ParseException e) {
            return date;
        }

        //convert input string into the specific date format
        int hour = Integer.parseInt(new SimpleDateFormat("h").format(newDate));
        int min = Integer.parseInt(new SimpleDateFormat("m").format(newDate));
        String period = (new SimpleDateFormat("a").format(newDate)).toLowerCase();
        String formatTime;
        if (min > 0) {
            formatTime = hour + "." + min + period;
        } else {
            formatTime = hour + period;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        int day = calendar.get(Calendar.DATE);
        //get the suffix for the date format
        if (!((day > 10) && (day < 19)))
            switch (day % 10) {
                case 1:
                    return new SimpleDateFormat("d'st' 'of' MMMM yyyy").format(newDate) + ", " + formatTime;
                case 2:
                    return new SimpleDateFormat("d'nd' 'of' MMMM yyyy").format(newDate) + ", " + formatTime;
                case 3:
                    return new SimpleDateFormat("d'rd' 'of' MMMM yyyy").format(newDate) + ", " + formatTime;
                default:
                    return new SimpleDateFormat("d'th' 'of' MMMM yyyy").format(newDate) + ", " + formatTime;
            }
        return new SimpleDateFormat("d'th' 'of' MMMM yyyy").format(newDate) + ", " + formatTime;
    }
}