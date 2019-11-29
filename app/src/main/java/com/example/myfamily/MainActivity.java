package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Phone, Email, Street, Select;
    TextView Total;
    DBHelper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editText);
        Phone= (EditText) findViewById(R.id.editTextPhone);
        Email= (EditText) findViewById(R.id.editTextEmail);
        Street= (EditText) findViewById(R.id.editTextStreet);
        Select= (EditText) findViewById(R.id.editTextSelect);

        Total=(TextView) findViewById(R.id.textViewTotal);
        myDatabase = new DBHelper(this);
    }
    public void onClickTest(View view)
    {
        int total;
        Name.setText("Bông is handsome");
        //myDatabase.insertContact("Boong","0914451299","mrboongvn@yahoo.com.vn","Doan Tran Nghiep", "28");
        //myDatabase.insertContact("Trang","0986005641","latttrang@gmail.com","Doan Tran Nghiep", "28");

        total = myDatabase.numberOfRows();
        Total.setText("Bông" + total);
        Toast.makeText(getApplicationContext(), "Test Successfully",
                Toast.LENGTH_SHORT).show();
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
         //Toast.makeText(getApplicationContext(),  nam,
         //       Toast.LENGTH_SHORT).show();
    }

}
