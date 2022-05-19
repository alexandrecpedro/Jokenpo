package com.app.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        /** Escolha aletória do App **/
        //gerar número aleatório para escolha do App
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3); // escolhe entre 0, 1 e 2
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            default:
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        /** Resultado do jogo **/
        // App ganhador
        if (
                (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
                (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))
        ) {
            textoResultado.setText("Você perdeu :( ");
            // Usuário ganhador
        } else if (
                (escolhaApp.equals("tesoura") && escolhaUsuario.equals("pedra")) ||
                (escolhaApp.equals("pedra") && escolhaUsuario.equals("papel")) ||
                (escolhaApp.equals("papel") && escolhaUsuario.equals("tesoura"))
        ) {
            textoResultado.setText("Você ganhou :) ");
        } else {
            textoResultado.setText("Empatamos ;) ");
        }
    }
}