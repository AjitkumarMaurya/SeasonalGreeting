package com.fincasys.seasonalgreeting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fincasys.seasonalgreeting.R;
import com.fincasys.seasonalgreeting.helper.OnSingleClickListener;
import com.fincasys.seasonalgreeting.helper.SeasonalGreeatingNewResponse;

import java.util.List;

public class GreetingImageAdapter extends RecyclerView.Adapter<GreetingImageAdapter.GreetingImageViewHolder> {

    Context context;
    ImageClick imageClick;
    List<SeasonalGreeatingNewResponse.ImageArray> imageArrays;

    public GreetingImageAdapter(Context context, List<SeasonalGreeatingNewResponse.ImageArray> imageArray) {
        this.context=context;
        this.imageArrays=imageArray;
    }

    interface ImageClick{
        public void GreeatingImageClick(int pos);
    }

    public void SetUpInterface(ImageClick imageClick){
        this.imageClick=imageClick;
    }

    @NonNull
    @Override
    public GreetingImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GreetingImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_greeating_image,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GreetingImageViewHolder holder, int position) {

        try {
            Glide.with(context).load(imageArrays.get(position).getCoverImage())
                    .into(holder.img_greeating);
        } catch (Exception e) {
            e.printStackTrace();

        }

        holder.itemView.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                imageClick.GreeatingImageClick(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return imageArrays.size();
    }

    public class GreetingImageViewHolder extends RecyclerView.ViewHolder{

        ImageView img_greeating;

        public GreetingImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img_greeating = itemView.findViewById(R.id.img_greeating);
        }
    }
}
