/**
 * Application Java check of personnal picture
 *
 * User class
 * @Created by ydurand
 * @Version 0.1
 */

package BO;

public class BoUser {

    private int i_IdUser;
    private String s_NameUser;
    private String s_FirstNameUser;
    private String s_EmailUser;
    private String s_PhoneNumberUser;
    //private img img_PersonnalPicture;

    //Default constructor
    public BoUser() {
    }

    public BoUser(int intIdUser, String strNameUser, String strFirstNameUser, String strEmailUser, String strPhoneNumberUser) {
        this.i_IdUser = intIdUser;
        this.s_NameUser = strNameUser;
        this.s_FirstNameUser = strFirstNameUser;
        this.s_EmailUser = strEmailUser;
        this.s_PhoneNumberUser = strPhoneNumberUser;
    }

    //Getter
    public int getI_IdUser() {
        return i_IdUser;
    }

    public String getS_NameUser() {
        return s_NameUser;
    }

    public String getS_FirstNameUser() {
        return s_FirstNameUser;
    }

    public String getS_EmailUser() {
        return s_EmailUser;
    }

    public String getS_PhoneNumberUser() {
        return s_PhoneNumberUser;
    }

    //Setter
    public void setI_IdUser(int intIdUser) {
        this.i_IdUser = intIdUser;
    }

    public void setS_NameUser(String strNameUser) {
        this.s_NameUser = strNameUser;
    }

    public void setS_FirstNameUser(String strFirstNameUser) {
        this.s_FirstNameUser = strFirstNameUser;
    }

    public void setS_EmailUser(String strEmailUser) {
        this.s_EmailUser = strEmailUser;
    }

    public void setS_PhoneNumberUser(String strPhoneNumberUser) {
        this.s_PhoneNumberUser = strPhoneNumberUser;
    }
}

