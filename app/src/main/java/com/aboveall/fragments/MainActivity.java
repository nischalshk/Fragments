package com.aboveall.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonMain;

    private Boolean status=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMain=findViewById(R.id.buttonMain);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                if(status){
                    FirstFragment firstFragment=new FirstFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer,firstFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    buttonMain.setText("Load Second Fragment");
                    status=false;

                }else{
                    SecondFragment secondFragment=new SecondFragment();
                    fragmentTransaction.replace(R.id.fragmentContainer,secondFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    buttonMain.setText("Load First Fragment");
                    status=true;
                }
            }
        });
    }
}
