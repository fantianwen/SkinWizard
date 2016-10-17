package van.tian.wen.lowerskinchanger;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import van.tian.wen.lowerskinwizard.activity.BaseActivity;

/**
 * Created by RadAsm on 16/9/21.
 */
public class MainActivity extends BaseActivity {

    private NavigationView mNavigationView;

    private CoordinatorLayout mMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {

        mMainContainer = (CoordinatorLayout) findViewById(R.id.mainContainer);

        mNavigationView = (NavigationView) findViewById(R.id.leftNavigationViewContainer);

        View headerView = mNavigationView.getHeaderView(0);

        TextView githubTextView = (TextView) headerView.findViewById(R.id.myGitHubUrl);

        String herf = "<a href='https://github.com/fantianwen'>github</a>";
        githubTextView.setText(Html.fromHtml(herf));
        githubTextView.setMovementMethod(LinkMovementMethod.getInstance());

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.defaultSkin:
                        Toast.makeText(MainActivity.this, "defaultSkin", Toast.LENGTH_SHORT).show();
                        applySkin(0);

                        break;
                    case R.id.skinOne:
                        Toast.makeText(MainActivity.this, "skinOne", Toast.LENGTH_SHORT).show();
                        applySkin(1);

                        break;
                    default:
                        break;
                }

                return true;
            }
        });

    }

}