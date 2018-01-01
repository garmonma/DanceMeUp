package android.nni.com.dancemeup.fragments.main;

import android.content.Context;
import android.nni.com.dancemeup.utils.ConnectListArrayAdapter;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.nni.com.dancemeup.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by magma on 12/26/2017.
 */

public class ConnectFragment extends ListFragment implements View.OnClickListener {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] values = new String[]{
                "Value One", "Value Two", "Value Three", "Value Four",
                "Value Five", "Value Six", "Value Seven", "Value Eight"};

        ConnectListArrayAdapter adapter = new ConnectListArrayAdapter(getContext(), values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO implement some logic
    }

    @Override
    public void onClick(View view) {

    }
}
