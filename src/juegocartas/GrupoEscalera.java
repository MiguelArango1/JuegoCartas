
package juegocartas;


public class GrupoEscalera {
    private Grupo grupo;
    private NombreCarta desde;
    private NombreCarta hasta;
    
    public GrupoEscalera(Grupo grupo, NombreCarta desde, NombreCarta hasta){
        this.grupo = grupo;
        this.desde = desde;
        this.hasta = hasta;
    }
    
    public NombreCarta getDesde() {
        return desde;
    }
    
     public NombreCarta getHasta() {
        return hasta;
    }
}
