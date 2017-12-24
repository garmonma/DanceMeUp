package android.nni.com.dancemeup.fragments.registration;

import android.app.Activity;
import android.content.Context;
import android.nni.com.dancemeup.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by magma on 12/23/2017.
 */

public class EmailRegistrationFragment extends Fragment implements View.OnClickListener {
    public static String ARG_POSITION = "EmailRegistration_Fragment";

    private static final String TAG = "Registration Activity";

    OnContinueButtonClicked mCallback;

    private EditText emailText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_email_registration, container, false);

        Button continueButton = (Button)v.findViewById(R.id.email_registration_continue_button);
        emailText = (EditText)v.findViewById(R.id.email_registration_input);

        continueButton.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.email_registration_continue_button) {
            onContinueButtonClicked();
        }
    }

    // Container Activity must implement this interface
    public interface OnContinueButtonClicked {
        void onContinuePress(String email);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnContinueButtonClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    private void onContinueButtonClicked(){
        String email = emailText.getText().toString();
        mCallback.onContinuePress(email);
    }
}