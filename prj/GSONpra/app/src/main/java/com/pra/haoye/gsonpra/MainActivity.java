package com.pra.haoye.gsonpra;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    protected Button jsonbtnobj;
    protected TextView jsontvobj;
    protected Gson gson;
    protected Context context;
    protected String jsondataobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }
    protected void findview() {
        gson = new Gson();
        jsontvobj = (TextView) findViewById(R.id.jsontv);
        jsonbtnobj = (Button) findViewById(R.id.jsonbtn);

        jsonbtnobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsondataobj = getString(R.string.jsondata);
                GSONData user = gson.fromJson( jsondataobj, GSONData.class);
                jsontvobj.setText("USER ID : " + user.getUserId() + "\n" +
                                    "Password : " + user.getPwd() + "\n" +
                                    "Book 1 : " + user.getBooklist()[0] + "\n" +
                                    "Book 2 : " + user.getBooklist()[1] + "\n" +
                                    "Book 3 : " + user.getBooklist()[2] + "\n"
                );
            }
        });

    }
}
