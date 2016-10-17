package van.tian.wen.lowerskinwizard.activity;

import android.app.Activity;
import android.os.Bundle;

import van.tian.wen.lowerskinwizard.skin.SkinInflateFactory;
import van.tian.wen.lowerskinwizard.skin.SkinManager;

/**
 * Created by RadAsm on 16/10/14.
 */
public class BaseActivity extends Activity {

    private SkinInflateFactory mSkinInflateFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSkinInflateFactory = new SkinInflateFactory();

        getLayoutInflater().setFactory(mSkinInflateFactory);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSkinInflateFactory.notifySkinToChange();
    }

    protected void applySkin(int skinIndex) {
        SkinManager.getInstance().changeSkinTo(this, skinIndex);
        applySkin();
    }

    private void applySkin() {
        mSkinInflateFactory.notifySkinToChange();
    }

}
