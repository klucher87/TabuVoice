package kmikusek.tabuvoice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

public interface FragmentChanger {

    default Fragment changeFragment(Fragment newFragment, int containerId, FragmentManagerProvider fragmentManagerProvider, boolean withBackstack) {
        return changeFragment(newFragment, containerId, fragmentManagerProvider, withBackstack, false);
    }

    default Fragment changeFragment(Fragment newFragment, int containerId, FragmentManagerProvider fragmentManagerProvider, boolean withBackstack,
                                       boolean allowStateLoss) {
        FragmentTransaction transaction = fragmentManagerProvider.provideFragmentManager().beginTransaction();

        transaction.replace(containerId, newFragment);

        if (withBackstack) {
            transaction.addToBackStack(newFragment.getClass().getName());
        }

        if (allowStateLoss) {
            transaction.commitAllowingStateLoss();
        } else {
            transaction.commit();
        }

        return newFragment;
    }
}
