package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    DBHelper mybd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editText);
    }
    public void onClickTest(View view)
    {
        Name.setText("Bông is handsome");
        Toast.makeText(getApplicationContext(), "Test Successfully",
                Toast.LENGTH_SHORT).show();
    }


}
