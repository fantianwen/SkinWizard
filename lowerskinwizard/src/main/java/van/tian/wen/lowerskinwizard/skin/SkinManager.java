package van.tian.wen.lowerskinwizard.skin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;

/**
 * Created by RadAsm on 16/10/14.
 */
public class SkinManager {

    private static SkinManager mInstance;
    private int[] skins;

    private SkinManager() {

    }

    public static SkinManager getInstance() {
        if (mInstance == null) {
            synchronized (SkinManager.class) {
                mInstance = new SkinManager();
            }
        }
        return mInstance;
    }

    private static int[] skinAttrs = {
            android.R.attr.textColor,
            android.R.attr.background
    };

    public int getSkin(int skinIndex) {

        if (skins != null) {
            if (skinIndex < 0 || skinIndex > skins.length) {
                throw new IndexOutOfBoundsException("check skinIndex");
            }
            return skins[skinIndex];
        }
        // default
        return 0;

    }


    public interface SkinProvider {
        int[] provideSkins();
    }

    public void init(SkinProvider skinProvider) {
        this.skins = skinProvider.provideSkins();
    }

    private int getWhichSkin(int whichSkin) {
        return this.skins[whichSkin];
    }

    private int getSkinConfig(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SkinConfig.SKIN_TEMP_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(SkinConfig.SKIN_NAME, 0);
    }

    public void changeSkinTo(Context context, int skinIndex) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SkinConfig.SKIN_TEMP_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(SkinConfig.SKIN_NAME, skinIndex).apply();
    }


    public int parseTextColor(Context context) {
        if (context != null) {
            int skinConfig = getSkinConfig(context);
            int whichSkin = getWhichSkin(skinConfig);
            TypedArray typedArray = context.obtainStyledAttributes(whichSkin, skinAttrs);
            int color = typedArray.getColor(0, 0);
            typedArray.recycle();
            return color;
        }
        throw new NullPointerException("context can not be null!");
    }

    public int parseBackgroundColor(Context context) {
        if (context != null) {
            int skinConfig = getSkinConfig(context);
            int whichSkin = getWhichSkin(skinConfig);
            TypedArray typedArray = context.obtainStyledAttributes(whichSkin, skinAttrs);
            int backgroundColor = typedArray.getColor(1, 0);
            typedArray.recycle();
            return backgroundColor;
        }
        throw new NullPointerException("context can not be null!");
    }

}
