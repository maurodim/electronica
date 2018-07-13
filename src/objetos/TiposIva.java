/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author mauro
 */
public class TiposIva {
    private int id;
    private float baseImponible;
    private float importe;

    public TiposIva(int id, float baseImponible, float importe) {
        this.id = id;
        this.baseImponible = baseImponible;
        this.importe = importe;
    }
    
    
    public int getId() {
        return id;
    }

    public float getBaseImponible() {
        return baseImponible;
    }

    public float getImporte() {
        return importe;
    }
    
    
}
