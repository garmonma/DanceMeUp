package android.nni.com.dancemeup.utils;

import android.content.Context;
import android.nni.com.dancemeup.R;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by magma on 12/28/2017.
 */

public class ConnectListArrayAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;

    public ConnectListArrayAdapter(@NonNull Context context, String[] values) {
        super(context, R.layout.fragment_main_connect, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.connect_row_layout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        textView.setText(values[position]);

        return rowView;
    }
}