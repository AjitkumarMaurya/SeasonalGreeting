package com.fincasys.seasonalgreeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.fincasys.seasonalgreeting.activity.ListOfGreetingsActivity;
import com.fincasys.seasonalgreeting.helper.SeasonalGreeatingNewResponse;
import com.fincasys.seasonalgreeting.network.RestCall;
import com.fincasys.seasonalgreeting.network.RestClient;

import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    public RestCall callCommonUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callCommonUrl = RestClient.createService(RestCall.class, "https://master.myassociation.app/commonApi/", "bmsapikey");

        GetSeasonalGreeting();

    }


    public void GetSeasonalGreeting(){
        callCommonUrl.GetNewGreetings("getSeasonalGreetings","289")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<SeasonalGreeatingNewResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast.makeText(MainActivity.this, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onNext(SeasonalGreeatingNewResponse seasonalGreeatingNewResponse) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (seasonalGreeatingNewResponse.getStatus().equalsIgnoreCase("200")){

                                    if (seasonalGreeatingNewResponse.getSeasonalGreetings()!=null && seasonalGreeatingNewResponse.getSeasonalGreetings().size()>0){

                                        Bundle bundle= new Bundle();
                                        bundle.putSerializable("seasonalGreeatingNewResponse",seasonalGreeatingNewResponse);
                                        Intent intent = new Intent(MainActivity.this, ListOfGreetingsActivity.class);
                                        intent.putExtras(bundle);
                                        intent.putExtra("userName","Ajiy");
                                        intent.putExtra("companyName","mayfd");
                                        intent.putExtra("companyLogo","https://www.fincasys.com/images/logo.png");
                                        startActivity(intent);

                                    }
                                }
                            }
                        });
                    }
                });
    }

}