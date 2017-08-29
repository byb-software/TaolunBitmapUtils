package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;

import java.util.List;

/**
 * Created by tony on 2017/7/29.
 */
public class TaolunBitmapUtils {

    private static Bitmap[] mbitmap;

    /**
     *
     * @param tempWidth  最终图片的宽
     * @param tempHeight  最终图片的高
     * @param bitmaps    放入里面的图片集合，可放1-5个数量
     * @return   返回最终的Bitmap类型，并且是经过圆形剪裁的最终图片
     *
     *  仿照QQ讨论组的头像，此方法的背景颜色已固定，可以在此代码修改
     */
    public static Bitmap CircleTaolunBitmap(int tempWidth, int tempHeight, List<Bitmap> bitmaps){


        if(bitmaps.size()<1 && bitmaps.size() >5){
            return null;
        }

        Bitmap bitmap = bitmaps.get(0);
        if(bitmap == null){
            return null;
        }


        Bitmap canvasBitmap = Bitmap.createBitmap(tempWidth, tempHeight,
                Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(canvasBitmap);
        localCanvas.drawColor(Color.parseColor("#d1dedf"));

        JoinBitmaps.join(localCanvas, Math.min(tempWidth, tempHeight),bitmaps);

        return GetRoundedCornerBitmap(canvasBitmap);
    }

    /**
     *
     * @param tempWidth   最终图片的宽
     * @param tempHeight  最终图片的高
     * @param bitmaps     放入里面的图片集合，可放1-5个数量
     * @param background  可以设定最终图的背景颜色
     * @return   返回最终的Bitmap类型，并且是经过圆形剪裁的最终图片
     *
     * 仿QQ讨论组头像的方法，此方法的背景颜色可以修改
     */
    public static Bitmap CircleTaolunBitmap(int tempWidth, int tempHeight, List<Bitmap> bitmaps,int background){

        //防止输入的集合为空
        if(bitmaps.size()<1 && bitmaps.size() >5){
            return null;
        }

        //取出第一张图片检验是否为空
        Bitmap bitmap = bitmaps.get(0);
        if(bitmap == null){
            return null;
        }

        Bitmap canvasBitmap = Bitmap.createBitmap(tempWidth, tempHeight,
                Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(canvasBitmap);
        localCanvas.drawColor(background);

        JoinBitmaps.join(localCanvas, Math.min(tempWidth, tempHeight),bitmaps);

        return GetRoundedCornerBitmap(canvasBitmap);
    }





    private static int padding = 2; /** 图片之间的距离 */
    private static int cornor = 0;/** 内部图片的圆角值 */
    private static Bitmap[] paramList ;

    /**
     *    此方法是仿微信讨论组头像的制作方法
     *
     * @param context 上下文对象
     * @param tempWidth 所显示最终图片的宽
     * @param tempHeight 所显示最终图片的高
     * @param bitmaps  内层图片存放的bitmap集合
     * @return   仿微信讨论组头像的最终图片bitmap
     */

    public static Bitmap SquareTaolunzuBitmap(Context context,int tempWidth,int tempHeight,List<Bitmap> bitmaps){

           // 重置padding
                padding = 2;

        paramList = bitmaps.toArray(new Bitmap[bitmaps.size()]);

        if (paramList.length < 1 && paramList.length > 9) {
            return null;
        }
        // 先取一个获取宽和高
        Bitmap tempBitmap = (Bitmap) paramList[0];
        if (tempBitmap == null) {
            return null;
        }

        // 创建一个空格的bitmap
        Bitmap canvasBitmap = Bitmap.createBitmap(tempWidth, tempHeight,
                Bitmap.Config.ARGB_8888);
        // 头像的数量
        int bitmapCount = paramList.length;
        Canvas localCanvas = new Canvas(canvasBitmap);
        localCanvas.drawColor(Color.parseColor("#d1dedf"));
        int colum = 0;

        if (bitmapCount > 1 && bitmapCount < 5) {
            colum = 2;
        } else if (bitmapCount > 4 && bitmapCount < 10) {
            colum = 3;
        } else {
            colum = 1;
        }
        float scale = 1.0F / colum;
        // 根据列数缩小
        Bitmap scaledBitmap = scaleBitmap(scale, tempBitmap);
        if (padding > 0) {
            padding = dip2px(context, padding);
            // 如果有内边距 再次缩小
            float paddingScale = (float) (tempWidth - (colum + 1) * padding)
                    / colum / scaledBitmap.getWidth();
            scaledBitmap = scaleBitmap(paddingScale, scaledBitmap);
            scale = scale * paddingScale;
        }
        // 第一行的 头像个数
        int topRowCount = bitmapCount % colum;
        // 满行的行数
        int rowCount = bitmapCount / colum;
        if (topRowCount > 0) {
            // 如果第一行头像个数大于零 行数加1
            rowCount++;
        } else if (topRowCount == 0) {
            // 6 或者 9 第一行头像个数和列数一致
            topRowCount = colum;
        }
        // 缩小后头像的宽
        int scaledWidth = scaledBitmap.getWidth();
        // 缩小后头像的高
        int scaledHeight = scaledBitmap.getHeight();
        // 第一个头像与画布顶部的距离
        int firstTop = ((tempHeight - (rowCount * scaledHeight + (rowCount + 1)
                * padding)) / 2)
                + padding;
        // 第一个头像与画布左部的距离
        int firstLeft = ((tempWidth - (topRowCount * scaledWidth + (topRowCount + 1)
                * padding)) / 2)
                + padding;
        for (int i = 0; i < paramList.length; i++) {
            if (i == 9) {// 达到上限 停止
                break;
            }
            // 按照最终压缩比例压缩
            Bitmap bit = scaleBitmap(scale, (Bitmap) paramList[i]);
            if (cornor > 0) {
                // 圆角化
                bit = GetRoundedCornerBitmap(bit);
            }
            localCanvas.drawBitmap(bit, firstLeft, firstTop, null);
            firstLeft += (scaledWidth + padding);
            if (i == topRowCount - 1 | tempWidth - firstLeft < scaledWidth) {
                firstTop += (scaledHeight + padding);
                firstLeft = padding;
            }
            bit.recycle();
        }
        // 重置padding
       // padding = 2;
        localCanvas.save(Canvas.ALL_SAVE_FLAG);
        localCanvas.restore();
        return canvasBitmap;

    }





    /**
     *    此方法是可以修改背景的仿微信讨论组头像的制作方法
     *
     * @param context 上下文对象
     * @param tempWidth 所显示最终图片的宽
     * @param tempHeight 所显示最终图片的高
     * @param bitmaps  内层图片存放的bitmap集合
     * @param background  可以修改头像的底层背景
     * @return   仿微信讨论组头像的最终图片bitmap
     */


    public static Bitmap SquareTaolunzuBitmap(Context context,int tempWidth,int tempHeight,List<Bitmap> bitmaps,int background){

        // 重置padding
        padding = 2;
        paramList = bitmaps.toArray(new Bitmap[bitmaps.size()]);

        if (paramList.length < 1 && paramList.length > 9) {
            return null;
        }
        // 先取一个获取宽和高
        Bitmap tempBitmap = (Bitmap) paramList[0];
        if (tempBitmap == null) {
            return null;
        }

        // 创建一个空格的bitmap
        Bitmap canvasBitmap = Bitmap.createBitmap(tempWidth, tempHeight,
                Bitmap.Config.ARGB_8888);
        // 头像的数量
        int bitmapCount = paramList.length;
        Canvas localCanvas = new Canvas(canvasBitmap);
        localCanvas.drawColor(background);
        int colum = 0;

        if (bitmapCount > 1 && bitmapCount < 5) {
            colum = 2;
        } else if (bitmapCount > 4 && bitmapCount < 10) {
            colum = 3;
        } else {
            colum = 1;
        }
        float scale = 1.0F / colum;
        // 根据列数缩小
        Bitmap scaledBitmap = scaleBitmap(scale, tempBitmap);
        if (padding > 0) {
            padding = dip2px(context, padding);
            // 如果有内边距 再次缩小
            float paddingScale = (float) (tempWidth - (colum + 1) * padding)
                    / colum / scaledBitmap.getWidth();
            scaledBitmap = scaleBitmap(paddingScale, scaledBitmap);
            scale = scale * paddingScale;
        }
        // 第一行的 头像个数
        int topRowCount = bitmapCount % colum;
        // 满行的行数
        int rowCount = bitmapCount / colum;
        if (topRowCount > 0) {
            // 如果第一行头像个数大于零 行数加1
            rowCount++;
        } else if (topRowCount == 0) {
            // 6 或者 9 第一行头像个数和列数一致
            topRowCount = colum;
        }
        // 缩小后头像的宽
        int scaledWidth = scaledBitmap.getWidth();
        // 缩小后头像的高
        int scaledHeight = scaledBitmap.getHeight();
        // 第一个头像与画布顶部的距离
        int firstTop = ((tempHeight - (rowCount * scaledHeight + (rowCount + 1)
                * padding)) / 2)
                + padding;
        // 第一个头像与画布左部的距离
        int firstLeft = ((tempWidth - (topRowCount * scaledWidth + (topRowCount + 1)
                * padding)) / 2)
                + padding;
        for (int i = 0; i < paramList.length; i++) {
            if (i == 9) {// 达到上限 停止
                break;
            }
            // 按照最终压缩比例压缩
            Bitmap bit = scaleBitmap(scale, (Bitmap) paramList[i]);
            if (cornor > 0) {
                // 圆角化
                bit = GetRoundedCornerBitmap(bit);
            }
            localCanvas.drawBitmap(bit, firstLeft, firstTop, null);
            firstLeft += (scaledWidth + padding);
            if (i == topRowCount - 1 | tempWidth - firstLeft < scaledWidth) {
                firstTop += (scaledHeight + padding);
                firstLeft = padding;
            }
            bit.recycle();
        }
        // 重置padding
        //padding = 2;
        localCanvas.save(Canvas.ALL_SAVE_FLAG);
        localCanvas.restore();
        return canvasBitmap;

    }



    //绘制仿微信讨论组头像内部头像的重新剪裁图片bitmap    按比例缩放图片
    private static Bitmap scaleBitmap(float paramFloat, Bitmap paramBitmap) {
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(paramFloat, paramFloat);
        //找出内部图片的最短距离，以这个长度来进行重新绘制得到正方形图片
        int chang = Math.min(paramBitmap.getWidth(), paramBitmap.getHeight());
        return Bitmap.createBitmap(paramBitmap, 0, 0,chang ,chang
               , localMatrix, true);
    }

    //此方法用于仿微信讨论组头像的尺寸转换   即转换为设备独立像素dip
    private static int dip2px(Context context, float value) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                value, context.getResources().getDisplayMetrics()) + 0.5f);
    }


    /**
     *    将图片剪裁成圆形的工具类
     * @param bitmap   传入一张图片  bitmap
     * @return    返回此图片裁剪成圆形之后的bitmap
     */
    private static Bitmap GetRoundedCornerBitmap(Bitmap bitmap) {
        try {
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                    bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight());
            final RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight()));
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(Color.BLACK);

            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int cornor = Math.min(width,height);

            canvas.drawRoundRect(rectF, cornor, cornor, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            final Rect src = new Rect(0, 0, bitmap.getWidth(),
                    bitmap.getHeight());

            canvas.drawBitmap(bitmap, src, rect, paint);
            return output;
        } catch (Exception e) {
            return bitmap;
        }
    }





}



