package com.example.listviewvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String JSON_URL = "https://simplifiedcoding.net/demos/view-flipper/heroes.php";
    // --Commented out by Inspection (12-08-2021 13:02):TextView txt;
    ListView listView;
    ProgressDialog progressDialog;
    List<HeroModel> heroModelList;
    ListViewAdapter adapter;

    // --Commented out by Inspection (12-08-2021 11:00):TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listview);
        heroModelList = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Log.d("myapp", JSON_URL);
        loadHerolist();

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            progressDialog.dismiss();
            adapter = new ListViewAdapter(heroModelList, getApplicationContext());
            listView.setAdapter(adapter);
        }, 9000);
    }

    public void loadHerolist() {

//
//        StringRequest request = new StringRequest(Request.Method.GET, JSON_URL,
//                response -> {
//
//                    try {
//                        JSONObject object = new JSONObject();
//                        JSONArray array = object.getJSONArray("heroes");
//                        for (int i = 0; i < array.length(); i++) {
//                            JSONObject obj = array.getJSONObject(i);
//                            HeroModel heroModel = new HeroModel(obj.getString("name"), obj.getString("imageurl"));
//                            heroModelList.add(heroModel);
//                            Log.d("myapp",obj.getString("name"));
//                            Log.d("myapp",obj.getString("imageurl"));
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }, error -> Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show());
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(request);
    }
}