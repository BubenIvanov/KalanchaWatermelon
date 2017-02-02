package corp.watermelon.kalanchawatermelon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    public static final String Pref_Account = "myAccounts";
    public static final String Pref_Name = "name";
    public static final String Pref_email = "email";
    public static final String Pref_Pass = "pass";
    public EditText name,email,password;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

        name = (EditText) findViewById(R.id.regname);
        email=(EditText)findViewById(R.id.regemail);
        password = (EditText) findViewById(R.id.regpassword );
        register=(Button) findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences= getSharedPreferences(Pref_Account, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString(Pref_Name,name.getText().toString());
                editor.putString(Pref_email,email.getText().toString());
                editor.putString(Pref_Pass,password.getText().toString());
                editor.apply();

displayToast("User Registered!");

                Intent intent = new Intent(RegistrActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
