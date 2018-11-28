package mx.edu.itsur.tototlan.tototlan.TestViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import mx.edu.itsur.tototlan.tototlan.ItemClickListener;
import mx.edu.itsur.tototlan.tototlan.R;

public class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView exam_name;
    public ImageView exam_image;

    private ItemClickListener itemClickListener;

    public TestViewHolder(@NonNull View itemView) {
        super(itemView);
        exam_name = (TextView) itemView.findViewById(R.id.exam_name);
        exam_image = (ImageView) itemView.findViewById(R.id.exam_image);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
