package corp.watermelon.kalanchawatermelon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_Activity extends AppCompatActivity {
    EditText nameTxt,posTxt;
    Button updateBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);
        Intent i = getIntent();
        final String name = i.getExtras().getString("NAME");
        final String pos = i.getExtras().getString("MUD");
        final int id = i.getExtras().getInt("ID");

        updateBtn = (Button) findViewById(R.id.updateBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);
        nameTxt = (EditText) findViewById(R.id.nameEditTxt);
        posTxt = (EditText) findViewById(R.id.posEditTxt);

        nameTxt.setText(name);
        posTxt.setText(pos);

    updateBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            update(id,nameTxt.getText().toString(),posTxt.getText().toString());
        }
    });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(id);
            }
        });
    }
    private void update(int id,String newName,String newMud)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        long result=db.UPDATE(id,newName,newMud);
        if(result>0)
        {
            nameTxt.setText(newName);
            posTxt.setText(newMud);
            Snackbar.make(nameTxt,"Updated Sucesfully",Snackbar.LENGTH_SHORT).show();
        }else
        {
            Snackbar.make(nameTxt,"Unable to Update",Snackbar.LENGTH_SHORT).show();
        }
        db.close();
    }

    private void delete(int id)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        long result=db.Delete(id);
        if(result>0)
        {
            this.finish();
        }else
        {
            Snackbar.make(nameTxt,"Unable to Update",Snackbar.LENGTH_SHORT).show();
        }
        db.close();
    }
    }

