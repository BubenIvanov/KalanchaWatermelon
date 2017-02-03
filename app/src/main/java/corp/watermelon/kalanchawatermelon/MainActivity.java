package corp.watermelon.kalanchawatermelon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvMain;
    //И его адаптер
     public ArrayList<Fruits> fruits;
    FruitsAdapter fruitsAdapter;
    ArrayAdapter<String> adapter;

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Привяжем его к элементу
        rvMain = (RecyclerView)findViewById(R.id.myRecyclerView);
        //Создадим адаптер
        fruitsAdapter = new FruitsAdapter(getPersons());
        //Применим наш адаптер к RecyclerView
        rvMain.setAdapter(fruitsAdapter);
        //И установим LayoutManager
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> fruits_array=new ArrayList<>();
        for (Fruits a : fruits) {
fruits_array.add(a.name);
        }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public ArrayList<Fruits> getPersons(){
        fruits = new ArrayList<>();

        Fruits arbuz = new Fruits();
        arbuz.name = "Arbuz";
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
        fruits.add(apple12);




        return fruits;
    }





}
