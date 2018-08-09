package com.rajon.sharehappiness;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.rajon.sharehappiness.Data;
import com.rajon.sharehappiness.SQLiteDBHelper;
public class DonateActivity extends AppCompatActivity{

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Data Datasource=new Data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_donate);

        //To hide AppBar for fullscreen.
        ActionBar ab = getSupportActionBar();
        //ab.hide();

        openHelper = new SQLiteDBHelper(this);

        //Referencing EditText widgets and Button placed inside in xml layout file
        final EditText _txttitle = (EditText) findViewById(R.id.editTextName);
        final EditText _txttype = (EditText) findViewById(R.id.editTextSalary);
        final EditText _txtdetails = (EditText) findViewById(R.id.editTextSalary3);
        final EditText _txtlocation = (EditText) findViewById(R.id.editTextSalary2);
        Button _btnadd = (Button) findViewById(R.id.buttonAdd);

        //Register Button Click Event
        _btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db = openHelper.getWritableDatabase();

                String title = _txttitle.getText().toString();
                String type = _txttype.getText().toString();
                String details = _txtdetails.getText().toString();
                String location = _txtlocation.getText().toString();

                //Calling InsertData Method - Defined below
                Datasource.InsertData(title, type, details, location);

                //Alert dialog after clicking the Register Account
                final AlertDialog.Builder builder = new AlertDialog.Builder(DonateActivity.this);
                builder.setTitle("Information");
                builder.setMessage("Thanks for sharing happiness");
                builder.setPositiveButton("Welcome", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //Finishing the dialog and removing Activity from stack.
                        dialogInterface.dismiss();
                        finish();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

    }

    //Inserting Data into database - Like INSERT INTO QUERY.


    //In this method we will do the create operation

}