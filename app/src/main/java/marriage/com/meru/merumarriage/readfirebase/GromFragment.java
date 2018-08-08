package marriage.com.meru.merumarriage.readfirebase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import marriage.com.meru.merumarriage.MainActivity;
import marriage.com.meru.merumarriage.R;
import marriage.com.meru.merumarriage.helpers.MyApplication;
import marriage.com.meru.merumarriage.tofirebase.InsertIntoFirebase;


public class GromFragment extends Fragment
{
    RecyclerView recycler_groom;
    ArrayList al=new ArrayList();
    ArrayList al_fullDetails=new ArrayList();
    String key[]={"k1","k2","k3","k4","k5","k6","k7","k8","k9","k10","k11","k12","k13","k14","k15","k16","k17","k18","k19","k20","k21","k22","k23","k24","k25","k26","k27","k28","k29","k30","k31","k32","k33","k34","k35"};
    View v6;
    LinearLayout dataLoadings;
    LinearLayoutManager llm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        try
        {
            v6= inflater.inflate(R.layout.fragment_grom, container, false);
            recycler_groom=(RecyclerView)v6.findViewById(R.id.recycler_groom);
        }catch (Exception e)
        {

        }

        initData();
        return v6;
    }
    public void initData()
    {
        if (MyApplication.isNetworkAvailable(getActivity())) {

            llm = new LinearLayoutManager(getContext());
            DatabaseReference dr = FirebaseDatabase.getInstance().getReference(MainActivity.EMPLOYEE_REF_NAME);
            dr.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    try {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            InsertIntoFirebase ef = ds.getValue(InsertIntoFirebase.class);
                            HashMap hm = new HashMap();
                            hm.put(key[0], ef.getImage());//Name
                            hm.put(key[1], ef.getName());//Contact
                            hm.put(key[2], ef.getFull_name());//Email
                            hm.put(key[3], ef.getDate_set());//Email
                            hm.put(key[4], ef.getStar());//Email
                            hm.put(key[5], ef.getTime());//Email
                            hm.put(key[6], ef.getHeight());//Email
                            hm.put(key[7], ef.getColor());//Email
                            hm.put(key[8], ef.getMobile_num());//Email
                            hm.put(key[9], ef.getQualificatn());//Email
                            hm.put(key[10], ef.getSalary());//Email
                            hm.put(key[11], ef.getWorking_place());//Email
                            hm.put(key[12], ef.getCmp_name());//Email
                            hm.put(key[13], ef.getF_name());//Email
                            hm.put(key[14], ef.getF_desgn());//Email
                            hm.put(key[15], ef.getM_name());//Email
                            hm.put(key[16], ef.getM_design());//Email
                            hm.put(key[17], ef.getFamily_address());//Email
                            hm.put(key[18], ef.getNo_brothers());//Email
                            hm.put(key[19], ef.getNo_brothers_marrg());//Email
                            hm.put(key[20], ef.getNo_sisters());//Email
                            hm.put(key[21], ef.getNo_sisters_marrg());//Email
                            hm.put(key[22], ef.getFamily_mobile());//Email
                            hm.put(key[23], ef.getAbt_urself());//Email
                            hm.put(key[24], ef.getAbt_desc());//Email
                            hm.put(key[25], ef.getlFor());//Email
                            hm.put(key[26], ef.getL_for_height());//Email
                            hm.put(key[27], ef.getL_for_salary());//Email
                            hm.put(key[28], ef.getL_for_color());//Email
                            hm.put(key[29], ef.getProfession());//Email
                            al.add(hm);
                            al_fullDetails.add(hm);
                        }
                        GroomAdapter adapter = new GroomAdapter(getContext());
                        recycler_groom.setAdapter(adapter);
                        recycler_groom.setLayoutManager(llm);
                    } catch (Exception e) {

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //dataLoadings.setVisibility(View.VISIBLE);
                }
            });
        }else
        {
            Snackbar ss=Snackbar.make(getActivity().findViewById(android.R.id.content),"No internet connection. Makesure it on",Snackbar.LENGTH_LONG)
                    .setAction("YES", new View.OnClickListener()
                            {
                                @Override
                                public void onClick(View view)
                                {
                                    startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                                }
                            }
                    );;
            ss.show();
        }
    }
    public class GroomAdapter extends RecyclerView.Adapter<GroomAdapter.PersonViewHolder>
    {
        Context context;

        public GroomAdapter(Context context)
        {
            this.context = context;
        }

        @Override
        public GroomAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.external_groom_data, parent, false);
            return new PersonViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GroomAdapter.PersonViewHolder holder, int position)
        {

            HashMap hm=(HashMap)al.get(position);
//            String name=(String)hm.get(key[1]);
//            final String cont=(String)hm.get(key[2]);
            String image=(String)hm.get(key[0]);
            byte img[]= Base64.decode(image,Base64.DEFAULT);
            Bitmap bit= BitmapFactory.decodeByteArray(img,0,img.length);

        if (!image.isEmpty()) {

            holder.image_bride.setImageBitmap(bit);
            holder.name_bride.setText("" + hm.get(key[1]));
            holder.full_name_bride.setText("" + hm.get(key[2]));
            holder.dob_bride.setText("" + hm.get(key[3]));
            holder.time_bride.setText("" + hm.get(key[5]));
            holder.star_bride.setText("" + hm.get(key[4]));
            holder.mobile_bride.setText("" + hm.get(key[8]));
            holder.height_bride.setText("" + hm.get(key[6]) + "(" + hm.get(key[7]) + ")");
            holder.study_bride.setText("" + hm.get(key[9]));
            holder.salary_bride.setText("" + hm.get(key[10]));
            holder.work_place_bride.setText("" + hm.get(key[11]));
            holder.company_name_bride.setText("" + hm.get(key[12]));
            holder.father_bride.setText("" + hm.get(key[13]));
            holder.fath_desig_bride.setText("" + hm.get(key[14]));
            holder.mother_bride.setText("" + hm.get(key[15]));
            holder.mother_desig_bride.setText("" + hm.get(key[16]));
            holder.address_bride.setText("" + hm.get(key[17]));
            holder.bros_bromrg_bride.setText("Brothers " + hm.get(key[18]) + "(" + hm.get(key[19]) + ")");
            holder.sis_sismrg_bride.setText("Sisters " + hm.get(key[20]) + "(" + hm.get(key[21]) + ")");
            holder.fmobile_bride.setText("" + hm.get(key[22]));
            holder.abt_urself_bride.setText("" + hm.get(key[23]));
            holder.abt_desc_bride.setText("" + hm.get(key[24]));
            holder.lfor_bride.setText("" + hm.get(key[25]));
            holder.lfs_bride.setText("" + hm.get(key[27]));
            holder.lfh_bride.setText("" + hm.get(key[26]));
            holder.lfc_bride.setText("" + hm.get(key[28]));
            holder.lf_job_bride.setText("" + hm.get(key[29]));
        }
        }

        @Override
        public int getItemCount()
        {
            return al.size();
        }
        class PersonViewHolder extends RecyclerView.ViewHolder
        {
            ImageView image_bride;
            TextView name_bride,full_name_bride,dob_bride,mobile_bride,star_bride,time_bride,height_bride,study_bride,
                    salary_bride,work_place_bride,company_name_bride,father_bride,fath_desig_bride,mother_bride,mother_desig_bride,
                    address_bride,bros_bromrg_bride,sis_sismrg_bride,fmobile_bride,abt_urself_bride,abt_desc_bride,lfor_bride,
                    lfh_bride,lfs_bride,lfc_bride,lf_job_bride;

            public PersonViewHolder(View item)
            {
                super(item);
                image_bride=(ImageView)item.findViewById(R.id.image_groom);
                name_bride=(TextView)item.findViewById(R.id.name_groom);
                full_name_bride=(TextView)item.findViewById(R.id.full_name_groom);
                dob_bride=(TextView)item.findViewById(R.id.dob_groom);
                mobile_bride=(TextView)item.findViewById(R.id.mobile_groom);
                star_bride=(TextView)item.findViewById(R.id.star_groom);
                time_bride=(TextView)item.findViewById(R.id.time_groom);
                study_bride=(TextView)item.findViewById(R.id.study_groom);
                height_bride=(TextView)item.findViewById(R.id.height_groom);
                salary_bride=(TextView)item.findViewById(R.id.salary_groom);
                work_place_bride=(TextView)item.findViewById(R.id.work_place_groom);
                company_name_bride=(TextView)item.findViewById(R.id.company_name_groom);
                father_bride=(TextView)item.findViewById(R.id.father_groom);
                fath_desig_bride=(TextView)item.findViewById(R.id.fath_desig_groom);
                mother_bride=(TextView)item.findViewById(R.id.mother_groom);
                mother_desig_bride=(TextView)item.findViewById(R.id.mother_desig_groom);
                address_bride=(TextView)item.findViewById(R.id.address_groom);
                bros_bromrg_bride=(TextView)item.findViewById(R.id.bros_bromrg_groom);
                sis_sismrg_bride=(TextView)item.findViewById(R.id.sis_sismrg_groom);
                fmobile_bride=(TextView)item.findViewById(R.id.fmobile_groom);
                abt_urself_bride=(TextView)item .findViewById(R.id.abt_urself_groom);
                abt_desc_bride=(TextView)item.findViewById(R.id.abt_desc_groom);
                lfor_bride=(TextView)item.findViewById(R.id.lfor_groom);
                lfh_bride=(TextView)item.findViewById(R.id.lfh_groom);
                lfs_bride=(TextView)item.findViewById(R.id.lfs_groom);
                lfc_bride=(TextView)item.findViewById(R.id.lfc_groom);
                lf_job_bride=(TextView)item.findViewById(R.id.lf_job_groom);
            }
        }
    }
}
