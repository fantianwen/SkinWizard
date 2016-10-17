package van.tian.wen.lowerskinwizard.skin;

/**
 * Created by RadAsm on 16/10/14.
 */
public class SkinConfig {

    // 该控件允许换肤
    public static final String SKIN_ATTRIBUTE_NAME = "skinChangeEnable";
    public static final String SKIN_CHANGE_NAMESPACE = "http://schemas.android.com/van";
    public static final String SKIN_TEMP_NAME = "SKIN_TEMP_NAME";
    public static final int DEFAULT_SKIN = 0;
    public static final String SKIN_NAME = "SKIN_NAME";

    enum SKIN_ATTRIBUTE {
        BACKGROUND(0, "background"),
        TEXTCOLOR(1, "textColor");

        /**
         * 用于在sparseArray中存储时使用的key
         */
        int code;
        String attributeName;

        SKIN_ATTRIBUTE(int code, String attributeName) {
            this.code = code;
            this.attributeName = attributeName;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }
    }

    /**
     * 各种不同的skin种类
     */
    public enum SKIN {

        // 默认
        DEFAULT(0),

        // 黑夜骑士
        BLACK_NIGHT(1);

        int code;

        SKIN(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

    }


}
