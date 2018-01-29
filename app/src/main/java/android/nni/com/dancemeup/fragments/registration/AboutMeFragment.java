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

public class AboutMeFragment extends Fragment implements View.OnClickListener{
    public static String ARG_POSITION = "AboutMe_Fragment";

    private static final String TAG = "AboutMe Registration Fragment";

    OnDoneButtonClicked mCallback;

    private EditText dancesField, genderField;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.registration_fragment_aboutme, container, false);

        Button doneButton = v.findViewById(R.id.aboutme_registration_done_button);
        dancesField = v.findViewById(R.id.aboutme_registration_dances_input);
        genderField = v.findViewById(R.id.aboutme_registration_gender_input);

        doneButton.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.aboutme_registration_done_button) {
            onCreateAccountButtonClicked();
        }
    }

    private void onCreateAccountButtonClicked() {
        String dances = dancesField.getText().toString();
        String gender = genderField.getText().toString();
        mCallback.onDoneButtonPressed(dances, gender);
    }

    // Container Activity must implement this interface
    public interface OnDoneButtonClicked {
        void onDoneButtonPressed(String dances, String gender);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnDoneButtonClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnCreateAccountButtonClicked");
        }
    }
}
