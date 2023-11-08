package com.example.julia.meuappmain;

public class App {
    private int id;
    private String nome;
    private String intent;

    public App(String nome, String intent) {
        this.nome = nome;
        this.intent = intent;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }
}
