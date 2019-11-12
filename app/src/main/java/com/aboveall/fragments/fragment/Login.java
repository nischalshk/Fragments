package com.aboveall.fragments.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.classassignment.myapplication.Dashboard;
import com.classassignment.myapplication.R;
import com.classassignment.myapplication.TestLogin;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    TextView et_login_name, et_login_pwd;
    Button btnLogin;

    private String Username, Password;
    boolean status;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = view.findViewById(R.id.btnLogin);
        et_login_name = view.findViewById(R.id.et_login_name);
        et_login_pwd = view.findViewById(R.id.et_login_pwd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username = edname.getText().toString().trim();
                Password = edpwd.getText().toString().trim();

                if (!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {

                    TestLogin testLogin = new TestLogin();
                    testLogin.setusername(Username);
                    testLogin.setPassword(Password);
                    status = testLogin.tstLogin();

                    if (status) {
                        Toast.makeText(getActivity(), "Login Successful" + Username, Toast.LENGTH_SHORT).show();
                        edname.setText("");
                        edpwd.setText("");

                        Intent intent = new Intent(getActivity(), Dashboard.class);
                        intent.putExtra(EXTRA_MESSAGE, Username);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "Username and Password does not match", Toast.LENGTH_LONG).show();
                        edname.setText("");
                        edpwd.setText("");
                    }
                } else {
                    if (TextUtils.isEmpty(Username)) {
                        edname.setError("Enter name");
                    }
                    if (TextUtils.isEmpty(Password)) {
                        edpwd.setError("Enter password");
                        return;
                    }
                }
            }
        });


        return view;
    }
}
