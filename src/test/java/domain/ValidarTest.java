package domain;

import domain.inscripciones.Inscripcion;
import domain.inscripciones.Materia;
import domain.personas.Alumno;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidarTest {

    private List<Materia> listaMaterias;

    Materia pdp = new Materia("PDP",true);
    Materia algoritmos = new Materia("Algoritmos",true);
    Materia dds = new Materia("DDS",false);
    Materia so = new Materia("SO",false);
    Materia md = new Materia("MD", false);

    Alumno martin = new Alumno("martin", "100");
    Alumno leonardo = new Alumno("leonardo", "200");
    Alumno martin2 = new Alumno("martin", "300");

    @Before
    public void inicializar() {
        listaMaterias = new ArrayList<>();

        pdp.agregarCorrelativas(algoritmos);
        dds.agregarCorrelativas(pdp);
        so.agregarCorrelativas(md);
    }

    @Test
    public void incripcion_1() {
        Inscripcion alternativa1 = new Inscripcion(martin);

        Assert.assertTrue(alternativa1.getAlumno().equals(martin));
    }

    @Test
    public void incripcion_2() {
        Inscripcion alternativa1 = new Inscripcion(martin);

        Assert.assertFalse(alternativa1.getAlumno().equals(leonardo));
    }

    @Test
    public void incripcion_3() {    // aca nada mas verifica el nombre
        Inscripcion alternativa1 = new Inscripcion(martin);

        Assert.assertEquals(alternativa1.getAlumno().getNombre(), "martin");
    }

    @Test
    public void incripcion_4a() {
        Inscripcion alt1_unAlumno = new Inscripcion(martin);
        Inscripcion alt1_otroAlumno = new Inscripcion(martin2);

        Assert.assertEquals(alt1_unAlumno.getAlumno().getNombre(), alt1_otroAlumno.getAlumno().getNombre());
    }

    @Test
    public void incripcion_4b() {
        Inscripcion alt1_unAlumno = new Inscripcion(martin);
        Inscripcion alt1_otroAlumno = new Inscripcion(martin2);

        Assert.assertNotEquals(alt1_unAlumno.getAlumno(), alt1_otroAlumno.getAlumno());
    }

    @Test
    public void incripcion_4c() {
        Inscripcion alt1_unAlumno = new Inscripcion(martin);
        Inscripcion alt1_otroAlumno = new Inscripcion(martin2);

        Assert.assertNotEquals(alt1_unAlumno.getAlumno().getLegajo(), alt1_otroAlumno.getAlumno().getLegajo());
    }

    @Test
    public void validar_1() {
        Materia[] materias = {
//                so,
                dds,
        };
        Collections.addAll(this.listaMaterias, materias);

        Inscripcion inscripcion = new Inscripcion(martin, listaMaterias);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void validar_2() {
        Materia[] materias = {
                so,
//                dds,
        };
        Collections.addAll(this.listaMaterias, materias);

        Inscripcion inscripcion = new Inscripcion(leonardo, listaMaterias);

        Assert.assertFalse(inscripcion.aprobada());
    }
}
