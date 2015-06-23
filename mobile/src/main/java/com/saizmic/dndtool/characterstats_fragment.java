package com.saizmic.dndtool;


import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Doug on 5/6/2015.
 */
public class characterstats_fragment extends Fragment {

    View rootview;
    TextView charName;
    Spinner classes;
    Spinner race;
    Spinner align;
    EditText armorclass;
    EditText initiative;
    EditText speed;
    EditText strstat;
    EditText dexstat;
    EditText constat;
    EditText intstat;
    EditText wisstat;
    EditText chastat;
    TextView strmod;
    TextView dexmod;
    TextView conmod;
    TextView intmod;
    TextView wismod;
    TextView chamod;


    View layout;
    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootview = inflater.inflate(R.layout.characterstats_layout, container, false);
        context = getActivity();
        sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key1), Context.MODE_PRIVATE);
        charName = (TextView) rootview.findViewById(R.id.charName);
        classes = (Spinner) rootview.findViewById(R.id.classesSpinner);
        race = (Spinner) rootview.findViewById(R.id.raceSpinner);
        align = (Spinner) rootview.findViewById(R.id.alignSpinner);
        armorclass = (EditText) rootview.findViewById(R.id.armorclass);
        initiative = (EditText) rootview.findViewById(R.id.initiative);
        speed = (EditText) rootview.findViewById(R.id.speed);
        strstat = (EditText) rootview.findViewById(R.id.strstat);
        dexstat = (EditText) rootview.findViewById(R.id.dexstat);
        constat = (EditText) rootview.findViewById(R.id.constat);
        intstat = (EditText) rootview.findViewById(R.id.intstat);
        wisstat = (EditText) rootview.findViewById(R.id.wisstat);
        chastat = (EditText) rootview.findViewById(R.id.chastat);
        strmod = (TextView) rootview.findViewById(R.id.strmod);
        dexmod = (TextView) rootview.findViewById(R.id.dexmod);
        conmod = (TextView) rootview.findViewById(R.id.conmod);
        intmod = (TextView) rootview.findViewById(R.id.intmod);
        wismod = (TextView) rootview.findViewById(R.id.wismod);
        chamod = (TextView) rootview.findViewById(R.id.chamod);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.classes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classes.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.races_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        race.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.align_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        align.setAdapter(adapter3);

        strstat.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateData();
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

        initData();


        return rootview;
    }





    @Override
    public void onPause() {
       saveData();
        super.onPause();
    }


    public void saveData(){
        editor = sharedPref.edit();
        editor.putString(getString(R.string.char_name), charName.getText().toString());
        editor.putInt(getString(R.string.classes), classes.getSelectedItemPosition());
        editor.putInt(getString(R.string.race), race.getSelectedItemPosition());
        editor.putInt(getString(R.string.align), align.getSelectedItemPosition());
        editor.putString(getString(R.string.ac), armorclass.getText().toString());
        editor.putString(getString(R.string.init), initiative.getText().toString());
        editor.putString(getString(R.string.speed), speed.getText().toString());
        editor.putString(getString(R.string.str_mod), strmod.getText().toString());
        editor.putString(getString(R.string.dex_mod), dexmod.getText().toString());
        editor.putString(getString(R.string.con_mod), conmod.getText().toString());
        editor.putString(getString(R.string.int_mod), intmod.getText().toString());
        editor.putString(getString(R.string.wis_mod), wismod.getText().toString());
        editor.putString(getString(R.string.cha_mod), chamod.getText().toString());
        editor.putString(getString(R.string.str_stat), strstat.getText().toString());
        editor.putString(getString(R.string.dex_stat), dexstat.getText().toString());
        editor.putString(getString(R.string.con_stat), constat.getText().toString());
        editor.putString(getString(R.string.int_stat), intstat.getText().toString());
        editor.putString(getString(R.string.wis_stat), wisstat.getText().toString());
        editor.putString(getString(R.string.cha_stat), chastat.getText().toString());
        editor.apply();
    }
    public void initData(){
        charName.setText(sharedPref.getString(getString(R.string.char_name), "default"));
        classes.setSelection(sharedPref.getInt(getString(R.string.classes), 0));
        race.setSelection(sharedPref.getInt(getString(R.string.race), 0));
        align.setSelection(sharedPref.getInt(getString(R.string.align), 0));
        armorclass.setText(sharedPref.getString(getString(R.string.ac), "0"));
        initiative.setText(sharedPref.getString(getString(R.string.init), "0"));
        speed.setText(sharedPref.getString(getString(R.string.speed), "0"));
        strstat.setText(sharedPref.getString(getString(R.string.str_stat), "0"));
        dexstat.setText(sharedPref.getString(getString(R.string.dex_stat), "0"));
        constat.setText(sharedPref.getString(getString(R.string.con_stat), "0"));
        intstat.setText(sharedPref.getString(getString(R.string.int_stat), "0"));
        wisstat.setText(sharedPref.getString(getString(R.string.wis_stat), "0"));
        chastat.setText(sharedPref.getString(getString(R.string.cha_stat), "0"));
    }

    public void updateData(){
        strmod.setText("STR+" + ((Integer.parseInt(strstat.getText().toString())) - 10) / 2);
        dexmod.setText("DEX+" + ((Integer.parseInt(dexstat.getText().toString())) - 10) / 2);
        conmod.setText("CON+" + ((Integer.parseInt(constat.getText().toString())) - 10) / 2);
        intmod.setText("INT+" + ((Integer.parseInt(intstat.getText().toString())) - 10) / 2);
        wismod.setText("WIS+" + ((Integer.parseInt(wisstat.getText().toString())) - 10) / 2);
        chamod.setText("CHA+" + ((Integer.parseInt(chastat.getText().toString())) - 10) / 2);
        initiative.setText("+" + (((Integer.parseInt(dexstat.getText().toString())) - 10) / 2));
        updateModifiers();
    }

    public void updateModifiers(){

    }

}

