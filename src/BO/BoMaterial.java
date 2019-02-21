/**
 * Application Java check of personnal picture
 *
 * Material class
 * @Created by ydurand
 * @Version 0.1
 */


package BO;

public class BoMaterial {

    private int i_IdMaterial;
    private String s_LabelMaterial;
    private int i_MaxAmount;

    public BoMaterial(int intIdMaterial, String strLabelMaterial, int intMaxAmount) {
        this.i_IdMaterial = intIdMaterial;
        this.s_LabelMaterial = strLabelMaterial;
        this.i_MaxAmount = intMaxAmount;
    }

    public int getI_IdMaterial() {
        return i_IdMaterial;
    }

    public String getS_LabelMaterial() {
        return s_LabelMaterial;
    }

    public int getI_MaxAmount() {
        return i_MaxAmount;
    }

    public void setI_IdMaterial(int intIdMaterial) {
        this.i_IdMaterial = intIdMaterial;
    }

    public void setS_LabelMaterial(String strLabelMaterial) {
        this.s_LabelMaterial = strLabelMaterial;
    }

    public void setI_MaxAmount(int intMaxAmount) {
        this.i_MaxAmount = intMaxAmount;
    }
}
