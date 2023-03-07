package com.IgorDev.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.IgorDev.applistavip.R;
import com.IgorDev.applistavip.model.Curso;
import com.IgorDev.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    Curso curso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         // o "new" é usado para indicar a jvm que é necessário
        //criar um novo objeto do tipo Pessoa.
        //Sempre que usamos o new e invocamos o método construtor
        //é criado um objeto que acessará

       //Objeto do tipo pessoa
        pessoa = new Pessoa();
        //Objeto do tipo curso
        curso = new Curso();
    }
}