package domain.inscripciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private List<Materia> correlativas;
    private String nombre;
    private Boolean aprobada;

    public Materia(String nombre, Boolean aprobada) {
        this.nombre = nombre;
        this.aprobada = aprobada;
        this.correlativas = new ArrayList<>();
    }

    public void agregarCorrelativas(Materia ... correlativas) {
        Collections.addAll(this.correlativas, correlativas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAprobada() {
        return aprobada;
    }

    public void setAprobada(Boolean aprobada) {
        this.aprobada = aprobada;
    }

    public Boolean cumpleCorrelativas() {
        return correlativas.stream().allMatch(Materia::getAprobada);  // si la lista esta vacia devuelve true
    }
}
