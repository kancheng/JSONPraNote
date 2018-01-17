package com.pra.haoye.jsonpra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.*;

public class MainActivity extends AppCompatActivity {
    protected Button jsonbtnobj;
    protected TextView jsontvobj;
    protected String strobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            findViews();
    }

    protected void findViews() {
        jsonbtnobj = (Button) findViewById(R.id.jsonbtn);
        jsontvobj = (TextView) findViewById(R.id.jsontv);

        strobj = getString(R.string.jsondata);


        jsonbtnobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonobj = null;
                try {
                    jsonobj = new JSONObject(strobj);
                    jsontvobj.setText("USER ID : " + jsonobj.getString("userId") + "\n"
                            + "Password : " + jsonobj.get("pwd") + "\n"
                            + "Book 1 : " + jsonobj.getJSONArray("booklist").getString(0) + "\n"
                            + "Book 2 : " + jsonobj.getJSONArray("booklist").getString(1) + "\n"
                            + "Book 3 : " + jsonobj.getJSONArray("booklist").getString(2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
