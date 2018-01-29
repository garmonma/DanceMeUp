package android.nni.com.dancemeup.fragments.registration;

import android.content.Context;
import android.nni.com.dancemeup.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by magma on 12/23/2017.
 */

public class PasswordFragment extends Fragment implements View.OnClickListener {
    public static String ARG_PASSWORD = "password";

    private static final String TAG = "Password Registration Fragment";

    OnCreateAccountButtonClicked mCallback;

    private EditText passwordField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registration_fragment_password, container, false);

        Button createAccountButton = v.findViewById(R.id.password_registration_continue_button);
        passwordField = v.findViewById(R.id.password_registration_input);

        createAccountButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.password_registration_continue_button) {
            onCreateAccountButtonClicked();
        }
    }

    private void onCreateAccountButtonClicked() {
        String password = passwordField.getText().toString();
        mCallback.onCreateAccountButtonPressed(password);
    }

    // Container Activity must implement this interface
    public interface OnCreateAccountButtonClicked {
        void onCreateAccountButtonPressed(String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnCreateAccountButtonClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnCreateAccountButtonClicked");
        }
    }
}