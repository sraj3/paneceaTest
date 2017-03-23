package com.example.sugandh.panacea1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class search extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String jsonString;
    String json_string;
    String address;
    TextView textView;
    Spinner s2;
    String service;
    String pincode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        jsonString = getIntent().getExtras().getString("jsonData");
        Toast.makeText(getApplicationContext(), "Hello " + jsonString, Toast.LENGTH_SHORT).show();

        try {
            JSONObject jObj = new JSONObject(String.valueOf(jsonString));
            boolean error = jObj.getBoolean("error");

            if (!error) {
                String name = jObj.getString("name");
                String email = jObj.getString("email");
                Boolean detailed = jObj.getBoolean("detailed");
                if(detailed) {
                    address = jObj.getString("address");
                    pincode = jObj.getString("pincode");
                    Toast.makeText(getApplicationContext(), "detailed", Toast.LENGTH_SHORT).show();
                }
                else{
                    address="Save your address first";
                }
                setTitle(name);
                Toast.makeText(getApplicationContext(), "Hello " + name, Toast.LENGTH_SHORT).show();
            }
            else {
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textView = (TextView) findViewById(R.id.textView5);
        textView.setText(address);
        s2 = (Spinner) findViewById(R.id.spinner01);
        s2.setOnItemSelectedListener(this);
    }

    public void findUsp(View view) {
        service=String.valueOf(s2.getSelectedItem());
        new BackgroundTask().execute();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}


    class BackgroundTask extends AsyncTask<String, String, String> {
        String json_get_user_url;
        private ProgressDialog dialog = new ProgressDialog(search.this);

        @Override
        protected void onPreExecute() {
            json_get_user_url = "http://utilties.netai.net/find_usp.php";
            this.dialog.setMessage("Please wait");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(json_get_user_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data_string = URLEncoder.encode("pincode", "UTF-8") + "=" + URLEncoder.encode(pincode, "UTF-8") + "&" +
                        URLEncoder.encode("service", "UTF-8") + "=" + URLEncoder.encode(service, "UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((json_string = bufferedReader.readLine()) != null) {
                    stringBuilder.append(json_string + "\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Error Occured";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            json_string=result;
            if(json_string==null)
            {
                Toast.makeText(getApplicationContext(), "No Service Provider Available", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent=new Intent(getApplicationContext(),display_usp_list.class);
                intent.putExtra("json_data",json_string);
                startActivity(intent);
            }

        }
    }
}

