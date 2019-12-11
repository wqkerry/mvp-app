package tv.huan.tencentAuth.activity;

import android.view.View;
import android.widget.Button;

import tv.huan.tencentAuth.R;
import tv.huan.tencentAuth.base.view.BaseActivity;


public class TestActivity extends BaseActivity<TestPresenter> implements View.OnClickListener {

    Button btn_send, btn_send1, btn_send2;

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this, this);
    }

    @Override
    protected void initView() {
        btn_send = findViewById(R.id.btn_send);
        btn_send1 = findViewById(R.id.btn_send1);
        btn_send2 = findViewById(R.id.btn_send2);

        btn_send.setOnClickListener(this);
        btn_send1.setOnClickListener(this);
        btn_send2.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_share;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_send) {
        }
        if (id == R.id.btn_send1) {
            //启动欢网订购页面
        }
        if (id == R.id.btn_send2) {
            //启动云视听
        }
    }
}
