package com.example.myapplication1.view;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.R;
import com.example.myapplication1.model.ControleTTS;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityTeste extends AppCompatActivity {

    private static final int REQUEST_CODE = 2;
    private TextView textView;//mudar o nome
    private boolean estaOuvindo = false;
    private ControleTTS controleTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        textView = findViewById(R.id.textfalado);
        controleTTS = new ControleTTS(this);

        iniciarReconhecimento();

        int segundosRodando = 300;

        Timer tempo = new Timer();
        tempo.schedule(new TimerTask() {
            @Override
            public void run() {
                pararReconhecimento();
            }
        }, segundosRodando * 1000);
    }

    private void pararReconhecimento() {
        if (estaOuvindo) {
            estaOuvindo = false;
        }
    }

    private void iniciarReconhecimento() {
        if (!estaOuvindo) {
            estaOuvindo = true;

            Intent it = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            it.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            it.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault().getLanguage());
            it.putExtra(RecognizerIntent.EXTRA_PROMPT, "Deseja algo...");

            controleTTS.speak("Deseja algo???");

            startActivityForResult(it, REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList<String> resultados = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (resultados != null && !resultados.isEmpty()) {
                String resultado = resultados.get(0);

               //comandos



            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        controleTTS.shutdown();
    }
}
