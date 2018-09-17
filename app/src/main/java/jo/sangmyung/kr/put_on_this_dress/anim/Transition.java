package jo.sangmyung.kr.put_on_this_dress.anim;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;

public class Transition {

    private View view;
    private Rect mPriViewRect;

    Transition(View view) {
        int[] l = new int[2];
        view.getLocationOnScreen(l);
        mPriViewRect = new Rect(l[0], l[1], l[0] + view.getWidth(), l[1] + view.getHeight());

        this.view = view;
    }

    protected void startEnterAnimation() {
        Rect previewRect = mPriViewRect;

        float scaleX = (float) previewRect.width() / 1080;
        float scaleY = (float) previewRect.height() / 1920;

        int transX = previewRect.left - (1080 - previewRect.width() / 2 );
        int transY = previewRect.top;

        ValueAnimator animator = ValueAnimator.ofFloat(0.1f, 0.1f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float offset = (Float) animation.getAnimatedValue();
                float reverseoffset = 1.f - offset;

            }
        });
    }
}
