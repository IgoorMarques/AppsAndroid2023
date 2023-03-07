package com.IgorDev.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.IgorDev.applistavip.R;
import com.IgorDev.applistavip.model.Curso;
import com.IgorDev.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    EditText input_nome;
    EditText input_sobrenome;
    EditText input_curso;
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
        pessoa.setPrimeiroNome("Igor");
        pessoa.setSobrenome("Marques");
        pessoa.setCursoDesejado("ADS");
        pessoa.setTelefone("033-3344-333");
    }
}