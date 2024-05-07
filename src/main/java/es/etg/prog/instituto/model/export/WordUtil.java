package es.etg.prog.instituto.model.export;

import java.util.Map;
import java.util.Set;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class WordUtil extends OfficeUtil{

    @Override
    public byte[]  crearFichero(Documento doc) throws Exception{
        byte[] fileData = null;
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText(doc.getTituto());
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        Map<String, Object[]> data = doc.getContenido();
        Set<String> keyset = data.keySet(); 
        for (String key : keyset) { 
            Object[] objArr = data.get(key); 
            String parrafo = "";
            for (Object obj : objArr) { 
                parrafo += obj.toString()+" ";
            }

            XWPFParagraph para1 = document.createParagraph();
            para1.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun para1Run = para1.createRun();
            para1Run.setText(parrafo);
        }

        XWPFParagraph piePagina = document.createParagraph();
        piePagina.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun piePaginaRun = piePagina.createRun();
        piePaginaRun.setText(doc.getPie());
        piePaginaRun.setFontSize(11);
        
        fileData =  convertir(document);
        document.close();
        return fileData;

    }
}
