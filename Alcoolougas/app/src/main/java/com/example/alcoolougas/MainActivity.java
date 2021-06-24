package com.example.alcoolougas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasol;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.editPrecoAlcool);
        editPrecoGasol      = findViewById(R.id.editPrecoGasol);
        textResultado       = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        //recuperar valores digitados pelo usuário
        String precoAlcool = editPrecoAlcool.getText().toString(); //converte para String
        String precoGasol = editPrecoGasol.getText().toString();

        //validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasol);
        if ( camposValidados ){
            //convertendo strings para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasol = Double.parseDouble(precoGasol);

            /* Fazer cálculo de menor preço:
            Se (ValorAlcool / ValorGasol >= 0.7, é melhor utilizar Gasolina
            senao, é melhor utilizar alcool.
             */
            Double resultado = valorAlcool / valorGasol;
            if ( resultado >= 0.7 ){
                textResultado.setText("Melhor utilizar Gasolina. ");
            } else {
                textResultado.setText("Melhor utilizar Álcool. ");
            }
        }else {
            textResultado.setText("Preencha os dados primeiro! ");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }else if ( pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
        }
        return camposValidados;
    }

}