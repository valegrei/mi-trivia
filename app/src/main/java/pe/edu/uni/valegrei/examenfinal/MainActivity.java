package pe.edu.uni.valegrei.examenfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pe.edu.uni.valegrei.examenfinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TRIVIA_KEY = "trivia";
    private ActivityMainBinding binding;
    private Trivia trivia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAnterior.setOnClickListener(v->{

        });

        if(savedInstanceState!=null){
            trivia = savedInstanceState.getParcelable(TRIVIA_KEY);
        }

        iniciar();
        mostrarPregunta();
    }

    private void iniciar(){
        if(trivia==null){
            trivia = Trivia.nuevaTrivia();
        }
    }

    private void mostrarPregunta(){
        binding.tvNroPregunta.setText(getString(R.string.text_nro_preg, (trivia.getPosicion()+1)));
        binding.tvTrivia.setText(trivia.getPreguntaActual().getTextId());
        binding.imgTrivia.setImageResource(trivia.getPreguntaActual().getImgId());
    }

    private void

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //guardamos la trivia actual
        outState.putParcelable(TRIVIA_KEY, trivia);
        super.onSaveInstanceState(outState);
    }
}