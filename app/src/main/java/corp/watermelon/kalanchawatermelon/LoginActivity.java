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

import static corp.watermelon.kalanchawatermelon.RegistrActivity.Pref_Account;
import static corp.watermelon.kalanchawatermelon.RegistrActivity.Pref_Name;
import static corp.watermelon.kalanchawatermelon.RegistrActivity.Pref_Pass;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,password;
    private Session session;
    public Vigenere cipher_object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name=(EditText) findViewById(R.id.user_name);
        password=(EditText) findViewById(R.id.pass);

        Button sing_in = (Button) findViewById(R.id.Sing_in);
        Button sing_up = (Button) findViewById(R.id.Sing_up);
        sing_in.setOnClickListener(this);
        sing_up.setOnClickListener(this);
        session = new Session(this);

        if( session.loggedin())
        {startActivity(new Intent(this,WelcomeActivity.class));
            finish();}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Sing_in:
                cipher_object=new Vigenere();
                SharedPreferences account = getSharedPreferences(Pref_Account, Context.MODE_PRIVATE);
                if((name.getText().toString().equals(account.getString(Pref_Name, "")))&&
                        (cipher_object.decrypt(account.getString(Pref_Pass,""),"somekeyword").equals(password.getText().toString())))
                {session.setLoggedin(true);
                    startActivity(new Intent(this, WelcomeActivity.class));
                }
                else Toast.makeText(getApplicationContext(),"Not Good user info",Toast.LENGTH_SHORT).show();
                break;

            case  R.id.Sing_up:
                startActivity(new Intent(this,RegistrActivity.class));
                break;

            default:
        }
    }
}
