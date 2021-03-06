package wingsoloar.com.buding_oa.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import wingsoloar.com.buding_oa.R;

/**
 * Created by wingsolarxu on 2017/8/17.
 */

public class BottomBarView extends RelativeLayout {

    private int msgCount;
    private TextView bar_num;

    public BottomBarView(Context context) {
        super(context,null);
    }

    public BottomBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        RelativeLayout rl = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.counting_view, this, true);
        bar_num = (TextView) rl.findViewById(R.id.bar_num);
    }

    public void setMessageCount(int count) {
        msgCount = count;
        if (count == 0) {
            bar_num.setVisibility(View.GONE);
        } else {
            bar_num.setVisibility(View.VISIBLE);
            if (count < 100) {
                bar_num.setText(count + "");
            } else {
                bar_num.setText("99+");
            }
        }
        invalidate();
    }

    public void addMsg() {
        setMessageCount(msgCount + 1);
    }
}
