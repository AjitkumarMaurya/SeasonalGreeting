package com.fincasys.seasonalgreeting.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.fincasys.seasonalgreeting.R;
import com.fincasys.seasonalgreeting.helper.SeasonalGreeatingNewResponse;
import com.fincasys.seasonalgreeting.helper.SeasonalGreetingBuilder;
import com.fincasys.seasonalgreeting.views.CustomTextView;

import java.util.List;


public class ListMainGreetingAdapter extends RecyclerView.Adapter<ListMainGreetingAdapter.MainGreetingViewHolder> {
    Context context;
    List<SeasonalGreeatingNewResponse.SeasonalGreeting> seasonalGreetings;

    MainGreetingClick mainGreetingClick;

    public ListMainGreetingAdapter(Context context, List<SeasonalGreeatingNewResponse.SeasonalGreeting> seasonalGreetings) {
        this.context = context;
        this.seasonalGreetings=seasonalGreetings;
    }

    @NonNull
    @Override
    public MainGreetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainGreetingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_greeting_list,parent,false));
    }

    public interface MainGreetingClick{
        public void MainClick(int pos, SeasonalGreeatingNewResponse.ImageArray imageArrays);
    }

    public void SetUpInterface(MainGreetingClick mainGreetingClick){
        this.mainGreetingClick=mainGreetingClick;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MainGreetingViewHolder holder, int position) {

        holder.txt_event_name.setTextColor(Color.parseColor(SeasonalGreetingBuilder.getTxtColor()));
        holder.txt_event_name.setTextSize(SeasonalGreetingBuilder.getTxtSize());
        holder.txt_event_name.setText(""+seasonalGreetings.get(position).getTitle());
       // holder.list_greetings.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.list_greetings.setLayoutManager(new GridLayoutManager(context,3));
        GreetingImageAdapter greetingImageAdapter=new GreetingImageAdapter(context,seasonalGreetings.get(position).getImageArray());
        holder.list_greetings.setAdapter(greetingImageAdapter);

        greetingImageAdapter.SetUpInterface(new GreetingImageAdapter.ImageClick() {
            @Override
            public void GreeatingImageClick(int pos) {
                mainGreetingClick.MainClick(pos,seasonalGreetings.get(position).getImageArray().get(pos));
            }
        });

    }
    @Override
    public int getItemCount() {
        return seasonalGreetings.size();
    }

    public class  MainGreetingViewHolder extends RecyclerView.ViewHolder{

        CustomTextView txt_event_name;

        RecyclerView list_greetings;

        public MainGreetingViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_event_name = itemView.findViewById(R.id.txt_event_name);
            list_greetings = itemView.findViewById(R.id.List_greetings);
        }
    }
}

