package com.example.sugandh.panacea1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragOrders extends Fragment {
    Button button;
    TextView textView;

    public fragOrders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_orders, container, false);
//        textView = (TextView) view.findViewById(R.id.textView05);
//
//        button = (Button) view.findViewById(R.id.button011);
//        button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//
//            }
//        });
        return view;
    }

/*

    class BackgroundTask extends AsyncTask<String,String,String>
    {
        String json_get_user_url;
        private ProgressDialog dialog = new ProgressDialog(getContext());

        @Override
        protected void onPreExecute() {
            json_get_user_url="http://utilties.netai.net/add_usp_detail.php";
            this.dialog.setMessage("Please wait");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(json_get_user_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data_string= URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream= httpURLConnection.getInputStream();
//                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//                StringBuilder stringBuilder=new StringBuilder();
//                while((json_string=bufferedReader.readLine())!=null)
//                {
//                    stringBuilder.append(json_string+"\n");
//                }
//
//                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Details Added";
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
            try {
                JSONObject jObj = new JSONObject(String.valueOf(jsonString));
                boolean error = jObj.getBoolean("error");

                if (!error) {
                    Intent i=new Intent(uspDetail2.this,homeActivity.class);
                    i.putExtra("jsonData",result);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }*/
}
