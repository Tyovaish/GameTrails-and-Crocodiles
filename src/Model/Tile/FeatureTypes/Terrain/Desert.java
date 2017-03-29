package Model.Tile.FeatureTypes.Terrain;

import sun.security.krb5.internal.crypto.Des;

/**
 * Created by Trevor on 3/25/2017.
 */
public class Desert extends Terrain {
    public Desert(){addType("desert");}
    public void print(){
        System.out.println("Desert");
    }
}
