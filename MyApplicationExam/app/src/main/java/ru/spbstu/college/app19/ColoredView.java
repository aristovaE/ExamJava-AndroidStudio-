package ru.spbstu.college.app19;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by user on 14.03.2020.
 */
public class ColoredView extends View {
    public ColoredView(Context context,AttributeSet attrs){
        super(context,attrs);
    }
    public ColoredView(Context context){
        super(context);
    }
    public ColoredView(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);
    }
    public void setColor(int newColor){
       this.setBackgroundColor(newColor);
    }

}
