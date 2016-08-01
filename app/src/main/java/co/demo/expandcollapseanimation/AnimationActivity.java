package co.demo.expandcollapseanimation;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    static int llParentMargin = 0;

    LinearLayout llParent;
    LinearLayout rlParent;
    View button;
    ImageButton btn_fb;
    ImageButton btn_email;
    ImageButton btn_google;
    ImageButton btnLoginb;
    ImageButton abc;
    ImageView imageViewLogo;
    TextView textViewWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout);

        rlParent =  (LinearLayout) findViewById(R.id.rlParent);
        btn_fb = (ImageButton)findViewById(R.id.btn_fb);
        btn_email = (ImageButton)findViewById(R.id.btn_email);
        btn_google = (ImageButton)findViewById(R.id.btn_google);
        llParent = (LinearLayout)findViewById(R.id.llParent);
        btnLoginb = (ImageButton)findViewById(R.id.btnLoginb);
        abc = (ImageButton)findViewById(R.id.abc);
        imageViewLogo = (ImageView) findViewById(R.id.imageViewLogo);
        textViewWelcome = (TextView) findViewById(R.id.textViewWelcome);

    }




    public void open(View view) {

        final LinearLayout.LayoutParams llParams = (LinearLayout.LayoutParams) llParent.getLayoutParams();
        final LinearLayout.LayoutParams emailButtonParams = (LinearLayout.LayoutParams) btn_email.getLayoutParams();
       // final LinearLayout.LayoutParams googleButtonParams = (LinearLayout.LayoutParams) btn_google.getLayoutParams();
        final LinearLayout.LayoutParams fbButtonParams = (LinearLayout.LayoutParams) btn_fb.getLayoutParams();

        final RelativeLayout.LayoutParams abcParams = (RelativeLayout.LayoutParams) abc.getLayoutParams();
        final RelativeLayout.LayoutParams imageViewParams = (RelativeLayout.LayoutParams) imageViewLogo.getLayoutParams();

        Resources r = getResources();
        final float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 30, r.getDisplayMetrics());

        final int margin1 = emailButtonParams.bottomMargin;
        final int margin3 = fbButtonParams.bottomMargin;
        final  int marginabc = abcParams.topMargin;
        final  int marginll = llParams.topMargin;
        if (llParentMargin == 0)
            llParentMargin = marginll;
        final int imageViewTempMargin = imageViewParams.topMargin;

       // Log.v("llParentMargin", "  ---- " + llParentMargin);
        llParent.setVisibility(View.VISIBLE);
        abc.setVisibility(View.VISIBLE);

        Animation a = new Animation()
        {
            @SuppressLint("LongLogTag")
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {

                if (interpolatedTime != 1) {

                    int llTopMargin = (int) (marginll - (marginll * interpolatedTime));
                    int emailButtonTopMargin = (int) (margin1 - (margin1 * 1.5 *interpolatedTime));
                 //   int googleButtonTopMargin = (int) (margin2 + ((margin2 * 1.5)* (-interpolatedTime)));
                    int closeButtonTopMargin = (int) (margin3 + ((margin3 * 1.5) * (-interpolatedTime)));

                    int abcBottomMargin = (int) (marginabc - (marginabc * 0.6 * interpolatedTime));
                    int imageViewMargin = (int) (imageViewTempMargin - (px * interpolatedTime));


                 //   Log.v("Google Button top margin", "" + emailButtonParams.bottomMargin);
                //    Log.v("Google Button", ""+ googleButtonTopMargin);
                   // Log.v("email Button", "" + emailButtonTopMargin);
                  //  Log.v("Close Button", "" + closeButtonTopMargin);
                  //  Log.v("abc Button", "" + abcBottomMargin);

                    btnLoginb.setAlpha(1 - interpolatedTime);
                    abc.setAlpha(interpolatedTime);
                    textViewWelcome.setAlpha(1-interpolatedTime);
                    imageViewLogo.setAlpha(1 - (interpolatedTime * 9 / 10));

                    imageViewParams.setMargins(0,imageViewMargin, 0, 0);
                    emailButtonParams.setMargins(0,0,0,emailButtonTopMargin);
                 //   googleButtonParams.setMargins(0,0,0,googleButtonTopMargin);
                    fbButtonParams.setMargins(0, 0, 0, closeButtonTopMargin);
                    abcParams.setMargins(0, abcBottomMargin,0,0);

                    llParams.setMargins(0,llTopMargin,0,0);


                    btn_email.setLayoutParams(emailButtonParams);
                  //  btn_google.setLayoutParams(googleButtonParams);
                  //  btnClose.setLayoutParams(fbButtonParams);
                    abc.setLayoutParams(abcParams);

                    llParent.setLayoutParams(llParams);
                    imageViewLogo.setLayoutParams(imageViewParams);

                    llParent.requestLayout();
                    abc.requestLayout();

                }else {
                 //   Log.v("eeewwweew", "Animation end");
                    btnLoginb.setVisibility(View.GONE);
                }
                // rlParent.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        // a.setDuration(2000);
        a.setDuration(300);
        rlParent.startAnimation(a);

    }

    public void collapse(final View v) {

        final LinearLayout.LayoutParams llParams = (LinearLayout.LayoutParams) llParent.getLayoutParams();
        final LinearLayout.LayoutParams emailButtonParams = (LinearLayout.LayoutParams) btn_email.getLayoutParams();
        // final LinearLayout.LayoutParams googleButtonParams = (LinearLayout.LayoutParams) btn_google.getLayoutParams();
        final LinearLayout.LayoutParams fbButtonParams = (LinearLayout.LayoutParams) btn_fb.getLayoutParams();

        final RelativeLayout.LayoutParams abcParams = (RelativeLayout.LayoutParams) abc.getLayoutParams();
        final RelativeLayout.LayoutParams imageViewParams = (RelativeLayout.LayoutParams) imageViewLogo.getLayoutParams();

        Resources r = getResources();
        final float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 30, r.getDisplayMetrics());

        final int margin1 = emailButtonParams.bottomMargin;
        // final int margin2 = googleButtonParams.bottomMargin;
        final int margin3 = fbButtonParams.bottomMargin;
        final int marginabc = abcParams.topMargin; //167
        int temp = (int)((marginabc /0.4)- marginabc);
        final int temp1 = (int)((margin1 /0.5)+ margin1 + 10);
        final int temp2 = (int)((margin3 /0.5)+ margin3 + 10);
        final  int marginll = llParentMargin ;
        final int imageViewTempMargin = imageViewParams.topMargin;

       // Log.v("eeewwweew", "marginll " + marginll);

        btnLoginb.setVisibility(View.VISIBLE);
        final int finalMarginabc = temp; //251
        final Animation a = new Animation()
        {
            @SuppressLint("LongLogTag")
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {

                if (interpolatedTime != 1) {

                    int emailButtonTopMargin = (int) (margin1 - (temp1 * interpolatedTime));
                    //int googleButtonTopMargin = (int) (margin2 + ((margin2 * 3)* (-interpolatedTime)));
                    int fbButtonTopMargin = (int) (margin3 - (temp2 * interpolatedTime));
                    int abcBottomMargin = (int) (marginabc +  (finalMarginabc * interpolatedTime));

                    int llTopMargin = (int) (marginll * interpolatedTime);
                    int imageViewMargin = (int) ( imageViewTempMargin + (px * interpolatedTime));

                   // Log.v("eeewwweew", "margin1 " + emailButtonTopMargin);
//                    Log.v("eeewwweew", "margin2 " + googleButtonTopMargin);
//                    Log.v("eeewwweew", "margin3 " + fbButtonTopMargin);
                 //   Log.v("abc Button", "" + abcBottomMargin);


                    btnLoginb.setAlpha(interpolatedTime);
                    abc.setAlpha(1-interpolatedTime);
                    textViewWelcome.setAlpha(interpolatedTime);
                    imageViewLogo.setAlpha(imageViewLogo.getAlpha()+ (interpolatedTime*9/10));

                    emailButtonParams.setMargins(0,0,0,emailButtonTopMargin);
                    //googleButtonParams.setMargins(0,0,0,googleButtonTopMargin);
                    fbButtonParams.setMargins(0, 0, 0, fbButtonTopMargin);

                    abcParams.setMargins(0, abcBottomMargin,0,0);
                    llParams.setMargins(0,llTopMargin,0,0);
                    imageViewParams.setMargins(0,imageViewMargin, 0, 0);

                    btn_email.setLayoutParams(emailButtonParams);
                    abc.setLayoutParams(abcParams);
                    llParent.setLayoutParams(llParams);
                    imageViewLogo.setLayoutParams(imageViewParams);


                    llParent.requestLayout();
                    abc.requestLayout();

                }else {
                  //  btnLoginb.setVisibility(View.VISIBLE);
                    llParent.setVisibility(View.GONE);
                    abc.setVisibility(View.GONE);
                   // Log.v("eeewwweew", "Animation end");
                }

            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration(300);
        rlParent.startAnimation(a);

    }
}
