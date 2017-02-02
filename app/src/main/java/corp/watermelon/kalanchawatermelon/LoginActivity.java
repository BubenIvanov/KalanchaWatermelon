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
    private Button Sing_in,Sing_up;
    EditText name,password;
    private SharedPreferences account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name=(EditText) findViewById(R.id.user_name);
        password=(EditText) findViewById(R.id.pass);

        Sing_in = (Button) findViewById(R.id.Sing_in);
        Sing_up = (Button) findViewById(R.id.Sing_up);
        Sing_in.setOnClickListener(this);
        Sing_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Sing_in:
                account = getSharedPreferences(Pref_Account, Context.MODE_PRIVATE);
                if((name.getText().toString().equals(account.getString(Pref_Name, "")))&&
                        (password.getText().toString().equals(account.getString(Pref_Pass,""))))
                {
                    Intent welcome = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(welcome);
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
