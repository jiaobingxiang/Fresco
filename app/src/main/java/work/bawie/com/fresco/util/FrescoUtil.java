package work.bawie.com.fresco.util;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class FrescoUtil {
    /**
     * 加载比例静态图片
     * @param simpleDraweeView  控件
     * @param iconStr   图片地址
     * @param aspectRatio   长宽比例
     */
    public static void loadPicInApp(@NonNull SimpleDraweeView simpleDraweeView, @NonNull String iconStr, float aspectRatio) {
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (anim != null) {
                    // 其他控制逻辑
                    anim.start();
                }
            }
        };
        if (simpleDraweeView==null){
            return;
        }
        Uri uri = Uri.parse(iconStr);
        if (aspectRatio>0){
            simpleDraweeView.setAspectRatio(aspectRatio);
        }
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setControllerListener(controllerListener)
                // 其他设置（如果有的话）
                .build();
        simpleDraweeView.setController(controller);
    }
    /**
     * @param simpleDraweeView
     * @param gifUrl
     */
    public static void loadGifPicOnNet(SimpleDraweeView simpleDraweeView, @NonNull String gifUrl) {
        Uri uri = Uri.parse(gifUrl);
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)
                .build();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        simpleDraweeView.setController(draweeController);
    }

    /**
     * @param simpleDraweeView
     * @param gifUrl
     * @param aspectRatio
     */
    public static void loadGifPicOnNet(SimpleDraweeView simpleDraweeView, @NonNull String gifUrl, float aspectRatio) {
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(gifUrl))
                .setAutoPlayAnimations(true)
                .build();
        if (aspectRatio>0){
            simpleDraweeView.setAspectRatio(aspectRatio);
        }
        simpleDraweeView.setController(draweeController);
    }
}
