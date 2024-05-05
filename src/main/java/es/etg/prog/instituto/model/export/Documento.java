package es.etg.prog.instituto.model.export;

import java.util.Map;

public interface Documento {
    
    public String getTituto();
    public Map<String, Object[]> getContenido();
    public String getPie();
}
