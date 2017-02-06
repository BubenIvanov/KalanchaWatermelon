package corp.watermelon.kalanchawatermelon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences preferences;
    public static final String Pref_Account = "myAccounts";
    public static final String Pref_Name = "name";
    public static final String Pref_Pass = "pass";
    public EditText name, confirm_password,password;
    Button register;
    TextView backToLog;
   public Vigenere cipher_object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

        name=(EditText) findViewById(R.id.regname);
        confirm_password =(EditText)findViewById(R.id.confirm_password);
        password=(EditText) findViewById(R.id.regpassword );
        register=(Button) findViewById(R.id.register);
        backToLog=(TextView) findViewById(R.id.backtolog);
        register.setOnClickListener(this);
        backToLog.setOnClickListener(this);
}

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View a) {
        switch (a.getId()){
            case R.id.register:
                if(!password.getText().toString().equals(confirm_password.getText().toString()))
            { displayToast("password don't confirmed");
                break;}
                else
                {cipher_object=new Vigenere();
                preferences= getSharedPreferences(Pref_Account, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString(Pref_Name,name.getText().toString());
                editor.putString(Pref_Pass,cipher_object.encrypt(password.getText().toString(),"somekeyword"));
                editor.apply();
                displayToast("User Registered!");
                startActivity(new Intent(this,LoginActivity.class));
                finish();}
                break;

            case  R.id.backtolog:
                startActivity(new Intent(this,LoginActivity.class));
                break;

            default:
        }
    }
}
