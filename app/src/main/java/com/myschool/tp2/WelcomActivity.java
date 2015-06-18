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
import android.widget.TextView;
import android.widget.Toast;


public class WelcomActivity extends ActionBarActivity {

    TextView userName;
    String userNameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);

        // Recuper le nom de l'utilisateur et l'affiche
        SharedPreferences sharedPreferences = getSharedPreferences("MyAccount", Context.MODE_PRIVATE);
        userNameValue = sharedPreferences.getString("nameKey", "");

        userName = (TextView)findViewById(R.id.user);
        userName.setText(userNameValue);

    }

    // Efface les CURRENT_LOGIN
    public void deletePreferences(View view) {
        SharedPreferences preferences = getSharedPreferences("MyAccount", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

        Toast.makeText(getApplicationContext(), "The preferences were deleted", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcom, menu);
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
