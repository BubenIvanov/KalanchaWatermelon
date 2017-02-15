package corp.watermelon.kalanchawatermelon;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    RecyclerView rvMain;

    public ArrayList<Fruits> fruits;
    FruitsAdapter fruitsAdapter;
    EditText nameTxt,posTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        rvMain = (RecyclerView)findViewById(R.id.myRecyclerView);

        fruitsAdapter = new FruitsAdapter(this,getPersons());

        rvMain.setAdapter(fruitsAdapter);

        rvMain.setLayoutManager(new LinearLayoutManager(this));






        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

       getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return  true;
    }

    private void showDialog()
    {
        Dialog d=new Dialog(this);

        d.requestWindowFeature(Window.FEATURE_NO_TITLE);

        d.setContentView(R.layout.custom_layout);
        nameTxt= (EditText) d.findViewById(R.id.nameEditTxt);
        posTxt= (EditText) d.findViewById(R.id.posEditTxt);
        Button savebtn= (Button) d.findViewById(R.id.saveBtn);
        Button retrieveBtn= (Button) d.findViewById(R.id.retrieveBtn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(nameTxt.getText().toString(),posTxt.getText().toString());
            }
        });
        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieve();
            }
        });

        d.show();
    }

    private void save(String name,String pos)
    {
        DBAdapter db=new DBAdapter(this);

        db.openDB();

        long result=db.add(name,pos);
        if(result>0)
        {
            nameTxt.setText("");
            posTxt.setText("");
        }else
        {
            Snackbar.make(nameTxt,"Unable To Insert",Snackbar.LENGTH_SHORT).show();
        }

        db.close();

        retrieve();
    }
    private void retrieve()
    {
        DBAdapter db=new DBAdapter(this);

        db.openDB();
        fruits.clear();

        Cursor c=db.getAllFruits();

        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);
            String mud=c.getString(2);

            Fruits p=new Fruits(id,name,mud,R.drawable.watermelon1);

            fruits.add(p);
        }

        if(!(fruits.size()<1))
        {
            rvMain.setAdapter(fruitsAdapter);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        retrieve();
    }



    public ArrayList<Fruits> getPersons(){
        fruits = new ArrayList<>();

        Fruits arbuz = new Fruits(6,"Arbuz","Cutted",R.drawable.watermelon1);
        fruits.add(arbuz);
       /* arbuz.name = ;
        arbuz.mud = "Cutted";
        arbuz.photoResId = R.drawable.watermelon1;
        fruits.add(arbuz);


        Fruits uporot_arbuz = new Fruits();
        uporot_arbuz.name = "Arbuz";
        uporot_arbuz.mud = "Uporot";
        uporot_arbuz.photoResId = R.drawable.nepon_arbuz;
        fruits.add(uporot_arbuz);

        Fruits smile_arbuz = new Fruits();
        smile_arbuz.name = "Arbuz";
        smile_arbuz.mud = "Smile";
        smile_arbuz.photoResId = R.drawable.smile_arbuz;
        fruits.add(smile_arbuz);

        Fruits zloy_arbuz = new Fruits();
        zloy_arbuz.name = "Arbuz";
        zloy_arbuz.mud = "Angry";
        zloy_arbuz.photoResId = R.drawable.zloy_arb;
        fruits.add(zloy_arbuz);

        Fruits angry_apple = new Fruits();
        angry_apple.name = "Apple";
        angry_apple.mud = "Angry";
        angry_apple.photoResId = R.drawable.angry_apple;
        fruits.add(angry_apple);

        Fruits angry_carrot = new Fruits();
        angry_carrot.name = "Carrot";
        angry_carrot.mud = "Angry";
        angry_carrot.photoResId = R.drawable.angry_carrot;
        fruits.add(angry_carrot);

        Fruits pineapple_angry = new Fruits();
        pineapple_angry.name = "Pineapple";
        pineapple_angry.mud = "Angry";
        pineapple_angry.photoResId = R.drawable.pineapple_angry;
        fruits.add(pineapple_angry);

        Fruits apple12 = new Fruits();
        apple12.name = "Apple";
        apple12.mud = "Not angry";
        apple12.photoResId = R.drawable.apple12;
        fruits.add(apple12);*/




        return fruits;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Fruits> newList=new ArrayList<>();
        for(Fruits a: fruits)
        {
            String name=a.name.toLowerCase();
            if (name.contains(newText))
                newList.add(a);


        }
fruitsAdapter.setFilter(newList);
        return true;
    }


}
