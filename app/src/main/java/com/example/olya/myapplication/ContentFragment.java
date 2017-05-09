package com.example.olya.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class ContentFragment extends Fragment {

    private int color1 = 0;
    private int color2 = 0;
    private int color3 = 0;
    int colors[] = { Color.rgb(255, 204, 229), Color.rgb(255, 204, 255), Color.rgb(229, 204, 255),
            Color.rgb(204, 204, 255), Color.rgb(204, 229, 255), Color.rgb(204, 255, 255),
            Color.rgb(204, 255, 204), Color.rgb(229, 255, 204), Color.rgb(255, 255, 204)};
    Random random = new Random();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        if (savedInstanceState != null){
            color1 = savedInstanceState.getInt("btn1");
            color2 = savedInstanceState.getInt("btn2");
            color3 = savedInstanceState.getInt("btn3");
        }

        final Button button = (Button) view.findViewById(R.id.button);
        final Button button2 = (Button) view.findViewById(R.id.button2);
        final Button button3 = (Button) view.findViewById(R.id.button3);

        if (color1 != 0){
            button.setBackgroundColor(color1);
        }
        if (color2 != 0){
            button2.setBackgroundColor(color2);
        }
        if (color3 != 0){
            button3.setBackgroundColor(color3);
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = random.nextInt(colors.length);
                button.setBackgroundColor(colors[pos]);
                color1 = colors[pos];
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = random.nextInt(colors.length);
                button2.setBackgroundColor(colors[pos]);
                color2 = colors[pos];
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = random.nextInt(colors.length);
                button3.setBackgroundColor(colors[pos]);
                color3 = colors[pos];
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("btn1", color1);
        outState.putInt("btn2", color2);
        outState.putInt("btn3", color3);
    }
}
