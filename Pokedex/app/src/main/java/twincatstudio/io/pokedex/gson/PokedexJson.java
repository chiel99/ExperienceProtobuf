
package twincatstudio.io.pokedex.gson;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokedexJson {

    @SerializedName("pokemon")
    @Expose
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();

    /**
     * 
     * @return
     *     The pokemon
     */
    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    /**
     * 
     * @param pokemon
     *     The pokemon
     */
    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

}
