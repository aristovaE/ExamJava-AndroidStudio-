package ru.spbstu.college.app19;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.03.2019.
 */
public class MyApp extends Application {
    private final List<String> notes = new ArrayList<>();


    public MyApp() {
        super();
        notes.add("Record 1");
        notes.add("Record 2");
    }

    public List<String> GetNotes() {
        return notes;
    }

    public void Add(String inString) {
        notes.add(inString);
        //tH.Show(getString(R.string.added));
    }
    public void Edit(int Id, String inString) {
        notes.set(Id, inString);
       // tH.Show(getString(R.string.edited));
    }
}
