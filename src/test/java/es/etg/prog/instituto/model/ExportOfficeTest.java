package es.etg.prog.instituto.model;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import es.etg.prog.instituto.model.entities.Alumno;
import es.etg.prog.instituto.model.entities.Instituto;
import es.etg.prog.instituto.model.export.DocumentFactory;
import es.etg.prog.instituto.model.export.DocumentoFormat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



@TestMethodOrder(OrderAnnotation.class)
public class ExportOfficeTest {

    private static Instituto instituto = new Instituto();



    @BeforeAll
    public static void init(){
        List<Alumno> alumnos = new ArrayList<>();

        alumnos.add(new Alumno("nuevo1", "nuevo1", 1));
        alumnos.add(new Alumno("nuevo2", "nuevo2", 2));
        alumnos.add(new Alumno("nuevo3", "nuevo3", 3));

        instituto.setAlumnos(alumnos);

    }


    @Test
    public void exportarExcel() throws Exception{
        FileOutputStream fichero = new FileOutputStream("test.xlsx");

        fichero.write(DocumentFactory.obtener(DocumentoFormat.EXCEL).crearFichero(instituto));
        fichero.close();
    }

    @Test
    public void exportarWord() throws Exception{
        FileOutputStream fichero = new FileOutputStream("test.docx");

        fichero.write(DocumentFactory.obtener(DocumentoFormat.WORD).crearFichero(instituto));
        fichero.close();
    }

}
