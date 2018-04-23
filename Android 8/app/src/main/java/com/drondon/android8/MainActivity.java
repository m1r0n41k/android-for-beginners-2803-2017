package com.drondon.android8;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.madrapps.pikolo.HSLColorPicker;
import com.madrapps.pikolo.listeners.OnColorSelectionListener;

public class MainActivity extends AppCompatActivity {

    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_app_background);
        // getWindow().getDecorView().setBackground(drawable);

        /*  <ImageView
        app:srcCompat="@drawable/ic_if_google" />*/

        //ImageView logoImageView = findViewById(R.id.imageView);
        //logoImageView.setImageResource(R.drawable.ic_if_google);

        background = findViewById(R.id.background);

        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
            }
        });

        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColorPickerDialog(v);
            }
        });
    }

    private void showColorPickerDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        HSLColorPicker colorPicker = new HSLColorPicker(v.getContext());
        colorPicker.setColorSelectionListener(new OnColorSelectionListener() {
            @Override
            public void onColorSelected(int i) {

            }

            @Override
            public void onColorSelectionStart(int i) {

            }

            @Override
            public void onColorSelectionEnd(int i) {

            }
        });
        builder.setView(colorPicker);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void showTimePicker(View v) {
        new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Использовать
            }
        }, 12, 0, false).show();
    }

    private void upload() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Upload!");
        builder.setMessage("Мы попытаемся загрузить много иформации через ваш слабый интернет! Вы согласны?");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNeutralButton("Незнаю!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private static final int REQUEST_CODE = 950;

    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            background.setImageBitmap(imageBitmap);
        }
    }


    private Menu menu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.app_main_manu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (System.currentTimeMillis() == 0) {
            MenuItem item = menu.findItem(R.id.about);
            if (item != null) {
                item.setEnabled(false);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
