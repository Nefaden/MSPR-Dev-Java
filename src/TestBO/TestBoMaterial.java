package TestBO;

import BO.BoMaterial;

public class TestBoMaterial {

    public static void main(String[] args) {

        System.out.println("\nTest n°1 : getter");
        BoMaterial objMaterial = new BoMaterial(1, "Menottes", 5);
        System.out.println(objMaterial.getI_IdMaterial());
        System.out.println(objMaterial.getS_LabelMaterial());
        System.out.println(objMaterial.getI_MaxAmount());

        System.out.println("\nTest n°2 : setter");
        objMaterial.setI_IdMaterial(5);
        objMaterial.setS_LabelMaterial("Mousqueton");
        objMaterial.setI_MaxAmount(15);
        System.out.println(objMaterial.getI_IdMaterial());
        System.out.println(objMaterial.getS_LabelMaterial());
        System.out.println(objMaterial.getI_MaxAmount());
        objMaterial = new BoMaterial(1, null, 0);
        System.out.println(objMaterial.equals(objMaterial));
    }
}