package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Name, Phone, Email, Street, Select, Place;
    TextView Total;
    private ListView obj;
    DBHelper myDatabase;
    int totalRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editText);
        Phone= (EditText) findViewById(R.id.editTextPhone);
        Email= (EditText) findViewById(R.id.editTextEmail);
        Street= (EditText) findViewById(R.id.editTextStreet);
        Select= (EditText) findViewById(R.id.editTextSelect);
        Place= (EditText) findViewById(R.id.editTextPlace);

        Total=(TextView) findViewById(R.id.textViewTotal);
        myDatabase = new DBHelper(this);
        // Show all record from contact
        ArrayList array_list = myDatabase.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);
        obj = (ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);

        // Show total record
        totalRecord = myDatabase.numberOfRows();
        Total.setText("Record " + totalRecord);
    }
    public void onClickTest(View view)
    {
        totalRecord  = myDatabase.numberOfRows();
        if (totalRecord!=0) {
            Name.setText("Bông is handsome");
        }
        else {
            myDatabase.insertContact("Boong", "0914451299", "mrboongvn@yahoo.com.vn", "Doan Tran Nghiep", "28");
            myDatabase.insertContact("Trang", "0986005641", "latttrang@gmail.com", "Doan Tran Nghiep", "28");
            Toast.makeText(getApplicationContext(), "Test Successfully",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickLoad(View view)
    {
        //means this is the view part not the add contact part.
        int index = Integer.parseInt(Select.getText().toString());
        Cursor rs = myDatabase.getData(index);

        rs.moveToFirst();

        String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
        String phone = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
        String email = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));
        String street = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_STREET));
        String place = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));
        Name.setText(nam);
        Phone.setText(phone);
        Email.setText(email);
        Street.setText(street);
        if (!rs.isClosed())  {
            rs.close();
        }

        Toast.makeText(getApplicationContext(), "Load Successfully",
               Toast.LENGTH_SHORT).show();

    }
    public void onClickSave(View view) {
        if(myDatabase.insertContact(Name.getText().toString(), Phone.getText().toString(),
                Email.getText().toString(), Street.getText().toString(),
                Place.getText().toString())){
            Toast.makeText(getApplicationContext(), "Save Successfully",
                    Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), "Save not done",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
