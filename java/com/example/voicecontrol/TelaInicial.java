package com.example.voicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class TelaInicial extends AppCompatActivity {
    private TextToSpeech ttsFalar;
    private EditText nome;
    private EditText nomeAssistente;
    private Button entrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        ttsFalar = new TextToSpeech(this,this::onInit);
        initComponentes();
    }
    private void initComponentes(){
        nome = findViewById(R.id.nome_usuario);
        nomeAssistente = findViewById(R.id.nome_assistente);
        entrar = findViewById(R.id.button);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent it = new Intent(TelaInicial.this, Configuracao.class);
                        startActivity(it);
                    }

            });
    }
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int resultado = ttsFalar.setLanguage(Locale.getDefault());
            if (resultado == TextToSpeech.LANG_MISSING_DATA || resultado == TextToSpeech.LANG_NOT_SUPPORTED) {

            } else {
                String texto = "Tela de cadastro, por favor  insira as informações a baixo";
                ttsFalar.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "1");
            }
        } else {
            //Falha
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ttsFalar != null) {
            ttsFalar.stop();
            ttsFalar.shutdown();
        }
    }


}
