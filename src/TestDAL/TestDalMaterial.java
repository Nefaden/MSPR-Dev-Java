package TestDAL;

import BO.BoMaterial;
import DAL.DalMaterial;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDalMaterial {

    public static void main(String[] args) {

        Connection connection = null;

        try {
//            test0_Connexion();
//            System.out.println("Test0 done : connection\n");

            test1_UniqueSelection(1);
            System.out.println("Test1 done : Unique selection\n");

            test2_MultipleSelection();
            System.out.println("Test2 done : Multiple selections\n");

            test3_insertMaterial();
            System.out.println("Test3 done : Updating data");

            test4_UpdateMaterial(100);
            System.out.println("Test4 done : Inserting data");

            test5_DeleteMaterial(100);
            System.out.println("Test5 done : Deleting data");

//        } catch (ClassNotFoundException e) {
//            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing Jdbc connection : " + e);
            }
        }

    }

//    /**
//     * Verify is there only one connection on our SGBD
//     * @throws ClassNotFoundException
//     * @throws SQLException
//     */
//    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
//        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", "ydurand_festival", "ydurand_festival_util", "secret");
//        Jdbc.getInstance().connected();
//        Connection cnx = Jdbc.getInstance().getConnexion();
//    }

    /**
     * @param idMaterial
     * Display a Material by his ID
     * @throws SQLException
     */
    public static void test1_UniqueSelection(int idMaterial) throws SQLException {
        BoMaterial objMaterial = DalMaterial.getOneById(idMaterial);
        System.out.println("Material identified by : "+idMaterial+" : "+objMaterial.toString());
    }

    /**
     * Display all materials
     * @throws SQLException
     */
    public static void test2_MultipleSelection() throws SQLException {
        List<BoMaterial> arrObjMaterials = DalMaterial.getAll();
        System.out.println("List of all available Materials : "+arrObjMaterials.toString());
    }

    /**
     *
     * Insert a new material
     * @throws SQLException
     */
    public static void test3_insertMaterial() throws SQLException {
        BoMaterial objMaterial = new BoMaterial(100, "Matraque", 9);
        DalMaterial.insertMaterial(objMaterial);
        System.out.println("Material inserted");
    }

    /**
     *
     * @param idMaterial
     * Update a selected material
     * @throws SQLException
     */
    public static void test4_UpdateMaterial(int idMaterial) throws SQLException {
        BoMaterial objMaterial = DalMaterial.getOneById(idMaterial);
        objMaterial.setI_MaxAmount(3);
        objMaterial.setS_LabelMaterial("New updated material");
        DalMaterial.updateMaterial(idMaterial);
        System.out.println("Material updated");
    }

    /**
     *
     * @param idMaterial
     * Deleting the new material
     * @throws SQLException
     */
    public static void test5_DeleteMaterial(int idMaterial) throws SQLException {
        DalMaterial.deleteMaterial(idMaterial);
        System.out.println("Material" + idMaterial + "deleted");
    }
}
