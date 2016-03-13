package kmikusek.tabuvoice;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public abstract class ActivityState<STATE_CONTEXT> extends AbstractState<STATE_CONTEXT>{

    public boolean onCreateOptionsMenuHandled(Menu menu) {
        return false;
    }

    public boolean onActivityResultHandled(int requestCode, int resultCode, Intent data) {
        return false;
    }

    public boolean onBackPressHandled() {
        return false;
    }

    public boolean onOptionsItemSelectHandled(MenuItem item) {
        return false;
    }

    public void onActivityDestroy() {
    }

}
