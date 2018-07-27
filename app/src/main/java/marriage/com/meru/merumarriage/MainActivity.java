package marriage.com.meru.merumarriage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    Spinner gender_spinner,gender_marial_spinner;
    List<String> gender,marialStatus;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender_spinner=(Spinner)findViewById(R.id.gender_spinner);
        gender_marial_spinner=(Spinner)findViewById(R.id.gender_marial_spinner);
        gender=new ArrayList<>();
        marialStatus=new ArrayList<>();
        gender.add("gender");
        gender.add("Male");
        gender.add("Fe-Male");

        marialStatus.add("marial status");
        marialStatus.add("Married");
        marialStatus.add("Un-Married");

        aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        gender_spinner.setAdapter(aa);
        aa=new ArrayAdapter(this,android.R.layout.simple_spinner_item,marialStatus);
        gender_marial_spinner.setAdapter(aa);
    }
}

