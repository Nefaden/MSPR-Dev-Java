package TestDAL;

import BO.BoUser;
import DAL.DalUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDalUser {

    public static void main(String[] args) {

        Connection connection = null;

        try {
//            test0_Connexion();
//            System.out.println("Test0 done : connection\n");

            test1_UniqueSelection(1);
            System.out.println("Test1 done : Unique selection\n");

            test2_MultipleSelection();
            System.out.println("Test2 done : Multiple selections\n");

            test3_insertUser();
            System.out.println("Test3 done : Updating data");

            test4_UpdateUser(100);
            System.out.println("Test4 done : Inserting data");

            test5_DeleteUser(100);
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
     * @param idUser
     * Display an user by his ID
     * @throws SQLException
     */
    public static void test1_UniqueSelection(int idUser) throws SQLException {
        BoUser objUser = DalUser.getOneById(idUser);
        System.out.println("User identified by : "+idUser+" : "+objUser.toString());
    }

    /**
     * Display all users
     * @throws SQLException
     */
    public static void test2_MultipleSelection() throws SQLException {
        List<BoUser> arrObjUsers = DalUser.getAll();
        System.out.println("List of all available Users : "+arrObjUsers.toString());
    }

    /**
     *
     * Insert a new user
     * @throws SQLException
     */
    public static void test3_insertUser() throws SQLException {
        BoUser objUser = new BoUser(100, "Serge", "Blanco", "serge.blanco@email.com", "06 15 28 54 91");
        DalUser.insertUser(objUser);
        System.out.println("User inserted");
    }

    /**
     *
     * @param idUser
     * Update a selected user
     * @throws SQLException
     */
    public static void test4_UpdateUser(int idUser) throws SQLException {
        BoUser objUser = DalUser.getOneById(idUser);
        objUser.setS_PhoneNumberUser("0123456789");
        objUser.setS_EmailUser("newemail@testemail.com");
        DalUser.updateUser(idUser);
        System.out.println("User updated");
    }

    /**
     *
     * @param idUser
     * Deleting the new user
     * @throws SQLException
     */
    public static void test5_DeleteUser(int idUser) throws SQLException {
        DalUser.deleteUser(idUser);
        System.out.println("User deleted");
    }
}
