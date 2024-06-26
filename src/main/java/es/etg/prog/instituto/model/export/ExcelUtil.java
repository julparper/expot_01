package es.etg.prog.instituto.model.export;

import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil extends OfficeUtil{
    
    public static final String NOMBRE_SHEET = "datos";
    
    @Override
    public byte[]  crearFichero(Documento doc) throws Exception{
        byte[] fileData = null;
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(NOMBRE_SHEET);
        Map<String, Object[]> data = doc.getContenido();
	    Set<String> keyset = data.keySet(); 
        int rownum = 0;

        for (String key : keyset) { 

            //Creamos una fila
            XSSFRow row = sheet.createRow(rownum++); 
            Object[] objArr = data.get(key); 
            int cellnum = 0; 

            for (Object obj : objArr) { 
                // Creamos una celda dentro de la fila
                XSSFCell cell = row.createCell(cellnum++); 
                if (obj instanceof String)
                    cell.setCellValue((String)obj); 
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }     
        
        fileData = convertir(workbook);
        workbook.close();
        return fileData;
    }
}
