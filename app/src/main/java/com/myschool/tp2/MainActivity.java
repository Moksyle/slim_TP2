package com.myschool.tp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Button submitBtn;
    String userEmailValue;
    String userPasswordValue;
    TextView userName;
    String userNameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MyAccount", Context.MODE_PRIVATE);
        userNameValue = sharedPreferences.getString("nameKey", "");
        userEmailValue = sharedPreferences.getString("emailKey", "");
        userPasswordValue = sharedPreferences.getString("passwordKey", "");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    // Methode pour la creation d'un Compte
    public void createAccount(View view) {
        Button button = (Button)view;
        startActivity(new Intent(getApplicationContext(), createAccountPage.class));
    }

    public void login(View view) {
        Button button = (Button)view;
        startActivity(new Intent(getApplicationContext(), IdentificationActivity.class));
    }
}
