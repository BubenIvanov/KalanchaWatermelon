package corp.watermelon.kalanchawatermelon;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Buben Ivanov on 06.02.2017.
 */

public class FruitsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView frName;
    public TextView frMud;

    public ImageView photo;
    CardClickListener cardClickListener;

    public FruitsViewHolder(View itemView){
        super(itemView);
        frName = (TextView)itemView.findViewById(R.id.tvName);
        frMud = (TextView)itemView.findViewById(R.id.tvSurname);
        photo = (ImageView)itemView.findViewById(R.id.ivItem);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.cardClickListener.onItemClick(v,getLayoutPosition());
    }
    public void setItemClickListener(CardClickListener ic)
    {

        this.cardClickListener=ic;
    }

}
