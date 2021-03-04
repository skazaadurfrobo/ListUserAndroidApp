package com.adda247.listuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.adda247.listuser.Adapter.RecyclerViewAdapter;
import com.adda247.listuser.Model.model;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue ;
    private List<model> lstUsers ;
    private RecyclerView recyclerView ;

    private final String JSON_URL = "https://gorest.co.in/public-api/users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Casting
        recyclerView = findViewById(R.id.user_recycler_view);
        lstUsers = new ArrayList<>() ;
        requestQueue= Volley.newRequestQueue(this);

        JsonRequest();

    }


    private void JsonRequest() {

        final KProgressHUD progressDialog = KProgressHUD.create(MainActivity.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();



        Response.Listener<String> resListener = response -> {
            try{
                JSONObject joResponse = new JSONObject(response);

                JSONArray jaChannels =joResponse.getJSONArray("data");
                for(int i=0; i<jaChannels.length(); i++){
                    try {
                        JSONObject joData = jaChannels.getJSONObject(i);
                        model list_user = new model();
                        list_user.setName(joData.getString("name"));
                        list_user.setEmail(joData.getString("email"));
                        list_user.setGender(joData.getString("gender"));
                        list_user.setStatus(joData.getString("status"));
                        lstUsers.add(list_user);


                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }

                }
                CastRecycleView(lstUsers);
                progressDialog.dismiss();


            }
            catch (Exception e){
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();

            }

        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        };

        HttpsRequest userProfileRequest=new HttpsRequest(Request.Method.GET, JSON_URL,resListener,errorListener);
        requestQueue.add(userProfileRequest);
    }

    private void CastRecycleView(List<model> lstUsers) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstUsers) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);


    }
}