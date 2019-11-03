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

        for(LADOMOEDA lado : LADOMOEDA.values()){
            if(!palpite.equals(lado.name())){
                textView.setText("OPÇÃO INVÁLIDA");
            }
        }

        //gerar um cara ou coroa com o random

        Random random = new Random();
        int sorteado = random.nextInt(2);

        LADOMOEDA lado = Enum.valueOf(LADOMOEDA.class, palpite);

        textView.setText(lado.name() + lado.getLadoMoeda());

//
//
//        LADOMOEDA lado = Enum.valueOf(LADOMOEDA.class, palpite.toUpperCase() );
//
//        textView.setText(palpite.toUpperCase());

        //mostrar msg de sucesso ou fracasso

       /* if(!palpite.equals("Cara")  && !palpite.equals("Coroa")){
            textView.setText("Opção inválida");
            return;
        }

        if(palpite.equals("Cara")){
            textView.setText("Acertou!");
            return;
        }
        if (palpite.equals("Coroa")) {
            textView.setText("Acertou");
            return;
        }

        textView.setText("Errou");*/
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
