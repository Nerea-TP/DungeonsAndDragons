package dd.otro;

import java.util.Random;

/**
 * Interfaz Ataque
 */
public interface Ataque {

    /**
     * Método abstracto de la interfaz Ataque que lanza ataque
     * @param enemigo Personaje enemigo al que se le lanza el ataque
     * @return
     */
    int lanzaAtaque(Personaje enemigo);
//acierto y factor es random usamos método static, que se puede usar en una interfaz
    /**Método estático para calcular el Acierto*Factor
     * @return acierto*factor
     */
    static double getAciertoFactor() {
        Random rand = new Random();
        // rango 0-1
        int acierto = rand.nextInt(2);
        double factor = rand.nextDouble();
        return acierto * factor;
    }
}