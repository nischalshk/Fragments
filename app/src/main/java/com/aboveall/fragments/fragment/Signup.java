package com.aboveall.fragments.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.classassignment.myapplication.R;
import com.classassignment.myapplication.TestLogin;
import com.classassignment.myapplication.User;

import java.util.ArrayList;
import java.util.List;


public class Signup extends Fragment {
    ArrayList<String> addArray = new ArrayList<String>();
    EditText etname, etpwd, etcpwd;
    Button btn;
    private String Username, Password, Cpassword;

    static List<User> userList = new ArrayList<>();


    public Signup() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        etname = view.findViewById(R.id.etname);
        etpwd = view.findViewById(R.id.etpwd);
        etcpwd = view.findViewById(R.id.etcpwd);
        btn = view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username = etname.getText().toString().trim();
                Password = etpwd.getText().toString().trim();
                Cpassword = etcpwd.getText().toString().trim();

                if (!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {
                    if (!Password.equals(Cpassword)) {
                        etcpwd.setError("Password does not match");
                        onStop();
                    } else {
                        User user = new User();
                        user.setUser(Username);
                        user.setPsd(Password);
                        userList.add(user);

                        TestLogin testLogin = new TestLogin();
                        testLogin.setUserList(userList);

                        for (int i = 0; i < testLogin.getUserList().size(); i++) {
                            final User userdetail = testLogin.getUserList().get(i);
                            Toast.makeText(getActivity(), "" + userdetail.getUser(), Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getActivity(), "Signup Sucessful", Toast.LENGTH_LONG).show();
                        etname.setText("");
                        etpwd.setText("");
                        etcpwd.setText("");

                    }
                } else {
                    if (TextUtils.isEmpty(Username)) {
                        etname.setError("Enter Name");
                    }
                    if (TextUtils.isEmpty(Password)) {
                        etpwd.setError("Enter Password");
                    }
                    if (TextUtils.isEmpty(Cpassword)) {
                        etcpwd.setError("Confirm Password");
                    }
                    return;
                }

            }

        });

        return view;
    }

}
