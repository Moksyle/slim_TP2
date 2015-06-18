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
import android.widget.Toast;


public class createAccountPage extends ActionBarActivity {

    Button submitBtn;
    EditText name;
    EditText email;
    EditText pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_page);

        submitBtn = (Button)findViewById(R.id.submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEditText = (EditText) findViewById(R.id.act_creaccount_name);
                EditText emailEditText = (EditText) findViewById(R.id.act_creaccount_email);
                EditText pwdEditText = (EditText) findViewById(R.id.act_creaccount_password);

                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String pwd = pwdEditText.getText().toString();

                if (name.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "You did not enter a name", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "You did not enter a email", Toast.LENGTH_SHORT).show();
                }
                else if (pwd.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "You did not enter a paswword", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SharedPreferences sharedPreferences = getSharedPreferences("MyAccount", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("nameKey", name);
                    editor.putString("emailKey", email);
                    editor.putString("passwordKey", pwd);

                    editor.commit();

                    Toast.makeText(getApplicationContext(), "Your account has been created", Toast.LENGTH_SHORT).show();


                    startActivity(new Intent(getApplicationContext(), WelcomActivity.class));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_account_page, menu);
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
