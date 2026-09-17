import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piloto09 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piloto09 extends PilotoBase
{
    /**
     * Act - do whatever the Piloto09 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(NaveDeAtaque nave)
    {
        subirse(nave);
        nave.encenderMotores();
        ejecutarMision(nave);// Add your action code here.
    }
    
    public void ejecutarMision(NaveDeAtaque nave){
        avanzarHastaCadenaDeAsteroides(nave);
        buscarPrimerAsteroideHaciaElOeste(nave);
        int masGrande = buscarTamañoMaximoDEAsteroide(nave);
        posicionarLaNaveDebajoDelGrandote(nave, masGrande);
        avanzarAlSurHastaNaveEnemiga(nave);
        destruirNaveEnemiga(nave);
        //regresarALaBase(nave);
    }
    
    public void avanzarHastaCadenaDeAsteroides(NaveDeAtaque nave){
        while(!nave.hayAsteroideHacia(Direccion.NORTE)){
            nave.avanzarHacia(Direccion.NORTE);
        }    
    }
    public void buscarPrimerAsteroideHaciaElOeste(NaveDeAtaque nave){
        while(nave.hayAsteroideHacia(Direccion.NORTE)){
            nave.avanzarHacia(Direccion.OESTE);
        }
        nave.avanzarHacia(Direccion.ESTE);
    }
    
    public int buscarTamañoMaximoDEAsteroide(NaveDeAtaque nave){
        int maximo = nave.escanearIndicadorHacia(Direccion.NORTE);
        while(nave.hayAsteroideHacia(Direccion.NORTE)){
            nave.avanzarHacia(Direccion.ESTE);
            if(nave.escanearIndicadorHacia(Direccion.NORTE) > maximo){
                maximo = nave.escanearIndicadorHacia(Direccion.NORTE);
            }
        }
        nave.avanzarHacia(Direccion.OESTE);
        return maximo;
    }
    
    public void posicionarLaNaveDebajoDelGrandote(NaveDeAtaque nave, int maximo){
        while (nave.escanearIndicadorHacia(Direccion.NORTE) != maximo){
            nave.avanzarHacia(Direccion.OESTE);
        }
    }
    
    public void avanzarAlSurHastaNaveEnemiga(NaveDeAtaque nave){
        while(!nave.hayNaveHacia(Direccion.SUR)){
            nave.avanzarHacia(Direccion.SUR);
        }
        
    }
    
    public void destruirNaveEnemiga(NaveDeAtaque nave){
        while(nave.hayNaveHacia(Direccion.SUR)){
            nave.atacarHacia(Direccion.SUR);
        }
    }
}
