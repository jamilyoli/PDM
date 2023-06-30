package com.example.voicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class Configuracao extends AppCompatActivity {

    TextToSpeech ttsConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
        ttsConfig = new TextToSpeech(this, this::onInit);

    }
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int resultado = ttsConfig.setLanguage(Locale.getDefault());
            if (resultado == TextToSpeech.LANG_MISSING_DATA || resultado == TextToSpeech.LANG_NOT_SUPPORTED) {

            } else {
                String texto = "Caro usuario, deseja alterar algum recurso";
                ttsConfig.speak(texto, TextToSpeech.QUEUE_FLUSH, null, "1");
            }
        }else {
            //Falha
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (ttsConfig != null){
            ttsConfig.stop();
            ttsConfig.shutdown();
        }
    }

}