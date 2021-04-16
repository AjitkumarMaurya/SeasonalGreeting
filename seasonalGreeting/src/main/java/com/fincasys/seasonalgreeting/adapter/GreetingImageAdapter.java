package com.fincasys.seasonalgreeting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.fincasys.seasonalgreeting.R;
import com.fincasys.seasonalgreeting.helper.GlideImageLoader;
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
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .priority(Priority.HIGH);
            new GlideImageLoader(holder.img_greeating,
                    holder.ps_load).load(imageArrays.get(position).getCoverImage(), options);
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
        ProgressBar ps_load;

        public GreetingImageViewHolder(@NonNull View itemView) {
            super(itemView);
            img_greeating = itemView.findViewById(R.id.img_greeating);
            ps_load = itemView.findViewById(R.id.ps_load);
        }
    }
}
