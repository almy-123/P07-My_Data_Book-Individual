package sg.edu.rp.id19037610.p07_mydatabook;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AnnFrag extends Fragment {

    Button btnEdit;
    TextView tvItems;

    public AnnFrag() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ann, container, false);

        btnEdit = view.findViewById(R.id.btnEdit);
        tvItems = view.findViewById(R.id.tvItems);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MainActivity().setData(getContext(), "Anniversary", tvItems);
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        String entered = tvItems.getText().toString();

        if (!entered.isEmpty()) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
            SharedPreferences.Editor prefEdit = prefs.edit();

            prefEdit.putString("Ann", entered);
            prefEdit.commit();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext().getApplicationContext());
        String data = prefs.getString("Ann", "");
        tvItems.setText(data);
    }
}