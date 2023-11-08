package com.example.julia.meuappmain;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;

import java.util.Calendar;

public class AppRepositorio {
    String nomeApp;
    Intent intent;

    public AppRepositorio(String nomeApp) {
        this.nomeApp = nomeApp;

        if(nomeApp.equals("Telefone")){
            Uri number = Uri.parse(" ");// numero de telefone
            intent = new Intent(Intent.ACTION_DIAL, number);
        }else if(nomeApp.equals("Mapa")){
            Uri location = Uri.parse("geo:0,0?, +, +");//geo, cidade, estado
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        }else if(nomeApp.equals("Email")){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{});// e-mail
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");// assunto
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");//mensagem de texto
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
        }else if(nomeApp.equals("Agenda")) {
            Intent calendar = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(2021, 0, 23, 7, 30);
            Calendar endTime = Calendar.getInstance();
            endTime.set(2021, 0, 23, 10, 30);
            calendar.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
            calendar.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
            calendar.putExtra(CalendarContract.Events.TITLE, ""); // titulo
            calendar.putExtra(CalendarContract.Events.EVENT_LOCATION, ""); // descriscao
        }

}




















}
