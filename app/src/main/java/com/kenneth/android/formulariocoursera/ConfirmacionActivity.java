package com.kenneth.android.formulariocoursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvDate;
    TextView tvTel;
    TextView tvEmail;
    TextView tvDesc;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        tvName = (TextView) findViewById(R.id.tvName);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTel = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        btnEditar = (Button) findViewById(R.id.btnEditar);

        Bundle b = getIntent().getExtras();

        StringBuilder text = new StringBuilder(tvName.getText().toString() + " " +
                ((b.getString(getResources().getString(R.string.cntName)) != null) ?
                        b.getString(getResources().getString(R.string.cntName)) : ""));
        tvName.setText(text);

        text = new StringBuilder(tvTel.getText().toString() + " " +
                ((b.getString(getResources().getString(R.string.cntTel)) != null) ?
                        b.getString(getResources().getString(R.string.cntTel)) : ""));
        tvTel.setText(text);

        text = new StringBuilder(tvEmail.getText().toString() + " " +
                ((b.getString(getResources().getString(R.string.cntEmail)) != null) ?
                        b.getString(getResources().getString(R.string.cntEmail)) : ""));
        tvEmail.setText(text);

        text = new StringBuilder(tvDesc.getText().toString() + " " +
                ((b.getString(getResources().getString(R.string.cntDesc)) != null) ?
                        b.getString(getResources().getString(R.string.cntDesc)) : ""));
        tvDesc.setText(text);

        text = new StringBuilder(tvDate.getText().toString() + " " +
                ((b.getString(getResources().getString(R.string.cntDate)) != null) ?
                        b.getString(getResources().getString(R.string.cntDate)) : ""));
        tvDate.setText(text);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
