package com.example.sugandh.panacea1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_usp_list extends AppCompatActivity {
        String json_string;
        JSONObject jsonObject;
        JSONArray jsonArray;
    selectUspAdapter uspAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_usp_list);
        listView= (ListView) findViewById(R.id.listview);
        uspAdapter=new selectUspAdapter(this,R.layout.usp_row_layout);
        listView.setAdapter(uspAdapter);
        json_string=getIntent().getExtras().getString("json_data");

        try {
            jsonObject=new JSONObject(json_string);
            jsonArray=jsonObject.getJSONArray("server_response");
            String name,email,password,address,service,pincode,experience;

            int count=0;
            while(count<jsonArray.length())
            {
                JSONObject jo=jsonArray.getJSONObject(count);
                name=jo.getString("name");
                email=jo.getString("email");
                address=jo.getString("address");
                service=jo.getString("service");
                pincode=jo.getString("pincode");

                selectUsp usp=new selectUsp(name,email,address,service,pincode);
                uspAdapter.add(usp);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
