package br.com.aluno.emailapp;

import android.app.Activity;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.sendEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    protected void sendEmail(){
        Log.i("Enviar email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Assunto Teste");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Escreva seu email aqui...");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar mail..."));
            finish();
            Log.i("Terminando...", "");
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(MainActivity.this, "Não existe um cliente de email instalado", Toast.LENGTH_SHORT).show();
        }
    }

}
