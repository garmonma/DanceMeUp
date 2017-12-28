package android.nni.com.dancemeup.activities;

import android.content.Intent;
import android.nni.com.dancemeup.R;
import android.nni.com.dancemeup.entities.Profile;
import android.nni.com.dancemeup.entities.User;
import android.nni.com.dancemeup.fragments.registration.AboutMeFragment;
import android.nni.com.dancemeup.fragments.registration.EmailRegistrationFragment;
import android.nni.com.dancemeup.fragments.registration.PasswordFragment;
import android.nni.com.dancemeup.service.ProfileService;
import android.nni.com.dancemeup.service.ServerCallback;
import android.nni.com.dancemeup.service.UserService;
import android.os.Bundle;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by magma on 12/22/2017.
 */

public class RegistrationActivity extends AppCompatActivity
        implements EmailRegistrationFragment.OnContinueButtonClicked,
        PasswordFragment.OnCreateAccountButtonClicked,
        AboutMeFragment.OnDoneButtonClicked{

    private static final String TAG = "Registration Activity";

    private User newUser;
    private Profile newProfile;

    private UserService userService;
    private ProfileService profileService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        newUser =  new User();
        newProfile = new Profile();

        userService = new UserService(this);
        profileService = new ProfileService(this);

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            EmailRegistrationFragment firstFragment = new EmailRegistrationFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    private void proceed(Fragment fragment, int step){
        Bundle args = new Bundle();

        switch(step){
            case 2:
                args.putString(PasswordFragment.ARG_PASSWORD, newProfile.getEmail());
                break;
        }

        fragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onContinuePress(String email) {
        newUser.setUsername(email);
        newProfile.setEmail(email);

        PasswordFragment fragment = new PasswordFragment();
        proceed(fragment, 2);
    }

    @Override
    public void onCreateAccountButtonPressed(String password) {
        newUser.setPassword(password);

        Log.i(TAG, "Password : " + password);
        // Add some type of loading sequence here while the service validates and creates the account.

        boolean success = userService.createUser(newUser);

        if(success){
            AboutMeFragment fragment = new AboutMeFragment();
            proceed(fragment, 3);
        }
    }

    @Override
    public void onDoneButtonPressed(String dances, String gender) {
        newProfile.setDances(dances);
        newProfile.setGender(gender);

        Log.i(TAG, newProfile.toString());

        final Intent intent = new Intent(this, MainActivity.class);
        profileService.createProfile(newProfile, new ServerCallback() {
            @Override
            public void onSuccess(JSONObject result) {
                Gson gson = new Gson();
                Profile profile = gson.fromJson(result.toString(), Profile.class);
                Log.i(TAG, profile.toString());
                intent.putExtra("profile", profile);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}