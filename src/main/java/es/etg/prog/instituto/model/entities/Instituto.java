package es.etg.prog.instituto.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import es.etg.prog.instituto.model.export.Documento;


public class Instituto implements Documento {
    
    private List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String getTituto() {
        return "Exportación a documento";
    }

    @Override
    public Map<String, Object[]> getContenido() {
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[] { "Nombre", "Apellidos", "Edad" });

        for(int i=0; i<alumnos.size(); i++){
            Alumno al = alumnos.get(i);
            Object[] alumnoDatos = new Object[] { al.getNombre(), al.getApellido(), al.getEdad()};
            data.put(String.valueOf(2+i), alumnoDatos);
        }
        return data;
    }

    @Override
    public String getPie() {
        return "Creado el "+new Date(System.currentTimeMillis());
    }

}
