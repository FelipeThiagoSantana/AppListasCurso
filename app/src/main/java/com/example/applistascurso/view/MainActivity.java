package com.example.applistascurso.view;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applistascurso.R;
import com.example.applistascurso.controller.CursoController;
import com.example.applistascurso.controller.PessoaController;
import com.example.applistascurso.model.Curso;
import com.example.applistascurso.model.Pessoa;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;
    List<String> nomesDosCursos;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        PessoaController controller = new PessoaController(MainActivity.this);
        controller.toString();

        CursoController cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();

        Pessoa pessoa = new Pessoa();
        controller.buscar(pessoa);


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, cursoController.dadosParaSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());


        btnLimpar.setOnClickListener(view -> {
            editPrimeiroNome.setText("");
            editSobrenome.setText("");
            editCursoDesejado.setText("");
            editTelefoneContato.setText("");

            controller.limpar();

            Toast.makeText(MainActivity.this, "Campos limpos", Toast.LENGTH_LONG).show();
        });

        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Finalizando aplicação", Toast.LENGTH_LONG).show();
            finish();
        });

        btnSalvar.setOnClickListener(view -> {
            pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
            pessoa.setSobrenome(editSobrenome.getText().toString());
            pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
            pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

            Toast.makeText(MainActivity.this, "Dados do " + pessoa.getPrimeiroNome() + " salvos com sucesso!", Toast.LENGTH_LONG).show();

            controller.salvar(pessoa);
        });

    }
}