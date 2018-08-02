package marriage.com.meru.merumarriage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import marriage.com.meru.merumarriage.readfirebase.ViewDetails;

public class Marriage extends AppCompatActivity
{
    RelativeLayout view_profile,upload;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage);
        view_profile=(RelativeLayout)findViewById(R.id.view_profile);
        upload=(RelativeLayout)findViewById(R.id.upload);
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
