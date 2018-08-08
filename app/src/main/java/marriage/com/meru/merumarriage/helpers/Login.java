package marriage.com.meru.merumarriage.helpers;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import marriage.com.meru.merumarriage.R;

public class Login extends AppCompatActivity
{
    EditText email,gender;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        gender=findViewById(R.id.gender);
        auth=FirebaseAuth.getInstance();
    }
    public void forwarded(View vp)
    {
        String emails=email.getText().toString().trim();
        String nuber=gender.getText().toString().trim();
        if (emails.isEmpty())
        {
            email.requestFocus();
            email.setError("enter email ");
        }else if (nuber.isEmpty())
        {
            gender.requestFocus();
            gender.setError("enter email ");
        }
        else
        {

            if (MyApplication.isNetworkAvailable(this)) {

                auth.signInWithEmailAndPassword(emails, nuber)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this, "login success", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Login.this, "login denied", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }else
            {
                Snackbar op=Snackbar.make(findViewById(android.R.id.content),"no internet connection. Make it on",Snackbar.LENGTH_LONG);
                op.show();
            }
        }
    }

}

