import java.util.Date;

public class ChangeDateFormat {
    private String date;

    public ChangeDateFormat (String date) {
        this.date = date;
    }

    public static String NewFormat (String date) {
        String[] splitterarray = date.split("/");
        String[] temp;

        String dd = splitterarray[0];
        String mm = splitterarray[1];
        temp = splitterarray[2].split(" ");
        String yyyy = temp[0];
        String time = temp[1];

        System.out.println(dd);

        if (dd.equals(" 1") || dd.equals(" 21") || dd.equals(" 31")) {
            dd = dd.concat("st");
        } else if (dd.equals(" 2") || dd.equals(" 22")) {
            dd = dd.concat("nd");
        } else if (dd.equals(" 3") || dd.equals(" 23")) {
            dd = dd.concat("rd");
        } else {
            dd = dd.concat("th");
        }

        switch (mm) {
            case "1":
                mm = "January";
                break;
            case "2":
                mm = "February";
                break;
            case "3":
                mm = "March";
                break;
            case "4":
                mm = "April";
                break;
            case "5":
                mm = "May";
                break;
            case "6":
                mm = "June";
                break;
            case "7":
                mm = "July";
                break;
            case "8":
                mm = "August";
                break;
            case "9":
                mm = "September";
                break;
            case "10":
                mm = "October";break;
            case "11":
                mm = "November";
                break;
            case "12":
                mm = "December";
                break;
        }

        int int_time = Integer.parseInt(time);
        int hour;
        int minutes;
        if(int_time <= 100) {
            if(int_time < 10) {
                time = 12 + ".0" + int_time + "am";
            }
            else {
                time = 12 + "." + int_time + "am";
            }
        }
        else if(int_time == 1200) {
            time = 12 + "pm";
        }
        else if(int_time == 0000) {
            time = 12 + "am";
        }
        else if(int_time > 1200) {
            System.out.println(int_time);
            hour = (int_time - 1200)/100;
            minutes = (int_time-1200) - (hour*100);
            if(minutes == 0) {
                time = hour + "pm";
            }
            else if(minutes < 10) {
                time = hour + ".0" + minutes + "am";
            }
            else {
                time = hour + "." + minutes + "pm";
            }
        }
        else {
            hour = int_time/100;
            minutes = int_time - hour*100;
            if(minutes == 0) {
                time = hour + "am";
            }
            else if(minutes < 10) {
                time = hour + ".0" + minutes + "am";
            }
            else {
                time = hour + "." + minutes + "am";
            }
        }
        String newFormat = dd + " " + mm + " " + yyyy + ", " + time;
        return newFormat;
    }
}
