package com.fincasys.seasonalgreeting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fincasys.seasonalgreeting.R;
import com.fincasys.seasonalgreeting.adapter.ListMainGreetingAdapter;
import com.fincasys.seasonalgreeting.helper.SeasonalGreeatingNewResponse;
import com.fincasys.seasonalgreeting.helper.SeasonalGreetingBuilder;
import com.fincasys.seasonalgreeting.views.CustomTextView;

import butterknife.ButterKnife;

public class ListOfGreetingsActivity extends AppCompatActivity {

    RecyclerView MainList;

    RelativeLayout relativeNoDataFound;

    CustomTextView tv_title;

    ImageView ivBack;

    ListMainGreetingAdapter listMainGreetingAdapter;

    SeasonalGreeatingNewResponse seasonalGreeatingNewResponse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_greetings);
        ButterKnife.bind(this);

        MainList = findViewById(R.id.MainList);
        relativeNoDataFound = findViewById(R.id.relativeNoDataFound);
        ivBack = findViewById(R.id.ivBack);
        tv_title = findViewById(R.id.tv_title);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MainList.setLayoutManager(linearLayoutManager);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


        tv_title.setTextWithMarquee(SeasonalGreetingBuilder.getTitleText()+"");
        seasonalGreeatingNewResponse = SeasonalGreetingBuilder.getSeasonalGreeatingNewResponse();


        if (seasonalGreeatingNewResponse.getSeasonalGreetings() != null && seasonalGreeatingNewResponse.getSeasonalGreetings().size() > 0) {
            MainList.setVisibility(View.VISIBLE);
            relativeNoDataFound.setVisibility(View.GONE);
            listMainGreetingAdapter = new ListMainGreetingAdapter(ListOfGreetingsActivity.this, seasonalGreeatingNewResponse.getSeasonalGreetings());
            MainList.setAdapter(listMainGreetingAdapter);

            listMainGreetingAdapter.SetUpInterface(new ListMainGreetingAdapter.MainGreetingClick() {
                @Override
                public void MainClick(int pos, SeasonalGreeatingNewResponse.ImageArray imageArray) {
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(ListOfGreetingsActivity.this, CreateShareGreetingActivity.class);
                    bundle.putInt("pos", pos);
                    bundle.putSerializable("ImageArray", imageArray);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
        else {
            MainList.setVisibility(View.GONE);
            relativeNoDataFound.setVisibility(View.VISIBLE);
        }

    }


}