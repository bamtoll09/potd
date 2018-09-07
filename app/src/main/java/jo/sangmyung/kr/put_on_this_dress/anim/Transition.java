package jo.sangmyung.kr.put_on_this_dress.anim;

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

    }
}
