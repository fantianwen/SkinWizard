### LowerSkinWizard

一个非常低端的换肤库

### 一瞥


### how to use

- 在`Application`中,实现`SkinManager.SkinProvider`，并在`provideSkins`提供各种不同皮肤的资源id.

```
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
```

- 继承`BaseActivity`，直接在希望换肤的地方

```
applySkin(skinIndex);
```

详见Demo:




