package van.tian.wen.lowerskinchanger;

import android.app.Application;

import van.tian.wen.lowerskinwizard.skin.SkinManager;

/**
 * Created by RadAsm on 16/10/17.
 */
public class SkinWizardApplication extends Application implements SkinManager.SkinProvider {

    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.getInstance().init(this);
    }

    @Override
    public int[] provideSkins() {
        return new int[]{R.style.Default, R.style.BlackNight};
    }
}
