package marriage.com.meru.merumarriage.helpers;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.iid.zzd;

/**
 * Created by Velsol 170016 on 8/2/2018.
 */

public class MyFbInstanceId extends FirebaseInstanceIdService
{
 public static String refreshedToken;
    @Override
    public void onTokenRefresh()
    {
        super.onTokenRefresh();
         refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("fb token", "Refreshed token: " + refreshedToken);
    }
}
