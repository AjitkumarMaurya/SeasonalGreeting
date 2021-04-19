package com.fincasys.seasonalgreeting.helper;

import android.content.Context;
import android.content.Intent;

import com.fincasys.seasonalgreeting.activity.ListOfGreetingsActivity;

public class SeasonalGreetingBuilder {

    private final Context context;
    private static SeasonalGreeatingNewResponse seasonalGreeatingNewResponse;
    private static String titleText;
    private static String userName;
    private static String companyName;
    private static String companyLogo;
    private static String shareBtnText;
    private static float txtSize;
    private static String txtColor;
    private static String toolBarColor;


    public Context getContext() {
        return context;
    }

    public void start() {
        context.startActivity(new Intent(context, ListOfGreetingsActivity.class));
    }

    public static class Builder {

        private SeasonalGreeatingNewResponse seasonalGreeatingNewResponse = null;
        private String titleText = null;
        private String userName = null;
        private String companyName = null;
        private String companyLogo = null;
        private String shareBtnText = null;
        private String txtColor = "#000000";
        private String toolBarColor = "#cccccc";
        private float txtSize = 10f;
        private Context c = null;

        public Builder setSeasonalResponse(SeasonalGreeatingNewResponse seasonalGreeatingNewResponse) {
            this.seasonalGreeatingNewResponse = seasonalGreeatingNewResponse;
            return this;
        }

        public Builder titleText(String titleText) {
            this.titleText = titleText;
            return this;
        }

        public Builder companyLogo(String companyLogo) {
            this.companyLogo = companyLogo;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder shareBtnText(String shareBtnText) {
            this.shareBtnText = shareBtnText;
            return this;
        }

        public Builder txtColor(String txtColor) {
            this.txtColor = txtColor;
            return this;
        }

        public Builder txtSize(float txtSize) {
            this.txtSize = txtSize;
            return this;
        }

        public Builder toolBarColor(String toolBarColor) {
            this.toolBarColor = toolBarColor;
            return this;
        }

        public Builder(Context c) {
            this.c = c;
        }


        //return fully build object
        public SeasonalGreetingBuilder build() {
            return new SeasonalGreetingBuilder(this);

        }
    }

    //private constructor to enforce object creation through builder
    public SeasonalGreetingBuilder(Builder builder) {
        this.context = builder.c;
        titleText = builder.titleText;
        userName = builder.userName;
        companyName = builder.companyName;
        companyLogo = builder.companyLogo;
        shareBtnText = builder.shareBtnText;
        txtSize = builder.txtSize;
        txtColor = builder.txtColor;
        toolBarColor = builder.toolBarColor;
        seasonalGreeatingNewResponse = builder.seasonalGreeatingNewResponse;
    }

    public static SeasonalGreeatingNewResponse getSeasonalGreeatingNewResponse() {
        return seasonalGreeatingNewResponse;
    }

    public static String getTxtColor() {
        return txtColor;
    }

    public static String getShareBtnText() {
        return shareBtnText;
    }

    public static String getTitleText() {
        return titleText;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static String getCompanyLogo() {
        return companyLogo;
    }

    public static float getTxtSize() {
        return txtSize;
    }

    public static String getToolBarColor() {
        return toolBarColor;
    }
}
