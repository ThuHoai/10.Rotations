package com.example.hoaiktt.a10rotations;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout mMainLayout;
    private Button mBtnAddMess;
    private EditText mEdtMesseage;
    private Messeage mInfo;
    private ArrayList<Messeage> mDataMesseage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainLayout = (LinearLayout) findViewById(R.id.id_your_linear_layout);
        mBtnAddMess = (Button) findViewById(R.id.btnAdd);
        mEdtMesseage = (EditText) findViewById(R.id.edtMesseage);
        mBtnAddMess.setOnClickListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("data", mDataMesseage);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Messeage> listMesseage = (ArrayList<Messeage>) savedInstanceState.getSerializable("data");
        if(listMesseage !=null){
            for (Messeage messeage: listMesseage) {
                mMainLayout.addView(makeColumn(messeage.getmContent()));
            }
        }

    }

    private TextView makeColumn(String text) {
        TextView tvShowMesseage = new TextView(this);
        tvShowMesseage.setTextSize(getResources().getDimension(R.dimen.btn_text_size));
        tvShowMesseage.setText(text);
        return tvShowMesseage;
    }

    @Override
    public void onClick(View view) {
        String mText = mEdtMesseage.getText().toString();
        mInfo = new Messeage(mText);
        mDataMesseage.add(mInfo);
        mMainLayout.addView(makeColumn(mInfo.getmContent()));
    }
}
