package TestBO;

import BO.BoUser;

public class TestBoUser {

    public static void main(String[] args) {

        System.out.println("\nTest n°1 : getter");
        BoUser objUser = new BoUser(1, "Durand", "Yann", "ydurand@epsi.fr", "06 35 39 65 19");
        System.out.println(objUser.getI_IdUser());
        System.out.println(objUser.getS_NameUser());
        System.out.println(objUser.getS_FirstNameUser());
        System.out.println(objUser.getS_EmailUser());
        System.out.println(objUser.getS_PhoneNumberUser());

        System.out.println("\nTest n°2 : setter");
        objUser.setI_IdUser(69);
        objUser.setS_NameUser("Marie");
        objUser.setS_FirstNameUser("Jean");
        objUser.setS_EmailUser("jmarie@testemail.fr");
        objUser.setS_PhoneNumberUser("06 66 66 66 66");
        System.out.println(objUser.getI_IdUser());
        System.out.println(objUser.getS_NameUser());
        System.out.println(objUser.getS_FirstNameUser());
        System.out.println(objUser.getS_EmailUser());
        System.out.println(objUser.getS_PhoneNumberUser());
        objUser = new BoUser(1, null, null, null, null);
        System.out.println(objUser.equals(objUser));
    }
}
