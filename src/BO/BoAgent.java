/**
 * Application Java check of personnal picture
 *
 * User class
 * @Created by ydurand
 * @Version 0.1
 */

package BO;

public class BoAgent {

    private int i_IdAgent;
    private String s_NameAgent;
    private String s_FirstNameAgent;
    private String s_EmailAgent;
    private String s_PhoneNumberAgent;
    //private String s_PhotoAgent;
    //private img img_PersonnalPicture;

    //Default constructor
    public BoAgent(int i, Object o, Object o1) {
    }

    public BoAgent(int intIdAgent, String strNameAgent, String strFirstNameAgent, String strEmailAgent, String strPhoneNumberAgent/*, String strPhotoUser*/) {
        this.i_IdAgent = intIdAgent;
        this.s_NameAgent = strNameAgent;
        this.s_FirstNameAgent = strFirstNameAgent;
        this.s_EmailAgent = strEmailAgent;
        this.s_PhoneNumberAgent = strPhoneNumberAgent;
        //this.s_PhotoUser = strPhotoUser;
    }

    //Getter
    public int getI_IdAgent() {
        return i_IdAgent;
    }

    public String getS_NameAgent() {
        return s_NameAgent;
    }

    public String getS_FirstNameAgent() {
        return s_FirstNameAgent;
    }

    public String getS_EmailAgent() {
        return s_EmailAgent;
    }

    public String getS_PhoneNumberAgent() {
        return s_PhoneNumberAgent;
    }

    //public String getS_PhotoUser() {
    //    return s_PhotoUser;
    //}

    //Setter
    public void setI_IdAgent(int intIdAgent) {
        this.i_IdAgent = intIdAgent;
    }

    public void setS_NameAgent(String strNameAgent) {
        this.s_NameAgent = strNameAgent;
    }

    public void setS_FirstNameAgent(String strFirstNameAgent) {
        this.s_FirstNameAgent = strFirstNameAgent;
    }

    public void setS_EmailAgent(String strEmailAgent) {
        this.s_EmailAgent = strEmailAgent;
    }

    public void setS_PhoneNumberAgent(String strPhoneNumberAgent) {
        this.s_PhoneNumberAgent = strPhoneNumberAgent;
    }

    //public void setS_PhotoUser(String strPhotoUser) {
    //   this.s_PhotoUser = strPhotoUser;
    //}
}

