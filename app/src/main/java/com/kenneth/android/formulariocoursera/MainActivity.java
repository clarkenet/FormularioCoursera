package com.kenneth.android.formulariocoursera;

import android.app.DatePickerDialog;
import android.app.Dialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etDate;
    private Button btnDate;

    private DatePickerDialog pickerDialog;
    private SimpleDateFormat dateFormat;

    private EditText etName;
    private EditText etTel;
    private EditText etEmail;
    private EditText etDesc;
    private Button btnDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etTel = (EditText) findViewById(R.id.etTel);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDesc = (EditText) findViewById(R.id.etDesc);
        btnDetalles = (Button) findViewById(R.id.btnDetalles);

        //Formateador de fecha, para representarla como String en el TextView
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        //Se obtiene la fecha actual del sistema para inicializar el DatePicker
        Calendar calendar = Calendar.getInstance();
        etDate = (EditText) findViewById(R.id.etDate);
        btnDate = (Button) findViewById(R.id.btnDate);

        //Se inicializa el TextView con la fecha actual del sistema, ya formateada
        etDate.setText(dateFormat.format(calendar.getTime()));

        //Se inicializa el Picker Dialog con la fecha actual del sistema, y se agrega un listener
        //para que al setear una nueva fecha en él, se setee ya formateada al TextView
        pickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, day);
                etDate.setText(dateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        //Se agrega un listener al dar click en el boton de fecha, para abrir el Picker Dialog
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickerDialog.show();
            }
        });

        btnDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConfirmacionActivity.class);
                i.putExtra(getResources().getString(R.string.cntName), etName.getText().toString());
                i.putExtra(getResources().getString(R.string.cntDate), etDate.getText().toString());
                i.putExtra(getResources().getString(R.string.cntTel), etTel.getText().toString());
                i.putExtra(getResources().getString(R.string.cntEmail), etEmail.getText().toString());
                i.putExtra(getResources().getString(R.string.cntDesc), etDesc.getText().toString());
                startActivity(i);
            }
        });

    }

}
