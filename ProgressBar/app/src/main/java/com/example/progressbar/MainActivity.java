package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHor;
    private ProgressBar progressBarCirc;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarCirc = findViewById(R.id.progressBarCirc);
        progressBarHor = findViewById(R.id.progressBarHor);
        progressBarCirc.setVisibility( View.GONE );
    }

    public void carregarProgressBar(View view){
        //ProgressBar horizontal
        this.progresso = this.progresso + 10;
        progressBarHor.setProgress( this.progresso );

        //ProgressBar circular
        progressBarCirc.setVisibility( View.VISIBLE );

        if ( this.progresso == 100){
            progressBarCirc.setVisibility( View.GONE );
        }
    }

}