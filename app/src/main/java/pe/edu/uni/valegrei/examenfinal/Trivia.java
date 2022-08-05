package pe.edu.uni.valegrei.examenfinal;

import java.util.ArrayList;
import java.util.List;

public class Trivia {

    private List<Pregunta> preguntas;

    public Trivia(List<Pregunta> preguntas){}

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public static Trivia nuevaTrivia(){
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));
        preguntas.add(new Pregunta(R.string.preg2, R.drawable.image2,false));
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1,false));

        return new Trivia(preguntas);
    }
}
