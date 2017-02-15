package corp.watermelon.kalanchawatermelon;

/**
 * Created by Buben Ivanov on 06.02.2017.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FruitsAdapter extends RecyclerView.Adapter<FruitsViewHolder>{
Context c;
    private ArrayList<Fruits> fruits=new ArrayList<>();

    public FruitsAdapter(Context ctx,ArrayList<Fruits> fruits){
        this.c=ctx;
        this.fruits = fruits;
    }

    @Override
    public void onBindViewHolder(FruitsViewHolder fruitsViewHolder, int i){

        Fruits currentFruits = fruits.get(i);

        fruitsViewHolder.frName.setText(currentFruits.name);

        fruitsViewHolder.frMud.setText(currentFruits.mud);
        fruitsViewHolder.photo.setImageResource(currentFruits.photoResId);

        fruitsViewHolder.setItemClickListener(new CardClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                Intent i=new Intent(c,Edit_Activity.class);

                i.putExtra("NAME",fruits.get(pos).getName());
                i.putExtra("MUD",fruits.get(pos).getMud());
                i.putExtra("ID",fruits.get(pos).getId());

                c.startActivity(i);
            }
        });


    }



    @Override
    public FruitsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        return new FruitsViewHolder(itemView);
    }

    @Override
    public int getItemCount(){

        return fruits.size();
    }

    public void setFilter(ArrayList<Fruits> newList)
    {
        fruits=new ArrayList<>();
        fruits.addAll(newList);
        notifyDataSetChanged();
    }
}
