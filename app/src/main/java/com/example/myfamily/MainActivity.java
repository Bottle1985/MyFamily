package com.example.myfamily;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Name, Phone;
    DBHelper mybd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name= (EditText) findViewById(R.id.editText);
        Phone= (EditText) findViewById(R.id.editTextPhone);
        mybd = new DBHelper(this);
    }
    public void onClickTest(View view)
    {
        Name.setText("Bông is handsome");
        mybd.insertContact("Boong","0914451299","mrboongvn@yahoo.com.vn","Doan Tran Nghiep", "28");
        Toast.makeText(getApplicationContext(), "Test Successfully",
                Toast.LENGTH_SHORT).show();
    }
    public void onClickLoad(View view)
    {
        //means this is the view part not the add contact part.
        Cursor rs = mybd.getData(1);

        rs.moveToFirst();

        String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
        String phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
        String emai = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));
        String stree = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_STREET));
        String plac = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));
        Name.setText(nam);
        Phone.setText(phon);
        if (!rs.isClosed())  {
            rs.close();
        }

        Toast.makeText(getApplicationContext(), "Load Successfully",
               Toast.LENGTH_SHORT).show();
         //Toast.makeText(getApplicationContext(),  nam,
         //       Toast.LENGTH_SHORT).show();
    }

}
