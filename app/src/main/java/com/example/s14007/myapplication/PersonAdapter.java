package com.example.s14007.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by com.swift_studying. on 15/10/21.
 */
public class PersonAdapter extends BaseAdapter{
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Person> personList;
    ArrayList<Person> selectPerson;

    public PersonAdapter(Context context, ArrayList<Person> personList){
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.personList = personList;
    }

    @Override
    public int getCount(){
        return personList.size();
    }

    @Override
    public Object getItem(int position){
        return personList.get(position);
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        convertView = layoutInflater.inflate(R.layout.person_listview_cell, parent, false);
        final TextView nameView = (TextView)convertView.findViewById(R.id.nameTextView);
        nameView.setText(personList.get(position).getName());

        TextView hobbyView = (TextView)convertView.findViewById(R.id.hobbyTextView);
        hobbyView.setText(personList.get(position).getHobby());




//        ArrayList<Person> selectPerson = new ArrayList<Person>();
        final CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.checkbox);

        selectPerson = new ArrayList<Person>();
//        final ArrayList<Person> finalSelectPerson = selectPerson;
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {

                    selectPerson.add(personList.get(position));
                    Log.e("select:", selectPerson.get(selectPerson.size() - 1).getName());
                } else {
                    selectPerson.remove(personList.get(position));
                }
            }
        });

        return convertView;
    }

    public List getSelectList() {
        return selectPerson;
    }
}
