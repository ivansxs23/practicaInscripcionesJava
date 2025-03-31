// Clase de pruebas unitarias
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    @Test
    void testInscripcionAprobada() {
        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);
        
        Alumno alumno = new Alumno("Juan", "Perez", 1234);
        alumno.aprobarMateria(algoritmos);
        
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(paradigmas));
        assertTrue(inscripcion.aprobada(), "El alumno debería poder inscribirse en Paradigmas");
    }

    @Test
    void testInscripcionRechazada() {
        Materia algoritmos = new Materia("Algoritmos");
        Materia paradigmas = new Materia("Paradigmas");
        paradigmas.agregarCorrelativa(algoritmos);
        
        Alumno alumno = new Alumno("Juan", "Perez", 1234);
        
        Inscripcion inscripcion = new Inscripcion(alumno, List.of(paradigmas));
        assertFalse(inscripcion.aprobada(), "El alumno no debería poder inscribirse en Paradigmas sin aprobar Algoritmos");
    }
}
