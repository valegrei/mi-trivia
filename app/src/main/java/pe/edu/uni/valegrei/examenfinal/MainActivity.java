package pe.edu.uni.valegrei.examenfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pe.edu.uni.valegrei.examenfinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}