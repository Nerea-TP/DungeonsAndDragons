package dd.otro;

public abstract class Personaje {
    private String nombre;
    private Ataque ataque;
    private int vida;

    /** Constructor que crea el personaje con su nombre y establece el ataque
     * @param nombre del personaje
     */
    public Personaje(String nombre) {
        this.nombre = nombre;
        setAtaque(ataque);
    }

    /**Devuelve el tipo de ataque
     * @return
     */
    public Ataque getAtaque() {
        return ataque;
    }

    /**Establece el tipo ataque
     * @param ataque
     */
    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    /** Devuelve la vida del personaje
     * @return
     */
    public int getVida() {
        return vida;
    }

    /**Establece la vida del personaje
     * @param vida del personaje
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**Devuelve el nombre del personaje
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**Establece del nombre del personaje
     * @param nombre del personaje
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**Calcula la salud actualizada del personaje restandole el daño recibido
     * @param valor daño realizado por el ataque enemigo
     * @return
     */
    public int saludActualizada(int valor) {
        vida = vida - valor;
        return vida;
    }

    /**Método abstracto que inicia el ataque del personaje
     * @param enemigo Personaje enemigo al que se va a atacar
     * @return
     */
    public abstract int[] ataca(Personaje enemigo);

    @Override
    public String toString() {
        return this.nombre + ": " + this.vida + "]";
    }

}
