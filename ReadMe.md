### LowerSkinWizard

一个非常低端的换肤库




### feature

#### v 0.0.1

- TextView 
	- textColor
	- background 	
	
- ViewGroup
	- background


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

- 在希望换肤的`view`上面使用：`van:skinChangeEnable="true"`,并在该xml文件中使用命名空间：

```
xmlns:van="http://schemas.android.com/van"
```

例如：

```
<TextView
 xmlns:van="http://schemas.android.com/van"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorAccent"
    android:text="MainActivity"
    android:textColor="@color/colorPrimaryDark"
    van:skinChangeEnable="true" />
```

- 继承`BaseActivity`，直接在希望换肤的地方

```
applySkin(skinIndex);
```

详见Demo:




