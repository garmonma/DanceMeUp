package android.nni.com.dancemeup.fragments.registration;

import android.content.Context;
import android.nni.com.dancemeup.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by magma on 12/23/2017.
 */

public class PasswordFragment extends Fragment {
    public static String ARG_PASSWORD = "password";

    OnCreateAccountButtonClicked mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_registration, container, false);
    }

    // Container Activity must implement this interface
    public interface OnCreateAccountButtonClicked {
        public void onCreateAccountButtonPressed(String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (PasswordFragment.OnCreateAccountButtonClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}