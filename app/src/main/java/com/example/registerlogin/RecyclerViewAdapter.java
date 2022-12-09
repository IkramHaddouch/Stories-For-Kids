package com.example.registerlogin;


import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Histoire> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Histoire> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.histoire_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, HistoireActivity.class);
                i.putExtra("histoire_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("histoire_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("histoire_auteur",mData.get(viewHolder.getAdapterPosition()).getAuteur());
                i.putExtra("histoire_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("histoire_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("histoire_img",mData.get(viewHolder.getAdapterPosition()).getImage());

                mContext.startActivity(i);

            }


        });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_auteur.setText(mData.get(position).getAuteur());
        holder.tv_category.setText(mData.get(position).getCategorie());

        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(holder.img_thumbnail);




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name ;
        TextView tv_rating ;
        TextView tv_auteur ;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.histoire_name);
            tv_category = itemView.findViewById(R.id.categorie);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_auteur = itemView.findViewById(R.id.auteur);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}
