package ru.spbstu.college.app19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * Created by 429281-8 on 12.11.2018.
 */
public class Main extends BaseActivity implements AdapterView.OnItemClickListener {
    private Adapter arad;
    private ListView lView;
    public MyApp app;
    private List<String> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        app = (MyApp)getApplicationContext();
        notes = app.GetNotes();
        arad = new Adapter(this.getApplicationContext());
        lView = (ListView) findViewById(R.id.lView);
        lView.setOnItemClickListener(this);
        lView.setAdapter(arad);

    }

    public void Add(View view) {
        Intent intent = new Intent(this, Second.class);
        startActivityForResult(intent, MY_ADD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        Bundle extras = data.getExtras();
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case MY_ADD:
                    app.Add(extras.getString(MY_TXT));
                    break;
                case MY_EDIT:
                    app.Edit(extras.getInt(MY_ID), extras.getString(MY_TXT));
                    break;
            }
            lView.invalidateViews();
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(MY_TXT, app.GetNotes().get(position).toString());
        intent.putExtra(MY_ID, position);
        startActivityForResult(intent, MY_EDIT);
    }
}