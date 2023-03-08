package com.IgorDev.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.IgorDev.applistavip.R;
import com.IgorDev.applistavip.controller.ControllerPessoa;
import com.IgorDev.applistavip.model.Curso;
import com.IgorDev.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    public void limpar(){
        txt_curso.setText("");
        txt_sobrenome.setText("");
        txt_telefone.setText("");
        txt_nome.setText("");
    }
    SharedPreferences preferences;
    public static final String NOME_PREFERENCIA = "pref_listavip";

    EditText txt_nome;
    EditText txt_sobrenome;
    EditText txt_curso;
    EditText txt_telefone;
    Button bt_limpar;
    Button bt_salvar;
    Button bt_Sair;
    Pessoa pessoa;
    Curso curso;
    ControllerPessoa controller;

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

        controller = new ControllerPessoa();

        //Criando arquivo xml para armazenar dados
        preferences = getSharedPreferences(NOME_PREFERENCIA, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        //Atribuindo valores ao objeto 'pessoa' atráves dos dados do arquivo preferences
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobrenome(preferences.getString("Sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("Telefone",""));
        pessoa.setTelefone(preferences.getString("Curso", ""));

        //Identificando os componentes do layout da tela main
        txt_nome = findViewById(R.id.txt_nome);
        txt_sobrenome = findViewById(R.id.txt_sobrenome);
        txt_curso = findViewById(R.id.txt_curso);
        txt_telefone = findViewById(R.id.txt_telefone);
        bt_limpar = findViewById(R.id.bt_limpar);
        bt_salvar = findViewById(R.id.bt_salvar);
        bt_Sair = findViewById(R.id.bt_Sair);

        //Atribuindo valores na tela do app por meio dos valores do objeto 'pessoa'
        txt_nome.setText(pessoa.getPrimeiroNome());
        txt_sobrenome.setText(pessoa.getSobrenome());
        txt_telefone.setText(pessoa.getTelefone());
        txt_curso.setText(pessoa.getCursoDesejado());

        //Função que será chama quando bt_limpar for clicado
        bt_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
                //limpando os dados do aquivo xml 'pref_listavip'
                listaVip.clear();
                listaVip.apply();
            }
        });

        //Função que será chamada quando bt_sair for clicado
        bt_Sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();

            }
        });
        //Função que será chamada quando bt_salvar for clicado
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Atribuindo valores coletados dos edit's text da tela do app ao objeto 'pessoa'
                pessoa.setPrimeiroNome(txt_nome.getText().toString());
                pessoa.setSobrenome(txt_sobrenome.getText().toString());
                pessoa.setTelefone(txt_telefone.getText().toString());
                pessoa.setCursoDesejado(txt_curso.getText().toString());

                //Mostra mensagem na tela informando os dados do objeto pessoal por meio do metodo toString()
                Toast.makeText(MainActivity.this, "Cadastrado: "+ pessoa.toString(), Toast.LENGTH_LONG).show();
                limpar();

                //Adicionando valores os valores do objeto 'pessoa' ao arquivo 'pref_listavip'
                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("Sobrenome", pessoa.getSobrenome());
                listaVip.putString("Curso", pessoa.getCursoDesejado());
                listaVip.putString("Telefone", pessoa.getTelefone());
                listaVip.apply();

                //Chamando o método salvar do objeto controle
                controller.salvar(pessoa);
            }
        });
    }
}