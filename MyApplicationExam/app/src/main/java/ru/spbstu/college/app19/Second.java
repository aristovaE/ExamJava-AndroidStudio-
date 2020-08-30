package ru.spbstu.college.app19;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 429281-8 on 12.11.2018.
 */
public class Second extends BaseActivity{
    EditText et;
    Button btn;
    TextWatcher textLooker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        et = (EditText) findViewById(R.id.eText);
        btn = (Button) findViewById(R.id.okBtn);
        Bundle extras = getIntent().getExtras();
        btn.setEnabled(false);
        if (extras != null)
            et.setText(extras.getString(MY_TXT));
        textLooker = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et.getText().toString().trim().length() > 0)
                    btn.setEnabled(true);
                else
                    btn.setEnabled(false);
            }
            @Override
            public void afterTextChanged(Editable s) { }
        };
        et.addTextChangedListener(textLooker);
    }

    public void onOk(View view){
        Intent intent=getIntent();
        intent.putExtra(MY_TXT, et.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
    public void Cancel(View view){
        Intent intent=getIntent();
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
