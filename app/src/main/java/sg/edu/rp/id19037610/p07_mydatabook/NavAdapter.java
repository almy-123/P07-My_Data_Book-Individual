package sg.edu.rp.id19037610.p07_mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NavAdapter extends ArrayAdapter<String> {

    private String[] titles;
    private ImageView iv;
    private TextView tvTitle;
    private Context context;
    private ArrayList<Integer> icons;

    public NavAdapter(Context context, int resource, String[] titles) {
        super(context, resource, titles);
        this.context = context;
        this.titles = titles;

        icons = new ArrayList<Integer>();
        icons.add(android.R.drawable.ic_dialog_info);
        icons.add(android.R.drawable.ic_menu_edit);
        icons.add(android.R.drawable.ic_menu_today);
        icons.add(android.R.drawable.star_big_on);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.nav_row, parent, false);

        iv = view.findViewById(R.id.ivIcon);
        tvTitle = view.findViewById(R.id.tvTitle);

        iv.setImageResource(icons.get(position));
        tvTitle.setText(titles[position]);

        return view;
    }
}
