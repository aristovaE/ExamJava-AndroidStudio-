package ru.spbstu.college.app19;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by user on 04.03.2019.
 */
public class Adapter extends BaseAdapter {
    private final List<String> notes;
    Context context;
    public MyApp app;
	private final Random random=new Random();
    public Adapter(Context cont)
    {
        context = cont;
        app = (MyApp)context.getApplicationContext();
        notes = app.GetNotes();
    }
    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Context context = parent.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(getItemId(position)%2==0){
                view = inflater.inflate(R.layout.txt1, parent, false);
                ColoredView cv = (ColoredView) view.findViewById(R.id.newColor);
                cv.setColor(randomColor());
            }
            else{
                view = inflater.inflate(R.layout.txt2, parent, false);
                ImageView iv = (ImageView)view.findViewById(R.id.newColor);
                iv.setImageResource(R.drawable.sa);
            }

        }

        TextView TV = (TextView) view.findViewById(R.id.tView);
        TV.setText(app.GetNotes().get(position).toString());
        return view;
    }


    public int randomColor() {
        int first=random.nextInt(255) ;
		int second=random.nextInt(255) ;
		int third=random.nextInt(255);
		int color= Color.rgb(first, second, third);
		return color;
    }
}
