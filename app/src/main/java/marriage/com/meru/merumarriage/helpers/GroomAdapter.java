package marriage.com.meru.merumarriage.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import marriage.com.meru.merumarriage.MainActivity;
import marriage.com.meru.merumarriage.R;

/**
 * Created by Velsol 170016 on 8/1/2018.
 */

//public class GroomAdapter extends RecyclerView.Adapter<GroomAdapter.PersonViewHolder>
//{
//    ArrayList al=new ArrayList();
//    ArrayList al_fullDetails=new ArrayList();
//    String key[]={"k1","k2","k3","k4","k5","k6","k7","k8","k9","k10","k11","k12","k13","k14","k15","k16","k17","k18","k19","k20","k21","k22","k23","k24","k25","k26","k27","k28","k29","k30","k31","k32","k33","k34","k35"};
//
//    @Override
//    public GroomAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
//    {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.external_groom_data, parent, false);
//        return new PersonViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(GroomAdapter.PersonViewHolder holder, int position)
//    {
//
//        HashMap hm=(HashMap)al.get(position);
////            String name=(String)hm.get(key[1]);
////            final String cont=(String)hm.get(key[2]);
//        String image=(String)hm.get(key[0]);
//        byte img[]= Base64.decode(image,Base64.DEFAULT);
//        Bitmap bit= BitmapFactory.decodeByteArray(img,0,img.length);
//    }
//
//    @Override
//    public int getItemCount()
//    {
//        return al.size();
//    }
//    class PersonViewHolder extends RecyclerView.ViewHolder
//    {
//        ImageView image_bride;
//        TextView name_bride,full_name_bride,dob_bride,mobile_bride,star_bride,time_bride,height_bride,study_bride,
//                salary_bride,work_place_bride,company_name_bride,father_bride,fath_desig_bride,mother_bride,mother_desig_bride,
//                address_bride,bros_bromrg_bride,sis_sismrg_bride,fmobile_bride,abt_urself_bride,abt_desc_bride,lfor_bride,
//                lfh_bride,lfs_bride,lfc_bride,lf_job_bride;
//
//        public PersonViewHolder(View item)
//        {
//            super(item);
//            image_bride=(ImageView)item.findViewById(R.id.image_bride);
//            name_bride=(TextView)item.findViewById(R.id.name_bride);
//            full_name_bride=(TextView)item.findViewById(R.id.full_name_bride);
//            dob_bride=(TextView)item.findViewById(R.id.dob_bride);
//            mobile_bride=(TextView)item.findViewById(R.id.mobile_bride);
//            star_bride=(TextView)item.findViewById(R.id.star_bride);
//            time_bride=(TextView)item.findViewById(R.id.time_bride);
//            study_bride=(TextView)item.findViewById(R.id.study_bride);
//            height_bride=(TextView)item.findViewById(R.id.height_bride);
//            salary_bride=(TextView)item.findViewById(R.id.salary_bride);
//            work_place_bride=(TextView)item.findViewById(R.id.work_place_bride);
//            company_name_bride=(TextView)item.findViewById(R.id.company_name_bride);
//            father_bride=(TextView)item.findViewById(R.id.father_bride);
//            fath_desig_bride=(TextView)item.findViewById(R.id.fath_desig_bride);
//            mother_bride=(TextView)item.findViewById(R.id.mother_bride);
//            mother_desig_bride=(TextView)item.findViewById(R.id.mother_desig_bride);
//            address_bride=(TextView)item.findViewById(R.id.address_bride);
//            bros_bromrg_bride=(TextView)item.findViewById(R.id.bros_bromrg_bride);
//            sis_sismrg_bride=(TextView)item.findViewById(R.id.sis_sismrg_bride);
//            fmobile_bride=(TextView)item.findViewById(R.id.fmobile_bride);
//            abt_urself_bride=(TextView)item .findViewById(R.id.abt_urself_bride);
//            abt_desc_bride=(TextView)item.findViewById(R.id.abt_desc_bride);
//            lfor_bride=(TextView)item.findViewById(R.id.lfor_bride);
//            lfh_bride=(TextView)item.findViewById(R.id.lfh_bride);
//            lfs_bride=(TextView)item.findViewById(R.id.lfs_bride);
//            lfc_bride=(TextView)item.findViewById(R.id.lfc_bride);
//            lf_job_bride=(TextView)item.findViewById(R.id.lf_job_bride);
//        }
//    }
//}
