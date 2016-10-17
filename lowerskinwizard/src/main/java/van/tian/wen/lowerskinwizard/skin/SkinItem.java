package van.tian.wen.lowerskinwizard.skin;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by RadAsm on 16/10/14.
 */
public class SkinItem {

    private View view;
    private SparseArray<SkinAttribute> skinAttributes;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public SparseArray<SkinAttribute> getSkinAttributes() {
        return skinAttributes;
    }

    public void setSkinAttributes(SparseArray<SkinAttribute> skinAttributes) {
        this.skinAttributes = skinAttributes;
    }
}
