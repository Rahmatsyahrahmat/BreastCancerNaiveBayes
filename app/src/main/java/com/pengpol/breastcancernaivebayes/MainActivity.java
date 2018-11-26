package com.pengpol.breastcancernaivebayes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText idNumber,clumpTickness, cellSize, cellShape, marginalAdhesion, singleEpithelialCellSize, bareNuclei, blandChromatin, normalNucleoli,mitoses;

    private Database database;

    private TextView hasil;

    private Button kelassifikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }
    private void bindView(){
        idNumber = findViewById(R.id.idNumber);
        clumpTickness = findViewById(R.id.clumpTickness);
        cellSize = findViewById(R.id.cellShape);
        cellShape = findViewById(R.id.cellSize);
        marginalAdhesion = findViewById(R.id.singleCellSize);
        singleEpithelialCellSize = findViewById(R.id.marginalAdhesion);
        bareNuclei = findViewById(R.id.bareNuclei);
        blandChromatin = findViewById(R.id.blandChromatine);
        normalNucleoli = findViewById(R.id.normalNucleoli);
        mitoses = findViewById(R.id.mitoses);
        hasil = findViewById(R.id.hasil);
        kelassifikasi = findViewById(R.id.klasifikasi);
        kelassifikasi.setOnClickListener(this);

        database = new Database();
    }
    private void getKelas(){
        if (TextUtils.isEmpty(clumpTickness.getText().toString())){
            toast("Isi "+clumpTickness.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(cellSize.getText().toString())){
            toast("Isi "+cellSize.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(cellShape.getText().toString())){
            toast("Isi "+cellShape.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(marginalAdhesion.getText().toString())){
            toast("Isi "+marginalAdhesion.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(singleEpithelialCellSize.getText().toString())){
            toast("Isi "+singleEpithelialCellSize.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(bareNuclei.getText().toString())){
            toast("Isi "+bareNuclei.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(blandChromatin.getText().toString())){
            toast("Isi "+blandChromatin.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(normalNucleoli.getText().toString())){
            toast("Isi "+normalNucleoli.getHint().toString());
            return;
        }
        if (TextUtils.isEmpty(mitoses.getText().toString())){
            toast("Isi "+mitoses.getHint().toString());
            return;
        }
        Data input = new Data(Integer.valueOf(idNumber.getText().toString()),Integer.valueOf(clumpTickness.getText().toString()),Integer.valueOf(cellSize.getText().toString()),Integer.valueOf(cellShape.getText().toString()),Integer.valueOf(marginalAdhesion.getText().toString()),Integer.valueOf(singleEpithelialCellSize.getText().toString()),Integer.valueOf(bareNuclei.getText().toString()),Integer.valueOf(blandChromatin.getText().toString()),Integer.valueOf(normalNucleoli.getText().toString()),Integer.valueOf(mitoses.getText().toString()));
        input.getKelas(database.getDatas(),hasil);
    }

    private void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        getKelas();
    }
}
