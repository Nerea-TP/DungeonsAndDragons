package dd.main;

import java.util.Arrays;

import dd.otro.*;

public class Control {
    // instancias ataques
    AtaqueArco ataqueArco = new AtaqueArco();
    AtaqueCuchillo ataqueCuchillo = new AtaqueCuchillo();
    AtaqueEspada ataqueEspada = new AtaqueEspada();

    /**
     * Presenta e inicia el juego
     */
    Control() {
        presentarjuego();
        lucha();
    }

    /**
     * Método que presenta el juego
     */
     void presentarjuego() {
        System.out.println("Tal día como hoy, en una húmeda y fría mañana de finales de primavera");
        System.out.println("la partida formada por: Rey Arturo, Lancelot, Percival");
        System.out.println(" hallándose en los frondosos bosques del sitio de Deorham, se topó con una");
        System.out.println("patrulla de 3 de esas sanguinarias e inhumanas criaturas popularmente");
        System.out.println(" conocidas como trolls.");
        System.out.println("De la batalla que aconteció, dejo aquí testimonio:");
    }

    /**Método que crea el ejército de los humanos
     * @return array del ejército de los humanos
     */
    Personaje[] crearHombres() {

        // instancias hombres
        Rey Arturo = new Rey("Arturo");
        Caballero Lancelot = new Caballero("Lancelot");
        Caballero Percival = new Caballero("Percival");
        // elegmos el método de ataque de cada hombre
        Arturo.setAtaque(ataqueEspada);
        Lancelot.setAtaque(ataqueEspada);
        Percival.setAtaque(ataqueArco);
        // creamos el enemigoay de hombres
        Personaje[] hombresEjercito = { Arturo, Percival, Lancelot };
        return hombresEjercito;
    }

    /**Método que crea el ejército de los Trolls
     * @return array del ejército de los Trolls
     */
    Personaje[] crearTrolls() {
        // los trolls pueden ser de mínimo 2 inclusivo y máximo 10
        int numTrolls = (int) Math.floor(Math.random() * (10 - 2+1) + 2);
        Personaje[] trollsEjercito = new Personaje[numTrolls];
        // creamos el enemigo de trolls
        for (int i = 0; i < numTrolls; i++) {
            // generamos un número aleatorio entre 1 y 3 para
            // elegir el ataque: arco, cuchillo, espada.
            int tipoAtaque = (int) Math.floor(Math.random() * (3 - 1+1) + 1);
            String nomTroll = "Troll " + (i+1);
            Troll trolls = new Troll(nomTroll);
            switch (tipoAtaque) {
                case 1:
                    trolls.setAtaque(ataqueArco);
                    ;
                    break;

                case 2:
                    trolls.setAtaque(ataqueCuchillo);
                    break;

                case 3:
                    trolls.setAtaque(ataqueEspada);
                    break;

            }
            trollsEjercito[i] = trolls;
        }
        return trollsEjercito;
    }

    /** Método que retira del ejército el personaje que ha muerto
     * @param original Ejército que ataca
     * @param enemigo Ejército que recibe el ataque
     * @param pos Personaje del ejército enemigo que recibe el ataque
     * @return array del ejército enemigo sólo con los personajes vivos
     */
     Personaje[] removerMuerto(Personaje[] original, Personaje[] enemigo, int pos) {
        // cuando la vida del enemig es 0 o menos muere
        if (enemigo[pos].getVida() <= 0) {
            System.out.println(enemigo[pos] + " muere!");
            // lo sacamos del array
            Personaje[] ejercitoSobreviven = new Personaje[enemigo.length - 1];
            int k = 0;
            for (int i = 0; i < enemigo.length; i++) {
                if (enemigo[i].getVida() > 0) {
                    ejercitoSobreviven[k] = enemigo[i];
                    k++;
                }
            }
            enemigo = ejercitoSobreviven;
        }
        return enemigo;
    }

    /**Métodod que nos indica que ejército ha ganado
     * @param original Ejército de los hombres
     * @param enemigo Ejército de los trolls
     */
    void ganador(Personaje[]original, Personaje[]enemigo){
        if (original.length > 0) {
            System.out.println("Finalmente. el ejército del Rey Arturo venció!!!" +
                    "\nLos supervivientes de la batalla fueron:");
            for (Personaje h : original) {
                System.out.print(h.toString());
            }
        } else {
            System.out.println("Finalmente. el ejército de los Trolls venció!!!" +
                    "\nLos supervivientes de la batalla fueron:");
            for (Personaje t : enemigo) {
                System.out.print(t.toString());
            }
        }
    }
   
    /**
     * Método donde se desarrolla la batalla entre ejércitos
     */
   
     void lucha() {
        Personaje[] hombresEjercito = crearHombres();
        Personaje[] trollsEjercito = crearTrolls();
        do {
            //atacan hombres
            for (Personaje h : hombresEjercito) {
                // elegimos aleatoriamente nuestros contrincantes, donde
                // el tamaño del array siempre será el máximo
                int eleccion = (int) (Math.random() * (trollsEjercito.length));
                // el resultado del ataque
                System.out.println(h.toString() + " lucha contra " + trollsEjercito[eleccion]);
                int[] resultado = h.ataca(trollsEjercito[eleccion]);
                for (int i = 0; i < resultado.length; i++) {
                    if (resultado[i] == 0) {
                        System.out.println("Ataque con " + h.getAtaque().toString() + " (falla)");
                    } else {
                        System.out.println("Ataque con " + h.getAtaque().toString() + " (" + -resultado[i] + ")");
                    }
                }
                trollsEjercito=removerMuerto(hombresEjercito, trollsEjercito, eleccion);
                if (trollsEjercito.length == 0 || hombresEjercito.length == 0) {
                    break;
                }
            }

            // ahora toca atacan los trolls, hacemos el mismo for, pero cambiando de bando
            for (Personaje t : trollsEjercito) {

                int posicion = (int) (Math.random() * (hombresEjercito.length));
                System.out.println(t.toString() + "lucha contra" + hombresEjercito[posicion].toString());

                int[] resultado1 = t.ataca(hombresEjercito[posicion]);
                for (int i = 0; i < resultado1.length; i++) {
                    if (resultado1[i] != 0) {
                        System.out.println("Ataque con " + t.getAtaque().toString() + "(" + (-resultado1[i]) + ")");

                    } else {
                        System.out.println("Ataque con " + t.getAtaque().toString() + "(falla)");
                    }
                }
                hombresEjercito=removerMuerto(trollsEjercito, hombresEjercito, posicion);
                if (trollsEjercito.length == 0 || hombresEjercito.length == 0) {
                    break;
                }
            }
           
        } while (hombresEjercito.length > 0 && trollsEjercito.length > 0);
        ganador(hombresEjercito, trollsEjercito);
    }
    
}
