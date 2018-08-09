package com.rajon.sharehappiness;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class FoodsAdapter extends ArrayAdapter<Foods> {

    Context mCtx;
    int listLayoutRes;
    List<Foods> employeeList;
    SQLiteDatabase mDatabase;

    public FoodsAdapter(Context mCtx, int listLayoutRes, List<Foods> employeeList, SQLiteDatabase mDatabase) {
        super(mCtx, listLayoutRes, employeeList);

        this.mCtx = mCtx;
        this.listLayoutRes = listLayoutRes;
        this.employeeList = employeeList;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        //getting employee of the specified position
        Foods employee = employeeList.get(position);


        //getting views
        TextView textViewName =  (TextView) view.findViewById(R.id.textViewName);
        TextView textViewDept =  (TextView) view.findViewById(R.id.textViewDepartment);
        TextView textViewSalary =  (TextView) view.findViewById(R.id.textViewSalary);
        TextView textViewJoiningDate =  (TextView) view.findViewById(R.id.textViewJoiningDate);

        //adding data to views
        textViewName.setText(employee.getName());
        textViewDept.setText(employee.getDept());
        textViewSalary.setText(String.valueOf(employee.getSalary()));
        textViewJoiningDate.setText(employee.getJoiningDate());

        //we will use these buttons later for update and delete operation
        Button buttonDelete = (Button) view.findViewById(R.id.buttonDeleteEmployee);
        Button buttonEdit = (Button) view.findViewById(R.id.buttonEditEmployee);

        return view;
    }
}