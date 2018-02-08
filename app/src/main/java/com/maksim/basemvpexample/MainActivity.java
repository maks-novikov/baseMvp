package com.maksim.basemvpexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainView {

    private EditText nameInput, ageInput;
    private TextView userInfo;
    private Button saveBtn;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = (EditText) findViewById(R.id.name_input);
        ageInput = (EditText) findViewById(R.id.age_input);
        saveBtn = (Button) findViewById(R.id.save_btn);
        userInfo = (TextView) findViewById(R.id.user_info_tv);

        saveBtn.setOnClickListener(this);

        mPresenter = new MainPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.save_btn){
            String name = nameInput.getText().toString();
            String age = ageInput.getText().toString();
            mPresenter.updateUser(name, age);
        }
    }

    @Override
    public void setUserTv(String info) {
        userInfo.setText(info);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
