package corp.watermelon.kalanchawatermelon;

/**
 * Created by Buben Ivanov on 06.02.2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FruitsAdapter extends RecyclerView.Adapter<FruitsViewHolder>{
    //Здесь мы будем хранить набор наших данных
    private ArrayList<Fruits> fruits=new ArrayList<>();

    //Простенький конструктор
    public FruitsAdapter(ArrayList<Fruits> fruits){
        this.fruits = fruits;
    }

    //Этот метод вызывается при прикреплении нового элемента к RecyclerView
    @Override
    public void onBindViewHolder(FruitsViewHolder fruitsViewHolder, int i){
        //Получаем элемент набора данных для заполнения
        Fruits currentFruits = fruits.get(i);
        //Заполняем поля viewHolder'а данными из элемента набора данных
        fruitsViewHolder.tvName.setText(currentFruits.name);
        // fruitsViewHolder.tvId.setText(currentFruits.id);
        fruitsViewHolder.tvSurname.setText(currentFruits.mud);
        fruitsViewHolder.photo.setImageResource(currentFruits.photoResId);
    }

    //Этот метод вызывается при создании нового ViewHolder'а

    @Override
    public FruitsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        //Создаём новый view при помощи LayoutInflater
        //Особенно упорные могут создать его программно с помощью view.addView
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);

        return new FruitsViewHolder(itemView);
    }

    //Этот метод возвращает количество элементов списка
    @Override
    public int getItemCount(){
        //не мудрствуя лукаво, вернём размер списка
        return fruits.size();
    }
    public void setFilter(ArrayList<Fruits> newList)
    {fruits=new ArrayList<>();
        fruits.addAll(newList);
        notifyDataSetChanged();




    }
}
