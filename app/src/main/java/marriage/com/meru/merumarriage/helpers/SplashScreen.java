package marriage.com.meru.merumarriage.helpers;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import marriage.com.meru.merumarriage.MainActivity;
import marriage.com.meru.merumarriage.Marriage;
import marriage.com.meru.merumarriage.R;

public class SplashScreen extends AppCompatActivity
{
    TextView mtext_display;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        mtext_display=(TextView)findViewById(R.id.mtext_display);
        mtext_display.setText("Marriages are made in heaven but meeting\n" +
                "\n" +
                "      the correct partners is a\n" +
                "\n" +
                "        heaven and commited to become a succesfull\n" +
                "\n" +
                "         couples with avoiding the egos, obstacles is the great heaven");
//        new Handler().postDelayed(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                Intent i = new Intent(SplashScreen.this, Marriage.class);
//                startActivity(i);
//                finish();
//            }
//        }, 4000);
    }
    public void register(View vs)
    {
        startActivity(new Intent(this,Marriage.class));
        finish();
    }
    public void login(View ss)
    {
        startActivity(new Intent(this,Login.class));
    }
}
