package WS09.WS09_PS10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SevenSegTime {

    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private final Date dt;

    public static final int DIGIT_H1 = 0,
            DIGIT_H2 = 1,
            DIGIT_M1 = 2,
            DIGIT_M2 = 3,
            DIGIT_S1 = 4,
            DIGIT_S2 = 5;


    public SevenSegTime(long timeMillis)
    {
        dt = new Date(timeMillis);
    }


    @Override
    public String toString()
    {
        return sdf.format(dt);
    }


    /**
     * give the time, HH mm ss
     * @return array, HH mm ss
     */
    public SevenSegDigit[] getTime() {

        Calendar c = Calendar.getInstance();
        c.setTime(dt);

        SevenSegDigit[] time = new SevenSegDigit[6];

        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min  = c.get(Calendar.MINUTE);
        int sec  = c.get(Calendar.SECOND);

        System.arraycopy(getDigits(hour), 0, time, 0, 2);
        System.arraycopy(getDigits(min), 0, time, 2, 2);
        System.arraycopy(getDigits(sec), 0, time, 4, 2);

        return time;
    }


    private SevenSegDigit[] getDigits(int d)
    {

        assert Integer.valueOf(d).toString().length()<3 && d >= 0 : "invalid number of digits";

        SevenSegDigit[] seg = new SevenSegDigit[2];

        if (d<10)
        {
            seg[0] = new SevenSegDigit(0);
            seg[1] = new SevenSegDigit(d);
        } else {
            String dig = Integer.valueOf(d).toString();
            seg[0] = new SevenSegDigit(Integer.valueOf(dig.substring(0,1)));
            seg[1] = new SevenSegDigit(Integer.valueOf(dig.substring(1,2)));
        }


        return seg;

    }



}