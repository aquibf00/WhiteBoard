package Aith.ac.w;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends  AppCompatActivity {

    Button up,down,change,undo,clear;
    DrawableViewConfig config;
    DrawableView drawableView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawableView = findViewById(R.id.ma_paintview);
        up = findViewById(R.id.ma_wi);
        down = findViewById(R.id.ma_wd);
        change = findViewById(R.id.ma_color);
        undo = findViewById(R.id.ma_undo);

        clear = findViewById(R.id.ma_clear);

        config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.holo_red_light));

        config.setShowCanvasBounds(true);
        config.setMinZoom(1.0f);
        config.setMaxZoom(3.0f);
        config.setCanvasHeight(1920);
        config.setCanvasWidth(1920);

        drawableView.setConfig(config);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth()+5);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth()-5);
            }

        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                config.setStrokeColor(Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256)));
            }
        });
        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawableView.undo();
            }

        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                drawableView.clear();
//                Intent in= new Intent(MainActivity.this,Main3Activity.class);
//                startActivity(in);
            }

        });

    }
}
