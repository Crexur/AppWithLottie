package android.example.appdevictweek;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class EaseInOutPageTransformer implements ViewPager2.PageTransformer {

    private static final float MIN_SCALE = 0.85f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        float absPosition = Math.abs(position);

        // Apply ease-in/ease-out transformation
        page.setScaleY(MIN_SCALE + (1 - MIN_SCALE) * (1 - absPosition));
        page.setAlpha(MIN_SCALE + (1 - MIN_SCALE) * (1 - absPosition));

        if (position < 0) {
            page.setTranslationX(-page.getWidth() * position);
        } else {
            page.setTranslationX(page.getWidth() * -position);
        }
    }
}
