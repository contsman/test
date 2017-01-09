package test;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2015/12/21
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public enum UserHobbyEnum {
    UNKNOWN(0,"unknown","",""),
    HUMOR(1,"humor","humor","comedy"),
    NEWS(2,"news","news","news"),
    MOVIETRAILERS(3,"movie trailers","movie","music"),
    CELEBRITYGOSSIP(4,"celebrity gossip","gossip","lifestyle"),
    FASHIONFIFESTYLE(5,"fashion & lifestyle","fashion","movies"),
    HEALTHFITNESS(6,"health & fitness","health","sports");

    public int getValue() {
        return value;
    }

    public String getHobbyname() {
        return hobbyname;
    }

    public String getLabelclassname() {
        return labelclassname;
    }

    public String getBackimg() {
        return backimg;
    }

    public final int value;
    public final String hobbyname;
    public final String labelclassname;
    public final String backimg;
    private UserHobbyEnum(int value, String hobbyname,String labelclassname,String backimg) {
        this.value = value;
        this.hobbyname = hobbyname;
        this.labelclassname = labelclassname;
        this.backimg = backimg;
    }

    /***
     * hobby values,separated by commas
     * @return hobby names
     */
    public String[] getHobbyNamesByValues(String values){
        if(values==null||"".endsWith(values))
            return new String[0];
        String[] valueArr = values.split(",");
        String[] nameArr = new String[valueArr.length];
        for (int i = 0;i<valueArr.length;i++){
            nameArr[i] = getHobby(converterToInt(valueArr[i],0)).hobbyname;
        }
        return nameArr;
    }

    public static int converterToInt(String number, int ret) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return ret;
        }
    }
    /***
     *
     * @param hobby
     * @return
     */
    public static UserHobbyEnum getHobby(int hobby) {
        switch (hobby) {
            case 1:
                return HUMOR;
            case 2:
                return NEWS;
            case 3:
                return MOVIETRAILERS;
            case 4:
                return CELEBRITYGOSSIP;
            case 5:
                return FASHIONFIFESTYLE;
            case 6:
                return HEALTHFITNESS;
            default:
                return UNKNOWN;
        }
    }

    public static UserHobbyEnum getHobby(String hobby) {
        if ("humor".equals(hobby))
            return HUMOR;
        if ("news".equals(hobby))
            return NEWS;
        if ("movie trailers".equals(hobby))
            return MOVIETRAILERS;
        if ("celebrity gossip".equals(hobby)||"celebrities".equals(hobby))
            return CELEBRITYGOSSIP;
        if ("fashion & lifestyle".equals(hobby))
            return FASHIONFIFESTYLE;
        if ("health & fitness".equals(hobby))
            return HEALTHFITNESS;
        return UNKNOWN;
    }
}