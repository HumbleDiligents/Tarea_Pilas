/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tareapilas;

/**
 *
 * @author Sebastian
 */
public class TareaPilas {

    public static void main(String[] args) {
        Lavaplatos lavado = new Lavaplatos();
        
        // Se coloca un vaso con 3 cubiertos de primero
        lavado.insertarTraste(new Vaso());
        lavado.insertarTraste(new Tenedor());
        lavado.insertarTraste(new Cuchillo());
        lavado.insertarTraste(new Cuchara());

        // Se coloca un plato con 2 cubiertos, se pasan los 3 cubiertos del vaso al plato
        Plato plato1 = new Plato();
        plato1.agregarCubiertos(new Tenedor());
        plato1.agregarCubiertos(new Cuchillo());
        lavado.insertarTraste(plato1);

        // Se coloca un plato sin cubiertos, los cubiertos del plato anterior pasan a estar sobre este
        lavado.insertarTraste(new Plato());

        lavado.imprimirPila();
    }
    }
}
