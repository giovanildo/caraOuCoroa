package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void tentarSorte(View v){
        //primeiro cria um objeto EditText para referenciar a ele o EditText do xml
        EditText txt = (EditText) findViewById(R.id.palpite);
        //agora guarda o que foi digitado no edittext em uma String
        String palpite = txt.getText().toString();
        //criar uma intent que vai apontar para a próxima activity
        Intent intent = new Intent(this, SegundaActivity.class);
        //passando a informação deseja para a intent
        intent.putExtra("palpite", palpite);
        startActivity(intent);
    }
}
