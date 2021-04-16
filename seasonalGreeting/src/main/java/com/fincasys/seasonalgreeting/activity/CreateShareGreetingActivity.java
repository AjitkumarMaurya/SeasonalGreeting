package com.fincasys.seasonalgreeting.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.fincasys.seasonalgreeting.R;
import com.fincasys.seasonalgreeting.askPermission.PermissionHandler;
import com.fincasys.seasonalgreeting.askPermission.Permissions;
import com.fincasys.seasonalgreeting.helper.FileUtils;
import com.fincasys.seasonalgreeting.helper.GlideImageLoader;
import com.fincasys.seasonalgreeting.helper.OnSingleClickListener;
import com.fincasys.seasonalgreeting.helper.SeasonalGreeatingNewResponse;
import com.fincasys.seasonalgreeting.helper.SeasonalGreetingBuilder;
import com.fincasys.seasonalgreeting.views.CustomButton;
import com.fincasys.seasonalgreeting.views.CustomTextView;
import com.github.angads25.toggle.interfaces.OnToggledListener;
import com.github.angads25.toggle.model.ToggleableView;
import com.github.angads25.toggle.widget.LabeledSwitch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CreateShareGreetingActivity extends AppCompatActivity {

    LinearLayout linLayMain;
    CustomTextView tvTitle;
    ImageView img_backgrund;
    ProgressBar ps_load;
    RelativeLayout rel_img_background;
    CustomButton btnShare;
    //--left text side
    LinearLayout lyt_left_logo;
    LinearLayout lyt_left_text;
    CardView card_left_logo;
    ImageView img_left_companyLogo;
    LinearLayout lyt_to_left;
    CustomTextView txt_left_to_name;
    CustomTextView txt_left_title;
    CustomTextView txt_left_desc;
    LinearLayout lyt_from_left;
    CustomTextView txt_left_from_user_name;
    CustomTextView txt_left_from_company_name;
    //--- Right side text
    LinearLayout lyt_right_logo;
    LinearLayout lyt_right_text;
    CardView card_right_logo;
    ImageView img_right_companyLogo;
    LinearLayout lyt_to_right;
    CustomTextView txt_right_to_name;
    CustomTextView txt_right_title;
    CustomTextView txt_right_desc;
    LinearLayout lyt_from_right;
    CustomTextView txt_right_from_user_name;
    CustomTextView txt_right_from_company_name;
    //-- Top Side
    LinearLayout lyt_main_top;
    CustomTextView txt_top_desc;
    CustomTextView txt_top_titile;
    CardView card_top_logo;
    ImageView img_top_logo;
    CustomTextView txt_top_bottom_from_user_name;
    CustomTextView txt_top_bottom_from_company_name;
    CustomTextView top_top_from_user_name;
    CustomTextView top_top_from_company_name;
    RadioGroup select_radio_from_type;
    RadioButton select_userName;
    RadioButton select_userName_company;
    RadioButton select_compnay_name;
    LinearLayout lyt_edit_company_logo;
    ImageView visible_logo, ivShareCard, ivBack, ivHome;
    LabeledSwitch switchshowLogo;
    Bitmap resultBitmap;
    Uri contentUri;
    String TEXT_SIDE = "left";
    SeasonalGreeatingNewResponse.ImageArray imageArray;

    String UserFullName = "", UserCompanyName = "", companyLogo = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_share_greeting);

        linLayMain = findViewById(R.id.linLayMain);
        tvTitle = findViewById(R.id.tvTitle);
        switchshowLogo = findViewById(R.id.switchshowLogo);
        visible_logo = findViewById(R.id.visible_logo);
        lyt_edit_company_logo = findViewById(R.id.lyt_edit_company_logo);
        select_compnay_name = findViewById(R.id.select_compnay_name);
        select_userName_company = findViewById(R.id.select_userName_company);
        select_userName = findViewById(R.id.select_userName);
        select_radio_from_type = findViewById(R.id.select_radio_from_type);
        top_top_from_company_name = findViewById(R.id.top_top_from_company_name);
        top_top_from_user_name = findViewById(R.id.top_top_from_user_name);
        txt_top_bottom_from_company_name = findViewById(R.id.txt_top_bottom_from_company_name);
        txt_top_bottom_from_user_name = findViewById(R.id.txt_top_bottom_from_user_name);
        img_top_logo = findViewById(R.id.img_top_logo);
        card_top_logo = findViewById(R.id.card_top_logo);
        txt_top_titile = findViewById(R.id.txt_top_titile);
        txt_top_desc = findViewById(R.id.txt_top_desc);
        lyt_main_top = findViewById(R.id.lyt_main_top);
        txt_right_from_company_name = findViewById(R.id.txt_right_from_company_name);
        txt_right_from_user_name = findViewById(R.id.txt_right_from_user_name);
        lyt_from_right = findViewById(R.id.lyt_from_right);
        txt_right_desc = findViewById(R.id.txt_right_desc);
        txt_right_title = findViewById(R.id.txt_right_title);
        txt_right_to_name = findViewById(R.id.txt_right_to_name);
        lyt_to_right = findViewById(R.id.lyt_to_right);
        img_right_companyLogo = findViewById(R.id.img_right_companyLogo);
        card_right_logo = findViewById(R.id.card_right_logo);
        lyt_right_text = findViewById(R.id.lyt_right_text);
        lyt_right_logo = findViewById(R.id.lyt_right_logo);
        txt_left_from_company_name = findViewById(R.id.txt_left_from_company_name);
        txt_left_from_user_name = findViewById(R.id.txt_left_from_user_name);
        lyt_from_left = findViewById(R.id.lyt_from_left);
        txt_left_desc = findViewById(R.id.txt_left_desc);
        txt_left_title = findViewById(R.id.txt_left_title);
        txt_left_to_name = findViewById(R.id.txt_left_to_name);
        lyt_to_left = findViewById(R.id.lyt_to_left);
        img_left_companyLogo = findViewById(R.id.img_left_companyLogo);
        card_left_logo = findViewById(R.id.card_left_logo);
        lyt_left_text = findViewById(R.id.lyt_left_text);
        lyt_left_logo = findViewById(R.id.lyt_left_logo);
        btnShare = findViewById(R.id.btnShare);
        img_backgrund = findViewById(R.id.img_backgrund);
        ps_load = findViewById(R.id.ps_load);
        rel_img_background = findViewById(R.id.rel_img_background);
        ivShareCard = findViewById(R.id.ivShareCard);
        ivBack = findViewById(R.id.ivBack);
        ivHome = findViewById(R.id.ivHome);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {


            int pos = bundle.getInt("pos");
            imageArray = (SeasonalGreeatingNewResponse.ImageArray) bundle.getSerializable("ImageArray");

            displayImageBannerNoPlaceHolder(CreateShareGreetingActivity.this, img_backgrund, imageArray.getBackgroundImage());

            tvTitle.setText("" + imageArray.getMain_title());

            TEXT_SIDE = imageArray.getImageAlignment();

            UserFullName = SeasonalGreetingBuilder.getUserName();
            UserCompanyName = SeasonalGreetingBuilder.getCompanyName();
            companyLogo = SeasonalGreetingBuilder.getCompanyLogo();
            btnShare.setText(SeasonalGreetingBuilder.getShareBtnText());
            newProfileGet();

            switchshowLogo.setOnToggledListener(new OnToggledListener() {
                @Override
                public void onSwitched(ToggleableView toggleableView, boolean isOn) {

                    try {
                        if (isOn) {
                            if (TEXT_SIDE.equalsIgnoreCase("left")) {
                                card_left_logo.setVisibility(View.VISIBLE);
                                displayBusinessCardLogo(CreateShareGreetingActivity.this, img_left_companyLogo, companyLogo);
                            } else if (TEXT_SIDE.equalsIgnoreCase("right")) {
                                card_right_logo.setVisibility(View.VISIBLE);
                                displayBusinessCardLogo(CreateShareGreetingActivity.this, img_right_companyLogo, companyLogo);
                            } else if (TEXT_SIDE.equalsIgnoreCase("top_top_from")
                                    || TEXT_SIDE.equalsIgnoreCase("top_bottom_from")) {
                                card_top_logo.setVisibility(View.VISIBLE);
                                displayBusinessCardLogo(CreateShareGreetingActivity.this, img_top_logo, companyLogo);
                            }
                        } else {

                            if (TEXT_SIDE.equalsIgnoreCase("left")) {
                                card_left_logo.setVisibility(View.GONE);
                            } else if (TEXT_SIDE.equalsIgnoreCase("right")) {
                                card_right_logo.setVisibility(View.GONE);
                            } else if (TEXT_SIDE.equalsIgnoreCase("top_top_from")
                                    || TEXT_SIDE.equalsIgnoreCase("top_bottom_from")) {
                                card_top_logo.setVisibility(View.GONE);
                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            select_radio_from_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                    if (checkedId == R.id.select_userName) {// TODO Something
                        if (TEXT_SIDE.equalsIgnoreCase("top_top_from")) {
                            top_top_from_user_name.setText(UserFullName);
                            top_top_from_company_name.setText("");
                        } else if (TEXT_SIDE.equalsIgnoreCase("top_bottom_from")) {
                            txt_top_bottom_from_user_name.setText(UserFullName);
                            txt_top_bottom_from_company_name.setText("");
                        } else if (TEXT_SIDE.equalsIgnoreCase("left")) {
                            txt_left_from_user_name.setText(UserFullName);
                            txt_left_from_company_name.setText("");
                        } else if (TEXT_SIDE.equalsIgnoreCase("right")) {
                            txt_right_from_user_name.setText(UserFullName);
                            txt_right_from_company_name.setText("");
                        }
                    } else if (checkedId == R.id.select_userName_company) {// TODO Something
                        if (TEXT_SIDE.equalsIgnoreCase("top_top_from")) {
                            top_top_from_user_name.setText(UserFullName);
                            top_top_from_company_name.setText(UserCompanyName);
                        } else if (TEXT_SIDE.equalsIgnoreCase("top_bottom_from")) {
                            txt_top_bottom_from_user_name.setText(UserFullName);
                            txt_top_bottom_from_company_name.setText(UserCompanyName);
                        } else if (TEXT_SIDE.equalsIgnoreCase("left")) {
                            txt_left_from_user_name.setText(UserFullName);
                            txt_left_from_company_name.setText(UserCompanyName);
                        } else if (TEXT_SIDE.equalsIgnoreCase("right")) {
                            txt_right_from_user_name.setText(UserFullName);
                            txt_right_from_company_name.setText(UserCompanyName);
                        }
                    } else if (checkedId == R.id.select_compnay_name) {// TODO Something
                        if (TEXT_SIDE.equalsIgnoreCase("top_top_from")) {
                            top_top_from_user_name.setText(UserCompanyName);
                            top_top_from_company_name.setText("");
                        } else if (TEXT_SIDE.equalsIgnoreCase("top_bottom_from")) {
                            txt_top_bottom_from_user_name.setText(UserCompanyName);
                            txt_top_bottom_from_company_name.setText("");
                        } else if (TEXT_SIDE.equalsIgnoreCase("left")) {
                            txt_left_from_user_name.setText(UserCompanyName);
                            txt_left_from_company_name.setText("");
                        } else if (TEXT_SIDE.equalsIgnoreCase("right")) {
                            txt_right_from_user_name.setText(UserCompanyName);
                            txt_right_from_company_name.setText("");
                        }
                    }
                }
            });


        }

        btnShare.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                Permissions.check(CreateShareGreetingActivity.this, new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        null, null, new PermissionHandler() {
                            @Override
                            public void onGranted() {
                                shareResult(linLayMain, false);
                            }
                        });
            }
        });

        ivShareCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivShareCard();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivBack();
            }
        });
        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivBack();
            }
        });

    }

    private void setRightSideData() {

        lyt_main_top.setVisibility(View.GONE);
        lyt_left_text.setVisibility(View.GONE);
        lyt_right_text.setVisibility(View.VISIBLE);


        //-- set Aiegnment

        txt_right_to_name.setGravity(GetAliegnment(imageArray.getTo_text_alignment()));
        txt_right_from_user_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
        txt_right_from_company_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
        lyt_right_logo.setGravity(GetAliegnment(imageArray.getLogo_alignment()));


        LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) card_right_logo.getLayoutParams();
        lllp.gravity = GetAliegnment(imageArray.getLogo_alignment());
        card_right_logo.setLayoutParams(lllp);

        if (imageArray.getShowFromName()) {
            lyt_from_right.setVisibility(View.VISIBLE);
            select_radio_from_type.setVisibility(View.VISIBLE);

            txt_right_from_user_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
            txt_right_from_user_name.SetFont(CreateShareGreetingActivity.this, imageArray.getFromNameFontName());
            txt_right_from_user_name.SetFontSize(GetTextSize(imageArray.getFrom_name_font_size()));

            txt_right_from_company_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
            txt_right_from_company_name.SetFont(CreateShareGreetingActivity.this, "montserrat_regular");
            txt_right_from_company_name.SetFontSize(GetTextSize("small"));

        } else {
            select_radio_from_type.setVisibility(View.GONE);
            lyt_from_right.setVisibility(View.GONE);
        }

    }

    private void setLeftSideData() {
        lyt_main_top.setVisibility(View.GONE);
        lyt_left_text.setVisibility(View.VISIBLE);
        lyt_right_text.setVisibility(View.GONE);

        //-- set Aiegnment

        txt_left_to_name.setGravity(GetAliegnment(imageArray.getTo_text_alignment()));
        txt_left_from_user_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
        txt_left_from_company_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));

        lyt_left_logo.setGravity(GetAliegnment(imageArray.getLogo_alignment()));

        LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) card_left_logo.getLayoutParams();
        lllp.gravity = GetAliegnment(imageArray.getLogo_alignment());
        card_left_logo.setLayoutParams(lllp);

        if (imageArray.getShowFromName()) {
            select_radio_from_type.setVisibility(View.VISIBLE);
            lyt_from_left.setVisibility(View.VISIBLE);

            txt_left_from_user_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
            txt_left_from_user_name.SetFont(CreateShareGreetingActivity.this, imageArray.getFromNameFontName());
            txt_left_from_user_name.SetFontSize(GetTextSize(imageArray.getFrom_name_font_size()));

            txt_left_from_company_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
            txt_left_from_company_name.SetFont(CreateShareGreetingActivity.this, "montserrat_regular");
            txt_left_from_company_name.SetFontSize(GetTextSize("small"));

        } else {
            select_radio_from_type.setVisibility(View.GONE);
            lyt_from_left.setVisibility(View.GONE);
        }


    }

    private void setTopData() {
        lyt_left_text.setVisibility(View.GONE);
        lyt_right_text.setVisibility(View.GONE);
        lyt_main_top.setVisibility(View.VISIBLE);


        LinearLayout.LayoutParams lllp = (LinearLayout.LayoutParams) card_top_logo.getLayoutParams();
        lllp.gravity = GetAliegnment(imageArray.getLogo_alignment());
        card_top_logo.setLayoutParams(lllp);

        if (imageArray.getShowFromName()) {
            if (TEXT_SIDE.equalsIgnoreCase("top_top_from")) {
                top_top_from_user_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
                top_top_from_user_name.setVisibility(View.VISIBLE);
                top_top_from_user_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
                top_top_from_user_name.SetFont(CreateShareGreetingActivity.this, imageArray.getFromNameFontName());
                top_top_from_user_name.SetFontSize(GetTextSize(imageArray.getFrom_name_font_size()));

                top_top_from_company_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
                top_top_from_company_name.setVisibility(View.VISIBLE);
                top_top_from_company_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
                top_top_from_company_name.SetFont(CreateShareGreetingActivity.this, "montserrat_regular");
                top_top_from_company_name.SetFontSize(GetTextSize("small"));

            } else {

                txt_top_bottom_from_user_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
                txt_top_bottom_from_user_name.setVisibility(View.VISIBLE);
                txt_top_bottom_from_user_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
                txt_top_bottom_from_user_name.SetFont(CreateShareGreetingActivity.this, imageArray.getFromNameFontName());
                txt_top_bottom_from_user_name.SetFontSize(GetTextSize(imageArray.getFrom_name_font_size()));

                txt_top_bottom_from_company_name.setGravity(GetAliegnment(imageArray.getFrom_text_alignment()));
                txt_top_bottom_from_company_name.setVisibility(View.VISIBLE);
                txt_top_bottom_from_company_name.setTextColor(Color.parseColor(imageArray.getFromNameFontColor()));
                txt_top_bottom_from_company_name.SetFont(CreateShareGreetingActivity.this, "montserrat_regular");
                txt_top_bottom_from_company_name.SetFontSize(GetTextSize("small"));

            }
            select_radio_from_type.setVisibility(View.VISIBLE);

        } else {
            select_radio_from_type.setVisibility(View.GONE);
            if (TEXT_SIDE.equalsIgnoreCase("top_top_from")) {
                top_top_from_user_name.setVisibility(View.GONE);
                top_top_from_company_name.setVisibility(View.GONE);
            } else {
                txt_top_bottom_from_user_name.setVisibility(View.GONE);
                txt_top_bottom_from_company_name.setVisibility(View.GONE);
            }
        }
    }


    private int GetAliegnment(String aliegnment) {
        switch (aliegnment.toLowerCase()) {
            case "start":
                return Gravity.START;
            case "end":
                return Gravity.END;
            case "center":
                return Gravity.CENTER;
            case "left":
                return Gravity.LEFT;
            case "right":
                return Gravity.RIGHT;
            case "top":
                return Gravity.TOP;
            case "bottom":
                return Gravity.BOTTOM;
            default:
                return Gravity.CENTER;
        }
    }


    private float GetTextSize(String aliegnment) {
        switch (aliegnment.toLowerCase()) {
            case "small":
                return getResources().getDimension(R.dimen.textSmall);
            case "medium":
                return getResources().getDimension(R.dimen.textMedium);
            case "large":
                return getResources().getDimension(R.dimen.textLarge);
            default:
                return getResources().getDimension(R.dimen.textMedium);
        }
    }


    void ivShareCard() {
        Permissions.check(this, new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
                null, null, new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        shareResult(linLayMain, false);
                    }
                });
    }


    public static Bitmap getLayoutScreenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    private void shareResult(LinearLayout data, boolean isTimeLine) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String currentTimeStamp = dateFormat.format(new Date());
        currentTimeStamp = currentTimeStamp + getRandomNumber(100, 10000);
        resultBitmap = getLayoutScreenShot(data);
        StrictMode.VmPolicy.Builder builder2 = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder2.build());

        saveBitmap(resultBitmap, currentTimeStamp);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                saveImage(isTimeLine);
            }
        }, 500);
    }


    private String getRandomNumber(int min, int max) {
        int data = (new Random()).nextInt((max - min) + 1) + min;
        return "" + data;
    }

    public void saveImage(boolean isTimeLine) {
        if (isTimeLine) {
            List<String> fileData = new ArrayList<>();
            fileData.add(FileUtils.getRealPath(CreateShareGreetingActivity.this, contentUri));
            Log.e("## uri :", contentUri.toString());
            Log.e("## fileData", fileData.get(0).toString());
        } else {
            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("image/*");
            waIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
            startActivity(Intent.createChooser(waIntent, "Share with"));
            finish();
        }
    }

    public void saveBitmap(Bitmap bitmap, String currentTimeStamp) {
        File cachePath = new File(getExternalCacheDir(), "image");

        if (cachePath.mkdirs()) {
            //Tools.log("$$$", "created DIR: ");
        }

        FileOutputStream stream = null; // overwrites this image every time
        try {
            stream = new FileOutputStream(cachePath + "/" + currentTimeStamp + ".png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File newFile = new File(cachePath, currentTimeStamp + ".png");

        contentUri = FileProvider.getUriForFile(this, "com.fincasys.seasonalgreeting.provider",
                newFile);

    }

    void ivBack() {
        //startActivity(new Intent(this, DashBoardActivity.class));
        finish();
    }

    void newProfileGet() {

        select_userName.setText("" + UserFullName);
        select_userName_company.setText("" + UserFullName + " And " + UserCompanyName);
        select_compnay_name.setText("" + UserCompanyName);

        select_userName.setTextSize(SeasonalGreetingBuilder.getTxtSize());
        select_userName_company.setTextSize(SeasonalGreetingBuilder.getTxtSize());
        select_compnay_name.setTextSize(SeasonalGreetingBuilder.getTxtSize());

        select_userName.setTextColor(Color.parseColor(SeasonalGreetingBuilder.getTxtColor()));
        select_userName_company.setTextColor(Color.parseColor(SeasonalGreetingBuilder.getTxtColor()));
        select_compnay_name.setTextColor(Color.parseColor(SeasonalGreetingBuilder.getTxtColor()));

        if (companyLogo != null
                && companyLogo.length() > 0) {
            lyt_edit_company_logo.setVisibility(View.VISIBLE);
            displayBusinessCardLogo(CreateShareGreetingActivity.this, visible_logo, companyLogo);
        } else {
            lyt_edit_company_logo.setVisibility(View.GONE);
        }


        if (TEXT_SIDE.equalsIgnoreCase("left")) {
            setLeftSideData();
        } else if (TEXT_SIDE.equalsIgnoreCase("right")) {
            setRightSideData();
        } else if (TEXT_SIDE.equalsIgnoreCase("top_top_from") ||
                TEXT_SIDE.equalsIgnoreCase("top_bottom_from")) {
            setTopData();
        } else {
            Toast.makeText(CreateShareGreetingActivity.this, "Not Support", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (imageArray.getShowFromName()) {
            select_userName.setChecked(true);
        }
    }

    public static void displayBusinessCardLogo(Context ctx, ImageView img, String url) {
        try {
            Glide.with(ctx).load(url).into(img);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void displayImageBannerNoPlaceHolder(Context ctx, ImageView img, String url) {
        try {
            if (url.startsWith("@drawable/")) {
                int imageResource = ctx.getResources().getIdentifier(url.toString().trim(), null,
                        ctx.getPackageName());
                Glide.with(ctx).load(imageResource)
                        .into(img);

                ps_load.setVisibility(View.GONE);

            } else {

                try {
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .priority(Priority.HIGH);
                    new GlideImageLoader(img,
                            ps_load).load(url, options);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }

        } catch (Exception e) {
            Log.e("@@", Objects.requireNonNull(e.getMessage()));
        }
    }


}