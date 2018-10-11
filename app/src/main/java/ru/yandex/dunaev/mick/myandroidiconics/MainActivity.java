package ru.yandex.dunaev.mick.myandroidiconics;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.mikepenz.iconics.view.IconicsImageView;

import androidx.appcompat.app.AppCompatActivity;
import uz.shift.colorpicker.LineColorPicker;
import uz.shift.colorpicker.OnColorChangedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineColorPicker colorPicker = (LineColorPicker) findViewById(R.id.picker);

// set color palette
        colorPicker.setColors(new int[] {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW});

// set selected color [optional]
        colorPicker.setSelectedColor(Color.RED);

// set on change listener
        colorPicker.setOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int c) {

                IconicsImageView imageView = (IconicsImageView)findViewById(R.id.iconicsImageView);

                Log.d("Test", "Selected color " + Integer.toHexString(c));
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }
}
