package es.etg.prog.instituto.model.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ooxml.POIXMLDocument;

public abstract class OfficeUtil implements ExportUtil{

    @Override
    public abstract byte[] crearFichero(Documento doc) throws Exception ;

    protected byte[] convertir(POIXMLDocument documento) throws IOException{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        documento.write(out); 
        out.close();
        return out.toByteArray();
    }
    
    
}
