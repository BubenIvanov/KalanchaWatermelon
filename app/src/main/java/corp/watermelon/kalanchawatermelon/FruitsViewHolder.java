package corp.watermelon.kalanchawatermelon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Buben Ivanov on 02.02.2017.
 */

public class FruitsViewHolder extends RecyclerView.ViewHolder {
    //объявим поля, созданные в файле интерфейса itemView.xml
    public TextView tvName;
    public TextView tvSurname;
    public TextView tvId;
    public ImageView photo;

    //объявляем конструктор
    public FruitsViewHolder(View itemView){
        super(itemView);
        //привязываем элементы к полям
        tvName = (TextView)itemView.findViewById(R.id.tvName);
        tvSurname = (TextView)itemView.findViewById(R.id.tvSurname);
        // tvId = (TextView)itemView.findViewById(R.id.tvId);
        photo = (ImageView)itemView.findViewById(R.id.ivItem);
    }
}
