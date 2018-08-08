package marriage.com.meru.merumarriage.helpers;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Velsol 170016 on 8/6/2018.
 */

public class CustomDatePickers extends DialogFragment
{
    int year,month,day;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Calendar cal=Calendar.getInstance();
         year=cal.get(Calendar.YEAR);
         month=cal.get(Calendar.MONTH);
         day=cal.get(Calendar.DAY_OF_WEEK);
        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(),year,month,day);
    }
}
