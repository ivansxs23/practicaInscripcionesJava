import java.util.List;
import java.util.ArrayList;

class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }
}

class Alumno {
    private String nombre;
    private String apellido;
    private Integer legajo;
    private List<Materia> aprobadas;

    public Alumno(String nombre, String apellido, Integer legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.aprobadas = new ArrayList<>();
    }

    public void aprobarMateria(Materia materia) {
        aprobadas.add(materia);
    }

    public Boolean cumpleCorrelativas(Materia materia) {
        return aprobadas.containsAll(materia.getCorrelativas());
    }
}

class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public Boolean aprobada() {
        return materias.stream().allMatch(materia -> alumno.cumpleCorrelativas(materia));
    }
}
