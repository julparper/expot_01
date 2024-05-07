package es.etg.prog.instituto.model.export;

import static es.etg.prog.instituto.model.export.DocumentoFormat.*;

public class DocumentFactory {
    
    public static ExportUtil obtener(DocumentoFormat formato){

        if(formato.equals(WORD))
            return new WordUtil();
        else
            return new ExcelUtil();
    }
}
