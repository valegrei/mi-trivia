package pe.edu.uni.valegrei.examenfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bosphere.filelogger.FL;
import com.google.android.material.snackbar.Snackbar;

import pe.edu.uni.valegrei.examenfinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TRIVIA_KEY = "trivia";
    private ActivityMainBinding binding;
    private Trivia trivia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FL.i(TAG, "onCreate");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAnterior.setOnClickListener(v -> {
            FL.i(TAG, "btnAnterior clicked");
            anterior();
        });

        binding.btnSiguiente.setOnClickListener(v -> {
            FL.i(TAG, "btnSiguiente clicked");
            siguiente();
        });

        binding.btnVerdadero.setOnClickListener(v -> {
            FL.i(TAG, "btnVerdadero clicked");
            marcarRespuesta(true);
        });

        binding.btnFalso.setOnClickListener(v -> {
            FL.i(TAG, "btnFalso clicked");
            marcarRespuesta(false);
        });

        if (savedInstanceState != null) {
            trivia = savedInstanceState.getParcelable(TRIVIA_KEY);
        }

        iniciar();
        mostrarPregunta();
    }

    private void iniciar() {
        if (trivia == null) {
            trivia = Trivia.nuevaTrivia();
        }
    }

    private void mostrarPregunta() {
        binding.tvNroPregunta.setText(getString(R.string.text_nro_preg, (trivia.getPosicion() + 1)));
        binding.tvTrivia.setText(trivia.getPreguntaActual().getTextId());
        binding.imgTrivia.setImageResource(trivia.getPreguntaActual().getImgId());
    }

    private void marcarRespuesta(boolean resp){
        if(trivia.comprobarRespuesta(resp)){
            mostrarSnackbar(R.string.correcto);
        }else{
            mostrarSnackbar(R.string.incorrecto);
        }
    }

    private void siguiente() {
        trivia.siguiente();
        mostrarPregunta();
    }

    private void anterior() {
        trivia.anterior();
        mostrarPregunta();
    }

    private void mostrarSnackbar(int msgId){
        Snackbar.make(binding.layout, msgId, Snackbar.LENGTH_INDEFINITE).setAction(R.string.ok,v->{}).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        //guardamos la trivia actual
        outState.putParcelable(TRIVIA_KEY, trivia);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        FL.i(TAG, "onStop");
    }
}