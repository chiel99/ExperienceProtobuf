
package twincatstudio.io.pokedex.gson;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("candy")
    @Expose
    private String candy;
    @SerializedName("egg")
    @Expose
    private String egg;
    //@SerializedName("multipliers")
    //@Expose
    //private double multipliers;
    @SerializedName("weaknesses")
    @Expose
    private List<String> weaknesses = new ArrayList<String>();
    @SerializedName("next_evolution")
    @Expose
    private List<NextEvolution> nextEvolution = new ArrayList<NextEvolution>();
    @SerializedName("prev_evolution")
    @Expose
    private List<PrevEvolution> prevEvolution = new ArrayList<PrevEvolution>();

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

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

    /**
     * 
     * @return
     *     The img
     */
    public String getImg() {
        return img;
    }

    /**
     * 
     * @param img
     *     The img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return
     *     The candy
     */
    public String getCandy() {
        return candy;
    }

    /**
     * 
     * @param candy
     *     The candy
     */
    public void setCandy(String candy) {
        this.candy = candy;
    }

    /**
     * 
     * @return
     *     The egg
     */
    public String getEgg() {
        return egg;
    }

    /**
     * 
     * @param egg
     *     The egg
     */
    public void setEgg(String egg) {
        this.egg = egg;
    }

    /**
     * 
     * @return
     *     The multipliers
     */
//    public double getMultipliers() {
//        return multipliers;
//    }

    /**
     * 
     * @param multipliers
     *     The multipliers
     */
//    public void setMultipliers(double multipliers) {
//        this.multipliers = multipliers;
//    }

    /**
     * 
     * @return
     *     The weaknesses
     */
    public List<String> getWeaknesses() {
        return weaknesses;
    }

    /**
     * 
     * @param weaknesses
     *     The weaknesses
     */
    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    /**
     * 
     * @return
     *     The nextEvolution
     */
    public List<NextEvolution> getNextEvolution() {
        return nextEvolution;
    }

    /**
     * 
     * @param nextEvolution
     *     The next_evolution
     */
    public void setNextEvolution(List<NextEvolution> nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    /**
     * 
     * @return
     *     The prevEvolution
     */
    public List<PrevEvolution> getPrevEvolution() {
        return prevEvolution;
    }

    /**
     * 
     * @param prevEvolution
     *     The prev_evolution
     */
    public void setPrevEvolution(List<PrevEvolution> prevEvolution) {
        this.prevEvolution = prevEvolution;
    }

}
