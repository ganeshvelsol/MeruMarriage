package marriage.com.meru.merumarriage;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import marriage.com.meru.merumarriage.helpers.MyApplication;
import marriage.com.meru.merumarriage.tofirebase.InsertIntoFirebase;

public class MainActivity extends AppCompatActivity
{
    Spinner gender_spinner,gender_marial_spinner,occupation,looking_for,looking_for_job,looking_for_house;
    List<String> gender,marialStatus,occPation,fors,lforJob,lforHouse;
    EditText name,full_name,date_set,star,time,height,color,mobile_num,qualificatn,salary,working_place,cmp_name,
            f_name,f_desgn,m_name,m_design,family_address,no_brothers,no_brothers_marrg,no_sisters,no_sisters_marrg,
            family_mobile,abt_urself,abt_desc,l_for_height,l_for_salary,l_for_color,mail_id;
    ImageView date_select_imageview;
    ArrayAdapter aa;
    ImageView image_display;
    TextView select_image;
    Bitmap bit=null;
    public static final String EMPLOYEE_REF_NAME="MaleCandidates";
    public static final String Female_Details="FemaleCandidates";
    public static final int CAM_REQ_CODE=123;
    FirebaseAuth mAuth;
    Button save_data;
    LinearLayout data_loading_screen_layout;
    String image,sGender,mStatus,profession,lFor,lFJob,LFHouse,mail,Name,FName,Star,Time,Height,Color,Mobile,date,
            stdy,Salry,Worklace,cName,fname,fa_des,mo_name,modes,faddress,bros,broMarg,sis,sisMrg,fMObile,abt,lfh,lfs,lfc;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialzing the input values
        gender_spinner=(Spinner)findViewById(R.id.gender_spinner);
        gender_marial_spinner=(Spinner)findViewById(R.id.gender_marial_spinner);
        occupation=(Spinner)findViewById(R.id.occupation);
        looking_for=(Spinner)findViewById(R.id.looking_for);
        looking_for_job=(Spinner)findViewById(R.id.looking_for_job);
        looking_for_house=(Spinner)findViewById(R.id.looking_for_house);
        date_select_imageview=(ImageView)findViewById(R.id.date_select_imageview);
        date_set=(EditText)findViewById(R.id.date_set);
        data_loading_screen_layout=(LinearLayout)findViewById(R.id.data_loading_screen_layout);
        mAuth=FirebaseAuth.getInstance();
        name=(EditText)findViewById(R.id.name);
        full_name=(EditText)findViewById(R.id.full_name);
        star=(EditText)findViewById(R.id.star);
        time=(EditText)findViewById(R.id.time);
        height=(EditText)findViewById(R.id.height);
        color=(EditText)findViewById(R.id.color);
        mobile_num=(EditText)findViewById(R.id.mobile_num);
        qualificatn=(EditText)findViewById(R.id.qualificatn);
        salary=(EditText)findViewById(R.id.salary);
        working_place=(EditText)findViewById(R.id.working_place);
        cmp_name=(EditText)findViewById(R.id.cmp_name);
        f_name=(EditText)findViewById(R.id.f_name);
        f_desgn=(EditText)findViewById(R.id.f_desgn);
        m_name=(EditText)findViewById(R.id.m_name);
        m_design=(EditText)findViewById(R.id.m_design);
        family_address=(EditText)findViewById(R.id.family_address);
        no_brothers=(EditText)findViewById(R.id.no_brothers);
        no_brothers_marrg=(EditText)findViewById(R.id.no_brothers_marrg);
        no_sisters=(EditText)findViewById(R.id.no_sisters);
        no_sisters_marrg=(EditText)findViewById(R.id.no_sisters_marrg);
        family_mobile=(EditText)findViewById(R.id.family_mobile);
        abt_urself=(EditText)findViewById(R.id.abt_urself);
        abt_desc=(EditText)findViewById(R.id.abt_desc);
        l_for_height=(EditText)findViewById(R.id.l_for_height);
        l_for_salary=(EditText)findViewById(R.id.l_for_salary);
        l_for_color=(EditText)findViewById(R.id.l_for_color);
        mail_id=(EditText)findViewById(R.id.mail_id);
        select_image=(TextView) findViewById(R.id.select_image);
        image_display=(ImageView) findViewById(R.id.image_display);

        save_data=(Button)findViewById(R.id.save_data);
        gender=new ArrayList<>();
        marialStatus=new ArrayList<>();
        occPation=new ArrayList<>();
        fors=new ArrayList<>();
        lforJob=new ArrayList<>();
        lforHouse=new ArrayList<>();

        initViews();
    }
    public void initViews()
    {

        lforJob.add("--select job type--");
        lforJob.add("Private");
        lforJob.add("Government");
        lforJob.add("business");
        lforJob.add("other");

        lforHouse.add("--select house--");
        lforHouse.add("Own");
        lforHouse.add("Rent");

        fors.add("--looking for--");
        fors.add("Male");
        fors.add("Fe-male");

        gender.add("-- gender --");
        gender.add("Male");
        gender.add("Fe-Male");

        marialStatus.add("-- marial status --");
        marialStatus.add("Married");
        marialStatus.add("Un-Married");

        occPation.add("-- occupation --");
        occPation.add("business");
        occPation.add("IT");
        occPation.add("private");
        occPation.add("Government");
        occPation.add("others");
        date_select_imageview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                codeToSelectDate();
            }
        });
        select_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //select image
                Intent ss=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(ss,CAM_REQ_CODE);
            }
        });
        save_data.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                addDataTofb();
            }
        });
        aa=new ArrayAdapter(this,R.layout.spinner_data,gender);
        gender_spinner.setAdapter(aa);
        aa=new ArrayAdapter(this,R.layout.spinner_data,marialStatus);
        gender_marial_spinner.setAdapter(aa);
        aa=new ArrayAdapter(this,R.layout.spinner_data,occPation);
        occupation.setAdapter(aa);
        aa=new ArrayAdapter(this,R.layout.spinner_data,fors);
        looking_for.setAdapter(aa);
        aa=new ArrayAdapter(this,R.layout.spinner_data,lforJob);
        looking_for_job.setAdapter(aa);
        aa=new ArrayAdapter(this,R.layout.spinner_data,lforHouse);
        looking_for_house.setAdapter(aa);
    }
    public void codeToSelectDate()
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
            {
                date_set.setText(""+i2+"/"+i1+"/"+i);
            }
        },1990,01,01);
        datePickerDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case CAM_REQ_CODE:
                if(resultCode == RESULT_OK)
                {
                    Bundle b=data.getExtras();
                    bit=(Bitmap)b.get("data");
                    ByteArrayOutputStream bout=new ByteArrayOutputStream();
                    bit.compress(Bitmap.CompressFormat.JPEG,100,bout);
                    byte img[]=bout.toByteArray();
                     image= Base64.encodeToString(img,Base64.DEFAULT);
                    image_display.setImageBitmap(bit);
                }
                break;

//            case GAL_REQ_CODE:
//
//                if(resultCode == RESULT_OK)
//                {
//                    Uri img=data.getData();
//                    try
//                    {
//                        bit=MediaStore.Images.Media.getBitmap(this.getContentResolver(),img);
//                    }
//                    catch (IOException e)
//                    {
//                        e.printStackTrace();
//                    }
//                    mImageView.setImageBitmap(bit);
//                }
//                break;
        }
    }

    public void addDataTofb()
    {

        sGender=gender_spinner.getSelectedItem().toString();
        mStatus=gender_marial_spinner.getSelectedItem().toString();
        profession=occupation.getSelectedItem().toString();
        lFor=looking_for.getSelectedItem().toString();
        lFJob=looking_for_job.getSelectedItem().toString();
        LFHouse=looking_for_house.getSelectedItem().toString();

         Name=name.getText().toString().trim();
         FName=full_name.getText().toString().trim();
         Star=star.getText().toString().trim();
        date=date_set.getText().toString().trim();
         Time=time.getText().toString().trim();
         Height=height.getText().toString().trim();
         Color=color.getText().toString().trim();
         Mobile=mobile_num.getText().toString().trim();
         stdy=qualificatn.getText().toString().trim();
         Salry=salary.getText().toString().trim();
         Worklace=working_place.getText().toString().trim();
         cName=cmp_name.getText().toString().trim();
         fname=f_name.getText().toString().trim();
         fa_des=f_desgn.getText().toString().trim();
         mo_name=m_name.getText().toString().trim();
         modes=m_design.getText().toString().trim();
         faddress=family_address.getText().toString().trim();
         bros=no_brothers.getText().toString().trim();
         broMarg=no_brothers_marrg.getText().toString().trim();
         sis=no_sisters.getText().toString().trim();
         sisMrg=no_sisters_marrg.getText().toString().trim();
         fMObile=family_mobile.getText().toString().trim();
         abt=abt_urself.getText().toString().trim();
        final String abtDEsc=abt_desc.getText().toString().trim();
         lfh=l_for_height.getText().toString().trim();
         lfs=l_for_salary.getText().toString().trim();
         lfc=l_for_color.getText().toString().trim();
         mail=mail_id.getText().toString().trim();
        if (Name.isEmpty())
        {
            name.setError("enter name");
        }
        else if (FName.isEmpty())
        {
            full_name.setError("enter full name");
        }else if (Star.isEmpty())
        {
            star.requestFocus();
            star.setError("enter star name");
        }else if (Time.isEmpty())
        {
            time.requestFocus();
            time.setError("enter time ");
        }else if (Height.isEmpty())
        {
            height.requestFocus();
            height.setError("enter height");
        }else if (Color.isEmpty())
        {
            color.requestFocus();
            color.setError("enter color");
        }else if (Mobile.isEmpty())
        {
            mobile_num.requestFocus();
            mobile_num.setError("enter mobile number");
        }else if (stdy.isEmpty())
        {
            qualificatn.requestFocus();
            qualificatn.setError("enter study");
        }else if (Salry.isEmpty())
        {
            salary.requestFocus();
            salary.setError("enter salary");
        }else if (Worklace.isEmpty())
        {
            working_place.requestFocus();
            working_place.setError("enter place of work");
        }else if (cName.isEmpty())
        {
            cmp_name.requestFocus();
            cmp_name.setError("company name");
        }else if (fname.isEmpty())
        {
            f_name.requestFocus();
            f_name.setError("father name");
        }else if (fa_des.isEmpty())
        {
            f_desgn.requestFocus();
            f_desgn.setError("enter designation");
        }else if (mo_name.isEmpty())
        {
            m_name.requestFocus();
            m_name.setError("enter mother name");

        }else if (modes.isEmpty())
        {
            m_design.requestFocus();
            m_design.setError("enter mother designation");
        }else if (faddress.isEmpty())
        {
            family_address.requestFocus();
            family_address.setError("enter address");
        }else if (bros.isEmpty())
        {
            no_brothers.requestFocus();
            no_brothers.setError("enter brothers");
        }else if (broMarg.isEmpty())
        {
            no_brothers_marrg.requestFocus();
            no_brothers_marrg.setError("enter marriage data");
        }else if (fMObile.isEmpty())
        {family_mobile.requestFocus();
            family_mobile.setError("enter mbile number");

        }else if (abt.isEmpty())
        {
            abt_urself.requestFocus();
            abt_urself.setError("describe your self");
        }else if (abtDEsc.isEmpty())
        {
            abt_desc.requestFocus();
            abt_desc.setError("write something about partner");
        }else if (lfc.isEmpty())
        {
            l_for_color.requestFocus();
            l_for_color.setError("enter partner color");
        }
        else if (mail.isEmpty())
        {
            mail_id.requestFocus();
            mail_id.setError("enter mail Id");
        }
        else if (image.isEmpty())
        {
            Toast.makeText(this, "Select a valid photo", Toast.LENGTH_LONG).show();
        }
        else
        {
            if (MyApplication.isNetworkAvailable(MainActivity.this))
            {
                data_loading_screen_layout.setVisibility(View.VISIBLE);
                //if everything is succes done the code below...
                mAuth.createUserWithEmailAndPassword(mail,sGender)
                        .addOnCompleteListener(MainActivity.this,new OnCompleteListener<AuthResult>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                data_loading_screen_layout.setVisibility(View.GONE);

                                if (task.isSuccessful())
                                {
                                    InsertIntoFirebase adding=new InsertIntoFirebase(image,Name,FName,date,Star,Time,Height,Color,Mobile,stdy,Salry,Worklace,
                                            cName,fname,fa_des,mo_name,modes,faddress,bros,broMarg,sis,sisMrg,fMObile,abt,abtDEsc,
                                            lfh,lfs,lfc,mail,sGender,mStatus,profession,lFor,lFJob);
                                    if (lFor.equals("Male"))
                                    {
                                        //store into female details
                                        DatabaseReference dr= FirebaseDatabase.getInstance().getReference(Female_Details).child(FName);
                                        dr.setValue(adding);
                                        Toast.makeText(MainActivity.this, "succesgully Added..", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        //store dat nto male detail list
                                        DatabaseReference dr= FirebaseDatabase.getInstance().getReference(EMPLOYEE_REF_NAME).child(FName);
                                        dr.setValue(adding);
                                        Toast.makeText(MainActivity.this, "succesgully Added..", Toast.LENGTH_SHORT).show();
                                    }
                                    //if authentication success write adding data into firebase


                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this, "authentication failed"+task, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            else
            {
                data_loading_screen_layout.setVisibility(View.GONE);
                Snackbar snackbar = Snackbar
                        .make(this.findViewById(android.R.id.content), "No internet connection! Turn on ", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View view)
                                    {
                                        startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                                    }
                                }
                        );
                snackbar.show();
            }
        }
    }
}

