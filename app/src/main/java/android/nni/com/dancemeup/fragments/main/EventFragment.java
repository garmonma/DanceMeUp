package android.nni.com.dancemeup.fragments.main;

import android.support.v4.app.Fragment;
import android.nni.com.dancemeup.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by magma on 12/26/2017.
 */

public class EventFragment extends Fragment implements View.OnClickListener {


    public View onCreatView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.main_fragment_event, container, false);

        return v;
    }

    @Override
    public void onClick(View view) {

    }
}
