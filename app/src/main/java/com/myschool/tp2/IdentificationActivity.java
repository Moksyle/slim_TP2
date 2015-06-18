package com.myschool.tp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class IdentificationActivity extends ActionBarActivity {

    String userEmailValue;
    String userPasswordValue;
    Button identificationBtn;
    EditText email;
    EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        SharedPreferences sharedPreferences = getSharedPreferences("MyAccount", Context.MODE_PRIVATE);
        userEmailValue = sharedPreferences.getString("emailKey", "");
        userPasswordValue = sharedPreferences.getString("passwordKey", "");

        identificationBtn = (Button)findViewById(R.id.act_ident_btn);

        identificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText identEmail = (EditText)findViewById(R.id.act_ident_email);
                EditText identPwd = (EditText)findViewById(R.id.act_ident_pwd);

                String email = identEmail.getText().toString();
                String pwd = identPwd.getText().toString();

                if (userEmailValue.equals(email) && userPasswordValue.equals(pwd))
                {
                    startActivity(new Intent(getApplicationContext(), WelcomActivity.class));
                }
                else
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(getApplicationContext(), "l’email ou le mot de passe sont incorrects !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_identification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
