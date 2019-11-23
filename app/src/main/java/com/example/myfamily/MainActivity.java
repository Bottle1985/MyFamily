package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper mybd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickTest(View view)
    {
        Toast.makeText(getApplicationContext(), "Test Successfully",
                Toast.LENGTH_SHORT).show();
    }


}
