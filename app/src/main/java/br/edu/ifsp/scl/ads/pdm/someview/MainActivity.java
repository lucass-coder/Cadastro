package br.edu.ifsp.scl.ads.pdm.someview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Objetos de binding com os Views
    private EditText nomeEt;
    private EditText sobrenomeEt;
    private EditText emailEt;
    private Spinner estadoCivilSp;
    private LinearLayout conjugeLl;
    private EditText nomeConjugeEt;
    private EditText sobrenomeConjugeEt;
    private RadioGroup sexoRg;
    private RadioButton masculinoRb;

    private String nomeCompleto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding com os views (ligação)
        bindViews();

        estadoCivilSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView viewSelecionada = (TextView)  view; // converte a view apra TextView
                if(viewSelecionada.getText().equals("Casado")) {
                    conjugeLl.setVisibility(View.VISIBLE);
                } else {
                    conjugeLl.setVisibility(View.GONE);
                    nomeConjugeEt.setText("");
                    sobrenomeEt.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        sobrenomeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                nomeCompleto = nomeEt.getText().toString() + " " + charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void bindViews(){
        nomeEt = findViewById(R.id.nomeEt);
        sobrenomeEt = findViewById(R.id.sobrenomeEt);
        emailEt = findViewById(R.id.emailEt);
        estadoCivilSp = findViewById(R.id.estadoCivilSp);
        conjugeLl = findViewById(R.id.conjugeLl);
        nomeConjugeEt = findViewById(R.id.nomeConjugeEt);
        sobrenomeConjugeEt = findViewById(R.id.sobrenomeConjugeEt);
        sexoRg = findViewById(R.id.sexoRg);
        masculinoRb = findViewById(R.id.masculinoRb);
    }

    public void save(View view) {
        Toast.makeText(this, "clicou no salvar", Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        // LIMPAR TODOS OS CAMPOS
        Toast.makeText(this, "clicou no LIMPAR", Toast.LENGTH_SHORT).show();
        nomeEt.setText("");
        sobrenomeEt.setText("");
        emailEt.setText("");
        masculinoRb.setChecked(true);
        nomeConjugeEt.setText("");
        sobrenomeConjugeEt.setText("");
        estadoCivilSp.setSelection(0);
    }

}