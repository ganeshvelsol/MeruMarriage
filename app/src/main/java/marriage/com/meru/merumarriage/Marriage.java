package marriage.com.meru.merumarriage;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import marriage.com.meru.merumarriage.helpers.CustomDatePickers;
import marriage.com.meru.merumarriage.readfirebase.ViewDetails;

public class Marriage extends AppCompatActivity
{
    RelativeLayout view_profile,upload;
    DatePickerDialog.OnDateSetListener mlistener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage);
        view_profile=(RelativeLayout)findViewById(R.id.view_profile);
        upload=(RelativeLayout)findViewById(R.id.upload);
//        Calendar cal=Calendar.getInstance();
//
//        DatePickerDialog dp=new DatePickerDialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen,mlistener,
//                cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_WEEK));
//        dp.show();
//        mlistener=new DatePickerDialog.OnDateSetListener()
//        {
//            @Override
//            public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
//            {
//                Log.e("date ",""+i+""+(i1+1)+""+i2);
//            }
//        };
       view_profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Marriage.this, ViewDetails.class));
            }
        });
        upload.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(Marriage.this,MainActivity.class));
            }
        });
    }

}
