package com.assessment.Core.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.assessment.Helper.Validation;
import com.assessment.MainActivity;
import com.assessment.R;
import com.github.florent37.viewtooltip.ViewTooltip;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akhil on 12/10/18.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.editTextEmail)
    EditText editTextEmail;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    @BindView(R.id.loginButton)
    AppCompatButton loginButton;
    @BindView(R.id.progressBar_cyclic)
    ProgressBar progressBar_cyclic;
    boolean isToolTipVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initClick();
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

            @Override
            public void afterTextChanged(Editable s) {
                checkButtonState();
            }
        });
        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkButtonState();
            }
        });
        editTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (!isToolTipVisible) {
                        ViewTooltip
                                .on(LoginActivity.this, editTextPassword)
                                .clickToHide(true)
                                .duration(5000)
                                .corner(30)
                                .arrowWidth(30)
                                .arrowHeight(30)
                                .padding(50, 50, 50, 50)
                                .distanceWithView(15)
                                .textColor(ContextCompat.getColor(LoginActivity.this, R.color.white))
                                .color(ContextCompat.getColor(LoginActivity.this, R.color.colorPrimary))
                                .position(ViewTooltip.Position.TOP)
                                .text(getString(R.string.password_message))
                                .onDisplay(new ViewTooltip.ListenerDisplay() {
                                    @Override
                                    public void onDisplay(View view) {
                                        isToolTipVisible = true;
                                    }
                                })
                                .onHide(new ViewTooltip.ListenerHide() {
                                    @Override
                                    public void onHide(View view) {
                                        isToolTipVisible = false;
                                    }
                                })
                                .show();
                    }
                }
            }
        });
    }
    public void initClick(){
        loginButton.setOnClickListener(this);
    }
    private void checkButtonState() {
        if (!TextUtils.isEmpty(editTextEmail.getText().toString())
                && !TextUtils.isEmpty(editTextPassword.getText().toString())
                && Validation.isValidEmailAddress(editTextEmail.getText().toString())
                && Validation.passwordValidation(editTextPassword.getText().toString())) {
            loginButton.setAlpha(1f);
            loginButton.setEnabled(true);
        } else {
            loginButton.setAlpha(0.7f);
            loginButton.setEnabled(false);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                progressBar_cyclic.setVisibility(View.VISIBLE);
                loginIntent();
                break;
        }
    }
    public void loginIntent(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar_cyclic.setVisibility(View.GONE);
                //startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        },1000);
    }
}
