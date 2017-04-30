/*
    Click on hours, minutes or AM/PM on the TimePicker. The clock hand
    will change accordingly. The Save button updates the time
    chosen on a TextView widget. The initial time of day is gotten from
    a Calendar object, subsequent from the Timepicker object.
    minSdkVersion had to be set to API 23 because of depricated methods.
 */
package com.course.example.timepicker;

import java.util.Calendar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class  MainActivity extends Activity {
    private TimePicker timePicker;
    private TextView time;
    private Calendar calendar;
    private String format = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        time = (TextView) findViewById(R.id.textView1);
        calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);
    }

    //listener method for button click
    public void setTime(View view) {
        int hour = timePicker.getHour();
        int min = timePicker.getMinute();
        showTime(hour, min);
    }

    //format time and place it on TextView widget
    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
        if (min < 10)
            time.setText(new StringBuilder().append("  ").append(hour).append(":0").append(min)
                    .append(" ").append(format));
        else
            time.setText(new StringBuilder().append("  ").append(hour).append(":").append(min)
                    .append(" ").append(format));
    }
}