package TestDAL;

import BO.BoAgent;
import DAL.DalAgent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestDalAgent {

    public static void main(String[] args) {

        Connection connection = null;

        try {
//            test0_Connexion();
//            System.out.println("Test0 done : connection\n");

            test1_UniqueSelection(1);
            System.out.println("Test1 done : Unique selection\n");

            test2_MultipleSelection();
            System.out.println("Test2 done : Multiple selections\n");

            test3_insertAgent();
            System.out.println("Test3 done : Updating data");

            test4_UpdateAgent(100);
            System.out.println("Test4 done : Inserting data");

            test5_DeleteAgent(100);
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
     * @param idAgent
     * Display an user by his ID
     * @throws SQLException
     */
    public static void test1_UniqueSelection(int idAgent) throws SQLException {
        BoAgent objUser = DalAgent.getOneById(idAgent);
        System.out.println("User identified by : "+idAgent+" : "+objUser.toString());
    }

    /**
     * Display all users
     * @throws SQLException
     */
    public static void test2_MultipleSelection() throws SQLException {
        List<BoAgent> arrObjUsers = DalAgent.getAll();
        System.out.println("List of all available Users : "+arrObjUsers.toString());
    }

    /**
     *
     * Insert a new user
     * @throws SQLException
     */
    public static void test3_insertAgent() throws SQLException {
        BoAgent objUser = new BoAgent(100, "Serge", "Blanco", "serge.blanco@email.com", "06 15 28 54 91");
        DalAgent.insertAgent(objUser);
        System.out.println("User inserted");
    }

    /**
     *
     * @param idAgent
     * Update a selected user
     * @throws SQLException
     */
    public static void test4_UpdateAgent(int idAgent) throws SQLException {
        BoAgent objUser = DalAgent.getOneById(idAgent);
        objUser.setS_PhoneNumberAgent("0123456789");
        objUser.setS_EmailAgent("newemail@testemail.com");
        DalAgent.updateAgent(idAgent);
        System.out.println("User updated");
    }

    /**
     *
     * @param idAgent
     * Deleting the new user
     * @throws SQLException
     */
    public static void test5_DeleteAgent(int idAgent) throws SQLException {
        DalAgent.deleteAgent(idAgent);
        System.out.println("User deleted");
    }
}
