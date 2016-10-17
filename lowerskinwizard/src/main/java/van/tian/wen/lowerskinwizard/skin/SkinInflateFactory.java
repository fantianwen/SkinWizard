package van.tian.wen.lowerskinwizard.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RadAsm on 16/10/14.
 */
public class SkinInflateFactory implements LayoutInflater.Factory {

    private ArrayList<SkinItem> mSkinItems = new ArrayList<>();
    private Context mContext;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        mContext = context;
        // 解析出需要换肤的控件
        boolean skinChangeEnable = attrs.getAttributeBooleanValue(SkinConfig.SKIN_CHANGE_NAMESPACE, SkinConfig.SKIN_ATTRIBUTE_NAME, false);

        if (skinChangeEnable) {
            View view = createView(context, name, attrs);
            parseSkinAttrs(view, attrs);

            return view;
        }
        return null;
    }

    private void parseSkinAttrs(View view, AttributeSet attrs) {

        SkinItem skinItem = new SkinItem();
        skinItem.setView(view);
        SparseArray<SkinAttribute> skinAttributes = new SparseArray<>();
        skinItem.setSkinAttributes(skinAttributes);


        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            String attributeName = attrs.getAttributeName(i);

            if (SkinConfig.SKIN_ATTRIBUTE.BACKGROUND.getAttributeName().equals(attributeName)) {
                cacheTempAttributes(view, skinAttributes, attributeName);
            } else if (SkinConfig.SKIN_ATTRIBUTE.TEXTCOLOR.getAttributeName().equals(attributeName)) {
                cacheTempAttributes(view, skinAttributes, attributeName);
            }
            //... add new attributes
        }

        mSkinItems.add(skinItem);

    }

    private void cacheTempAttributes(View view, SparseArray<SkinAttribute> skinAttributes, String attributeName) {
        // 把需要换肤的view缓存
        int code = SkinConfig.SKIN_ATTRIBUTE.BACKGROUND.getCode();
        SkinAttribute skinAttribute = skinAttributes.get(code);
        if (skinAttribute == null) {
            SkinAttribute skinAttributeNew = new SkinAttribute();
            skinAttributeNew.setAttributeName(attributeName);
            // 当需要加载的时候在解析
            //         skinAttributeNew.setAttributeValue();
            skinAttributes.put(code, skinAttributeNew);
        }

        notifySkinToChange(view, skinAttributes);

    }

    private void notifySkinToChange(View view, SparseArray<SkinAttribute> skinAttributes) {

        if (view instanceof TextView) {
            // textColor
            TextView textView = (TextView) view;

            if (skinAttributes.get(SkinConfig.SKIN_ATTRIBUTE.TEXTCOLOR.getCode()) != null) {
                textView.setTextColor(SkinManager.getInstance().parseTextColor(mContext));
            }

            if (skinAttributes.get(SkinConfig.SKIN_ATTRIBUTE.BACKGROUND.getCode()) != null) {
                textView.setBackgroundColor(SkinManager.getInstance().parseBackgroundColor(mContext));
            }


        }

    }

    private View createView(Context context, String name, AttributeSet attrs) {
        View view = null;
        try {
            if (-1 == name.indexOf('.')) {
                if ("View".equals(name)) {
                    view = LayoutInflater.from(context).createView(name, "android.view.", attrs);
                }
                if (view == null) {
                    view = LayoutInflater.from(context).createView(name, "android.widget.", attrs);
                }
                if (view == null) {
                    view = LayoutInflater.from(context).createView(name, "android.webkit.", attrs);
                }
            } else {
                view = LayoutInflater.from(context).createView(name, null, attrs);
            }

        } catch (Exception e) {
            view = null;
        }
        return view;
    }


    public void notifySkinToChange() {

        for (int i = 0; i < mSkinItems.size(); i++) {
            SkinItem skinItem = mSkinItems.get(i);

            View view = skinItem.getView();
            notifySkinToChange(view, skinItem.getSkinAttributes());
        }

    }
}
