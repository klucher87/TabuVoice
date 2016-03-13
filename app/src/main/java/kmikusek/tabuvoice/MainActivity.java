package kmikusek.tabuvoice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentChanger, FragmentManagerProvider, StateChangerProvider<ActivityState, MainActivity> {

    private StateChanger<ActivityState, MainActivity> stateChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stateChanger = new StateChanger<>(this);
    }

    public void changeFragment(Fragment fragment) {
        changeFragment(fragment, R.id.root_container, this, false);
    }

    public void changeFragment(Fragment fragment, boolean withBackstack) {
        changeFragment(fragment, R.id.root_container, this, withBackstack);
    }

    @Override
    public FragmentManager provideFragmentManager() {
        return getSupportFragmentManager();
    }

    @Override
    public StateChanger<ActivityState, MainActivity> provideStateChanger() {
        return stateChanger;
    }
}
