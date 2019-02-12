package work.bawie.com.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import work.bawie.com.fresco.util.FrescoUtil;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pt_bu)
    Button ptBu;
    @BindView(R.id.yx_bu)
    Button yxBu;
    @BindView(R.id.yj_bu)
    Button yjBu;
    @BindView(R.id.dh_bu)
    Button dhBu;
    private SimpleDraweeView draweeView;
    private SimpleDraweeView draweeView2;
    private float ratio = 1024 / 653f;
    private float ratio2 = 400 / 293f;
    private Unbinder bind;
    private Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        initView();
        initGif();
    }


    private void initGif() {
        draweeView2 = (SimpleDraweeView) findViewById(R.id.icon_gif);
        FrescoUtil.loadGifPicOnNet(draweeView2, "https://p0.ssl.qhimgs1.com/bdr/_240_/t01c74dfa497432dbcc.gif", ratio2);
    }

    /*
     * 初始化数据
     * */
    private void initView() {
        draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        FrescoUtil.loadPicInApp(draweeView,"http://p0.so.qhimgs1.com/bdr/_240_/t012edbbfc67f82d5da.jpg",ratio);
    }

    @OnClick({R.id.pt_bu, R.id.yx_bu, R.id.yj_bu, R.id.dh_bu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pt_bu:
                draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
                draweeView.setImageURI(uri);
                break;
            case R.id.yx_bu:

                break;
            case R.id.yj_bu:
                draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
                draweeView.setImageURI(uri);
                break;
            case R.id.dh_bu:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
