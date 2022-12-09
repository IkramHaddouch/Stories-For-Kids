package com.example.registerlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;



import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity9 extends AppCompatActivity {
    private final String JSON_URL = "http://192.168.43.137/login/getHistoire7.php";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Histoire> lstHistoire ;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        lstHistoire = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Histoire histoire = new Histoire() ;
                        histoire.setName(jsonObject.getString("nom"));
                        histoire.setDescription(jsonObject.getString("descrip"));
                        histoire.setRating(jsonObject.getString("rating"));
                        histoire.setCategorie(jsonObject.getString("categorie"));
                        histoire.setAuteur(jsonObject.getString("auteur"));
                        histoire.setImage(jsonObject.getString("images"));
                        lstHistoire.add(histoire);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstHistoire);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity9.this);
        requestQueue.add(request) ;


    }
    private void setuprecyclerview(List<Histoire> lstHistoire) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstHistoire) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}