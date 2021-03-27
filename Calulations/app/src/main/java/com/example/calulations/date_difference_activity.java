package com.example.calulations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date_difference_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_difference_activity);
    }
    public void showConversions(View view) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = null;
        Date d2 = null;
        EditText dt1=findViewById(R.id.dateOne);
        EditText dt2=findViewById(R.id.dateTwo);

        TextView dl=findViewById(R.id.daysLbl);
        TextView yl=findViewById(R.id.yearsLbl);
        TextView ml=findViewById(R.id.monthsLbl);
        TextView hl=findViewById(R.id.hrsLbl);
        TextView minl=findViewById(R.id.minsLbl);
        TextView sl=findViewById(R.id.secLbl);

        try {
            d1 = format.parse(dt1.getText().toString());
            d2 = format.parse(dt2.getText().toString());

            long diff = d2.getTime() - d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            long diffMonths= (long) (diffDays/30.4);
            long diffYears=diffDays/365;
            long diffHours=diffDays*24;
            long diffMinutes=diffHours*60;
            long diffSeconds=diffMinutes*60;

            yl.setText(diffYears + " Years ");
            ml.setText(diffMonths + " Months ");
            dl.setText(diffDays + " Days ");
            hl.setText(diffHours + " Hours ");
            minl.setText(diffMinutes + " Minutes ");
            sl.setText(diffSeconds + " Seconds ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
