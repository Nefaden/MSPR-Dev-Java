package TestBO;

import BO.BoAgent;

public class TestBoAgent {

    public static void main(String[] args) {

        System.out.println("\nTest n°1 : getter");
        BoAgent objUser = new BoAgent(1, "Durand", "Yann", "ydurand@epsi.fr", "06 35 39 65 19");
        System.out.println(objUser.getI_IdAgent());
        System.out.println(objUser.getS_NameAgent());
        System.out.println(objUser.getS_FirstNameAgent());
        System.out.println(objUser.getS_EmailAgent());
        System.out.println(objUser.getS_PhoneNumberAgent());

        System.out.println("\nTest n°2 : setter");
        objUser.setI_IdAgent(100);
        objUser.setS_NameAgent("Marie");
        objUser.setS_FirstNameAgent("Jean");
        objUser.setS_EmailAgent("jmarie@testemail.fr");
        objUser.setS_PhoneNumberAgent("06 66 66 66 66");
        System.out.println(objUser.getI_IdAgent());
        System.out.println(objUser.getS_NameAgent());
        System.out.println(objUser.getS_FirstNameAgent());
        System.out.println(objUser.getS_EmailAgent());
        System.out.println(objUser.getS_PhoneNumberAgent());
        objUser = new BoAgent(1, null, null, null, null);
        System.out.println(objUser.equals(objUser));
    }
}
