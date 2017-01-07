package com.yukang.logininterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 帐号密码登陆框
    private ImgEditText accountIet, pwdIet;
    // 用来判断显示明文或者密码（同时修改显示的图片）
    private boolean isHidden = true;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        accountIet = (ImgEditText) findViewById(R.id.accountIet);
        accountIet.setDrawableClick(new ImgEditText.IMyRightDrawableClick() {
            @Override
            public void rightDrawableClick() {
                accountIet.setText("");
            }
        });
        pwdIet = (ImgEditText) findViewById(R.id.pwdIet);
        pwdIet.setDrawableClick(new ImgEditText.IMyRightDrawableClick() {
            @Override
            public void rightDrawableClick() {
                if (isHidden) {
                    // 设置EditText文本为可见的
                    pwdIet.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    pwdIet.setRightDrawable(getResources().getDrawable(R.mipmap.eye_selected));
                } else {
                    // 设置EditText文本为隐藏的
                    pwdIet.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    pwdIet.setRightDrawable(getResources().getDrawable(R.mipmap.eye_normal));
                }
                isHidden = !isHidden;
                pwdIet.postInvalidate();
                
                // 切换后将EditText光标置于末尾
                CharSequence charSequence = pwdIet.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });

        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
