package dd.otro;

public class Caballero extends Personaje {

    /**Estabelce el nombre del personaje, incia la salud a 1500 y establece el tipo de Ataque con arco y espada
     * @param nombre
     */
    public Caballero(String nombre) {
        super(nombre);
        setVida(1500);
        setAtaque(new AtaqueArco());
        setAtaque(new AtaqueEspada());
    }
//el Caballero ataca 2 veces, si el enemigo muere antes del segundo ataque, no haberá ataque
    @Override
    public int[] ataca(Personaje enemigo) {
        int[] ataqueResultado = new int[2];
        for (int i = 0; i < ataqueResultado.length; i++) {
            if (enemigo.getVida() > 0) {
                ataqueResultado[i] = getAtaque().lanzaAtaque(enemigo);
            } else {
                break;
            }
        }
        return ataqueResultado;
    }

    @Override
    public String toString() {
        return "[Caballero " + super.toString();
    }

}
