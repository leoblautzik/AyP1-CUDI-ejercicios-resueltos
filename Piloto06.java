import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piloto06 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piloto06 extends PilotoBase
{
    /**
     * Act - do whatever the Piloto06 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public void misionEspiral(NaveDeAtaque nave, int vueltas){
        subirse(nave);
        nave.encenderMotores();
        nave.avanzarHacia(Direccion.NORTE);

        for(int i=1; i<=vueltas;i++){
            darUnaVuelta(nave,i);
        }
        
    }

    public void darUnaVuelta(NaveDeAtaque nave, int numeroDeVuelta){
        avanzarHaciaPor(nave, Direccion.ESTE, numeroDeVuelta);
        avanzarHaciaPor(nave, Direccion.SUR, 2 * numeroDeVuelta);
        avanzarHaciaPor(nave, Direccion.OESTE, 2 * numeroDeVuelta);
        avanzarHaciaPor(nave, Direccion.NORTE, 2 * numeroDeVuelta + 1);
        avanzarHaciaPor(nave, Direccion.ESTE, numeroDeVuelta);

    }

    public void avanzarHaciaPor(NaveDeAtaque nave, Direccion direccion, int pasos){
        for(int i=0; i<pasos; i++){
            nave.avanzarHacia(direccion);
        }
    }

}
