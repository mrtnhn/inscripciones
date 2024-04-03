package domain.inscripciones;

import domain.personas.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private List<Materia> materias;
    private Alumno alumno;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Boolean aprobada() {
        return materias.stream().allMatch(Materia::cumpleCorrelativas);    // si la lista esta vacia devuelve true
    }

    public void inscribirseEn(Materia ... materia) {
        Collections.addAll(this.materias ,materia);
    }
}
