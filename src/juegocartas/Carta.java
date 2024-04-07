  package juegocartas;

import java.util.Random;
import javax.swing.*;

public class Carta {

    public int getIndice() {
        return indice;
    }
    

    private int indice;

    
    public Carta(Random r) {
        
        indice = r.nextInt(52) + 1;
    }

    public Pinta getPinta() {
       
        if (indice <= 13) {
            return Pinta.TREBOL;
        } else if (indice <= 26) {
            return Pinta.PICA;
        } else if (indice <= 39) {
            return Pinta.CORAZON;
        } else {
            return Pinta.DIAMANTE;
        }
    }

    public NombreCarta getNombre() {
        int numero = indice % 13;
        if (numero == 0) {
            numero = 13;
        }
        return NombreCarta.values()[numero - 1];
    }

    public void mostrar(JPanel pnl, int x, int y) {

        
        String nombreImagen = "/imagenes/CARTA" + String.valueOf(indice) + ".jpg";

        
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));

       
        JLabel lbl = new JLabel(imagen);

        
        lbl.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());

        
        pnl.add(lbl);

    }

}


