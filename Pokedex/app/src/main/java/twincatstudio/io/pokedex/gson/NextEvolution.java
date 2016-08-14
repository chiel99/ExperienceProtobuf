
package twincatstudio.io.pokedex.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NextEvolution {

    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * 
     * @return
     *     The num
     */
    public String getNum() {
        return num;
    }

    /**
     * 
     * @param num
     *     The num
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

}
