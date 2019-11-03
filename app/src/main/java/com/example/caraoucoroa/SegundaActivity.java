package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //crio uma intent para receber as informações
        Intent intent = getIntent();
        //pegando o palpite que o usuário digitou
        String palpiteRecebido = intent.getStringExtra("palpite");
        //colocando valor do palpite em um TextView
        TextView txt = (TextView) findViewById(R.id.palpiteRecebido);
        txt.setTextSize(60);



        //txt.setText(palpiteRecebido);

        sorteio(palpiteRecebido, txt);

    }

    private void sorteio(String palpiteRecebido, TextView textView){


        String palpite = palpiteRecebido.toUpperCase().trim();
        //tratar entrada
        //verifica se contem a opcao

        LADOMOEDA palpiteLado = null;
        for(LADOMOEDA lado : LADOMOEDA.values()){
            if(palpite.equals(lado.name())){
                palpiteLado = lado;
            }
        }

        if (palpiteLado == null){
            textView.setText("opção inválida");
            return;
        }

        //gerar um cara ou coroa com o random

        Random random = new Random();
        int sorteado = random.nextInt(2);

        if(palpiteLado.getLadoMoeda()==sorteado){
            textView.setText("Acertou!!");
        } else {
            textView.setText("Falhou");
        }

    }

    public enum LADOMOEDA {
        CARA(0),COROA(1);

        int ladoMoeda;

        LADOMOEDA(int valor) {
            ladoMoeda = valor;
        }

        public int getLadoMoeda() {
            return ladoMoeda;
        }
    }
}
