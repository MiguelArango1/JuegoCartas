
package juegocartas;
 
import java.util.Random;
import javax.swing.JPanel;

public class Jugador {
    private boolean cartasRepartidas;
    private int TOTAL_CARTAS = 10;
    private int DISTANCIA = 40;
    private int MARGEN = 5;
  
    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();
    
    public Jugador() {
        cartasRepartidas = false;
    }
    public void repartir() {
    for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
            cartasRepartidas = true;
        }
}

    public boolean haRepartido() {
        return cartasRepartidas;
    }
    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        for (int i = 0; i < cartas.length; i++) {
            cartas[i].mostrar(pnl, MARGEN + TOTAL_CARTAS * DISTANCIA - i * DISTANCIA, MARGEN);
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No hay grupos";
        int[] contadores = new int[NombreCarta.values().length];

        for (int i = 0; i < cartas.length; i++) {
            contadores[cartas[i].getNombre().ordinal()]++;
        }

        int totalGrupos = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                totalGrupos++;
            }
        }
        
        String escaleras = getFigurasEnEscalera();
        if (totalGrupos > 0 || !escaleras.equals("No hay figuras en escalera")) {
        mensaje = "LOS GRUPOS ENCONTRADOS FUERON:\n";
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
            }
        }
        mensaje += escaleras;
    }

    return mensaje;
}
    public void Ordenar(){
         for (int i = 0; i < cartas.length -1; i++) {
              for (int j =i+1; j < cartas.length; j++) {
                  if (cartas[i].getIndice()>cartas[j].getIndice()){
                      Carta ct=cartas[i];
                      cartas[i]=cartas[j];
                      cartas[j]=ct;
                  }
              }
             
         }
        
    }

public void mostrarOrdenadoPorEscalera(JPanel pnl) {
    OrdenarPorNumero(); 
    pnl.removeAll();
    for (int i = 0; i < cartas.length; i++) {
        cartas[i].mostrar(pnl, MARGEN + TOTAL_CARTAS * DISTANCIA - i * DISTANCIA, MARGEN);
    }
    pnl.repaint();
}
    public void OrdenarPorNumero() {
        for (int i = 0; i < cartas.length - 1; i++) {
            for (int j = i + 1; j < cartas.length; j++) {
                if (cartas[i].getNombre().ordinal() > cartas[j].getNombre().ordinal()) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[j];
                    cartas[j] = temp;
                }
            }
        }
    }

   public String getFigurasEnEscalera() {
    StringBuilder mensaje = new StringBuilder("LAS ESCALERAS ENCONTRADAS:\n");
    boolean escalerasEncontradas = false;
    OrdenarPorNumero(); 
    
    for (Pinta pinta : Pinta.values()) {
        for (int i = 0; i < cartas.length - 1; i++) {
            if (cartas[i].getPinta() == pinta) {
                int contadorEscalera = 1;
                NombreCarta primeraCarta = cartas[i].getNombre();
                
               
                for (int j = i + 1; j < cartas.length; j++) {
                    if (cartas[j].getPinta() == pinta &&
                        cartas[j].getNombre().ordinal() == primeraCarta.ordinal() + contadorEscalera) {
                        contadorEscalera++;
                    } else {
                        break;  
                    }
                    
                    
                    if (contadorEscalera >= 2 && contadorEscalera <= 5) {
                        escalerasEncontradas = true;
                        mensaje.append("ESCALERA DE ")
                               .append(pinta).append(": ");
                        for (int k = i; k <= j; k++) {
                            mensaje.append(cartas[k].getNombre()).append(", ");
                        }
                        mensaje.setLength(mensaje.length() - 2); 
                        mensaje.append("\n");
                    }
                }
            }
        }
    }
    
    if (!escalerasEncontradas) {
        mensaje = new StringBuilder("NO HAY CARTAS EN ESCALERA");
    }
    
    return mensaje.toString();
}

public int calcularPuntaje() {
    int puntaje = 0;
    int[] contadores = new int[NombreCarta.values().length];

    
    for (int i = 0; i < cartas.length; i++) {
        contadores[cartas[i].getNombre().ordinal()]++;
    }

   
    for (int i = 0; i < contadores.length; i++) {
        if (contadores[i] == 1) { // Carta sin pareja
            NombreCarta nombre = NombreCarta.values()[i];
            if (nombre == NombreCarta.AS ||
                nombre == NombreCarta.JACK ||
                nombre == NombreCarta.QUEEN ||
                nombre == NombreCarta.KING) {
                puntaje += 10; 
            } else {
                puntaje += (i + 1); 
            }
        }
    }

    return puntaje;
}


}