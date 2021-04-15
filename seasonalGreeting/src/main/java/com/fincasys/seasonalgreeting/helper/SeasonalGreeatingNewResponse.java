package com.fincasys.seasonalgreeting.helper;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SeasonalGreeatingNewResponse implements Serializable{
    @SerializedName("seasonalGreetings")
    @Expose
    private List<SeasonalGreeting> seasonalGreetings = null;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private String status;

    public List<SeasonalGreeting> getSeasonalGreetings() {
        return seasonalGreetings;
    }

    public void setSeasonalGreetings(List<SeasonalGreeting> seasonalGreetings) {
        this.seasonalGreetings = seasonalGreetings;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public class SeasonalGreeting implements Serializable{

        @SerializedName("seasonal_greet_id")
        @Expose
        private String seasonalGreetId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image_array")
        @Expose
        private List<ImageArray> imageArray = null;

        public String getSeasonalGreetId() {
            return seasonalGreetId;
        }

        public void setSeasonalGreetId(String seasonalGreetId) {
            this.seasonalGreetId = seasonalGreetId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ImageArray> getImageArray() {
            return imageArray;
        }

        public void setImageArray(List<ImageArray> imageArray) {
            this.imageArray = imageArray;
        }


    }

    public class ImageArray implements Serializable {

        @SerializedName("seasonal_greet_image_id")
        @Expose
        private String seasonalGreetImageId;

        @SerializedName("main_title")
        @Expose
        private String main_title;

        @SerializedName("cover_image")
        @Expose
        private String coverImage;
        @SerializedName("page_alignment")
        @Expose
        private String imageAlignment;
        @SerializedName("background_image")
        @Expose
        private String backgroundImage;
        @SerializedName("title_on_image")
        @Expose
        private String titleOnImage;
        @SerializedName("title_font_color")
        @Expose
        private String titleFontColor;
        @SerializedName("title_font_name")
        @Expose
        private String titleFontName;
        @SerializedName("description_on_image")
        @Expose
        private String descriptionOnImage;
        @SerializedName("description_font_color")
        @Expose
        private String descriptionFontColor;
        @SerializedName("description_font_name")
        @Expose
        private String descriptionFontName;
        @SerializedName("show_to_name")
        @Expose
        private Boolean showToName;
        @SerializedName("to_name_font_color")
        @Expose
        private String toNameFontColor;
        @SerializedName("to_name_font_name")
        @Expose
        private String toNameFontName;
        @SerializedName("show_from_name")
        @Expose
        private Boolean showFromName;
        @SerializedName("from_name_font_color")
        @Expose
        private String fromNameFontColor;
        @SerializedName("from_name_font_name")
        @Expose
        private String fromNameFontName;
        @SerializedName("from_name_font_size")
        @Expose
        private String from_name_font_size;
        @SerializedName("logo_alignment")
        @Expose
        private String logo_alignment;
        @SerializedName("to_text_alignment")
        @Expose
        private String to_text_alignment;
        @SerializedName("from_text_alignment")
        @Expose
        private String from_text_alignment;
        @SerializedName("title_alignment")
        @Expose
        private String title_alignment;

        @SerializedName("description_alignment")
        @Expose
        private String description_alignment;

        public String getFrom_name_font_size() {
            return from_name_font_size;
        }

        public void setFrom_name_font_size(String from_name_font_size) {
            this.from_name_font_size = from_name_font_size;
        }
        public String getMain_title() {
            return main_title;
        }

        public void setMain_title(String main_title) {
            this.main_title = main_title;
        }

        public String getLogo_alignment() {
            return logo_alignment;
        }

        public void setLogo_alignment(String logo_alignment) {
            this.logo_alignment = logo_alignment;
        }

        public String getTo_text_alignment() {
            return to_text_alignment;
        }

        public void setTo_text_alignment(String to_text_alignment) {
            this.to_text_alignment = to_text_alignment;
        }

        public String getFrom_text_alignment() {
            return from_text_alignment;
        }

        public void setFrom_text_alignment(String from_text_alignment) {
            this.from_text_alignment = from_text_alignment;
        }

        public String getTitle_alignment() {
            return title_alignment;
        }

        public void setTitle_alignment(String title_alignment) {
            this.title_alignment = title_alignment;
        }

        public String getDescription_alignment() {
            return description_alignment;
        }

        public void setDescription_alignment(String description_alignment) {
            this.description_alignment = description_alignment;
        }

        public String getSeasonalGreetImageId() {
            return seasonalGreetImageId;
        }

        public void setSeasonalGreetImageId(String seasonalGreetImageId) {
            this.seasonalGreetImageId = seasonalGreetImageId;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public String getImageAlignment() {
            return imageAlignment;
        }

        public void setImageAlignment(String imageAlignment) {
            this.imageAlignment = imageAlignment;
        }

        public String getBackgroundImage() {
            return backgroundImage;
        }

        public void setBackgroundImage(String backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        public String getTitleOnImage() {
            return titleOnImage;
        }

        public void setTitleOnImage(String titleOnImage) {
            this.titleOnImage = titleOnImage;
        }

        public String getTitleFontColor() {
            return titleFontColor;
        }

        public void setTitleFontColor(String titleFontColor) {
            this.titleFontColor = titleFontColor;
        }

        public String getTitleFontName() {
            return titleFontName;
        }

        public void setTitleFontName(String titleFontName) {
            this.titleFontName = titleFontName;
        }

        public String getDescriptionOnImage() {
            return descriptionOnImage;
        }

        public void setDescriptionOnImage(String descriptionOnImage) {
            this.descriptionOnImage = descriptionOnImage;
        }

        public String getDescriptionFontColor() {
            return descriptionFontColor;
        }

        public void setDescriptionFontColor(String descriptionFontColor) {
            this.descriptionFontColor = descriptionFontColor;
        }

        public String getDescriptionFontName() {
            return descriptionFontName;
        }

        public void setDescriptionFontName(String descriptionFontName) {
            this.descriptionFontName = descriptionFontName;
        }

        public Boolean getShowToName() {
            return showToName;
        }

        public void setShowToName(Boolean showToName) {
            this.showToName = showToName;
        }

        public String getToNameFontColor() {
            return toNameFontColor;
        }

        public void setToNameFontColor(String toNameFontColor) {
            this.toNameFontColor = toNameFontColor;
        }

        public String getToNameFontName() {
            return toNameFontName;
        }

        public void setToNameFontName(String toNameFontName) {
            this.toNameFontName = toNameFontName;
        }

        public Boolean getShowFromName() {
            return showFromName;
        }

        public void setShowFromName(Boolean showFromName) {
            this.showFromName = showFromName;
        }

        public String getFromNameFontColor() {
            return fromNameFontColor;
        }

        public void setFromNameFontColor(String fromNameFontColor) {
            this.fromNameFontColor = fromNameFontColor;
        }

        public String getFromNameFontName() {
            return fromNameFontName;
        }

        public void setFromNameFontName(String fromNameFontName) {
            this.fromNameFontName = fromNameFontName;
        }

    }
}
