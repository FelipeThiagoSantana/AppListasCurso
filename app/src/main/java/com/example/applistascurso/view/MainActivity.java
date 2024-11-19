package com.example.applistascurso.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applistascurso.R;
import com.example.applistascurso.controller.PessoaController;
import com.example.applistascurso.model.Pessoa;


public class MainActivity extends AppCompatActivity {


    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        PessoaController controller = new PessoaController();

        Pessoa pessoa = new Pessoa();

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());


       btnLimpar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               editPrimeiroNome.setText("");
               editSobrenome.setText("");
               editCursoDesejado.setText("");
               editTelefoneContato.setText("");

               Toast.makeText(MainActivity.this, "Campos limpos", Toast.LENGTH_LONG).show();
           }
       });

       btnFinalizar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(MainActivity.this, "Finalizando aplicação", Toast.LENGTH_LONG).show();
               finish();
           }
       });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Dados do " + pessoa.getPrimeiroNome() + " salvos com sucesso!" , Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);
            }
        });

    }
}