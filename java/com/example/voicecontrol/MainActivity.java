package com.example.voicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech ttsFalar;
    private  Button btnPermissao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsFalar = new TextToSpeech(this,this);
        btnPermissao = findViewById(R.id.btn_permissao);

        btnPermissao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, com.example.voicecontrol.TelaInicial.class);
                startActivity(it);
            }
        });
    }
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int resultado = ttsFalar.setLanguage(Locale.getDefault());
            if (resultado == TextToSpeech.LANG_MISSING_DATA || resultado == TextToSpeech.LANG_NOT_SUPPORTED) {

            } else {
                String texto = "Para garantir uma experiencia inclusiva, pedimos sua permissão para acessar o dispositivo";
                ttsFalar.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "1");
            }
        }else {
            //Falha
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (ttsFalar != null){
            ttsFalar.stop();
            ttsFalar.shutdown();
        }
    }
}

