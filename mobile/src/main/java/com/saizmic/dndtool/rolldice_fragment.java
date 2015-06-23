package com.saizmic.dndtool;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Doug on 4/29/2015.
 */
public class rolldice_fragment extends Fragment {
    View rootview;
    Button button;
    SeekBar bar1, bar2;
    TextView results, sides, dice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        rootview = inflater.inflate(R.layout.charactertab_layout, container, false);
        button = (Button) rootview.findViewById(R.id.rollRNGButton);
        bar1 = (SeekBar) rootview.findViewById(R.id.seekSideNum);
        bar2 = (SeekBar) rootview.findViewById(R.id.seekDiceNum);
        results = (TextView) rootview.findViewById(R.id.results);
        sides = (TextView) rootview.findViewById(R.id.textSideNum);
        dice = (TextView) rootview.findViewById(R.id.textDiceNum);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int s = bar1.getProgress();
                    int d = bar2.getProgress();
                    results.setText(rollDice(Integer.parseInt(progConvert(s)), d));
            }
        }
        );
        bar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String d = progConvert(progress);
                sides.setText("d" + d);
                button.setText("Roll: " + dice.getText() + "" + sides.getText());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                dice.setText((progress + 1) + "");
                button.setText("Roll: " + dice.getText() + "" + sides.getText());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return rootview;

    }

    public String rollDice(int numSides, int numDice){
        Random rand = new Random();
        int a = 0;
        String s = "";
        for(int i=0; i<=numDice;i++)
        {
            int r = rand.nextInt(numSides)+1;
            a += r;
            s += r + " ";
        }
        s += "=\n("+ a +")";

        return s;
    }
    public int[] rollDiceArray(int numSides, int numDice){
        Random rand = new Random();
        int[] a = new int[numDice];
        for(int i=0; i<=numDice;i++)
        {
            int r = rand.nextInt(numSides)+1;
            a[i] = r;
        }
        return a;

    }
    private String progConvert(int progress){
        switch(progress) {
            case 0:
                return "2";
            case 1:
                return "4";
            case 2:
                return "6";
            case 3:
                return "8";
            case 4:
                return "10";
            case 5:
                return "12";
            case 6:
                return "20";
            case 7:
                return "100";
        }
        return "ERROR";
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("last_rolled", (String)results.getText());
        super.onSaveInstanceState(outState);
    }
}
