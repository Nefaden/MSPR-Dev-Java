package DAL;

import BO.BoAgent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DalAgent {

    public static BoAgent getOneById(int idUser) throws SQLException {
        BoAgent objUser = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "SELECT * FROM USER WHERE ID_USER = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idUser);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objUser = DalAgent.AgentFromResultSet(rs);
        }
        return objUser;
    }


    public static List<BoAgent> getAll() throws SQLException {
        ArrayList<BoAgent> arrObjAgents = new ArrayList<>();
        BoAgent objAgent;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM USER ";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            objAgent = DalAgent.AgentFromResultSet(rs);
            arrObjAgents.add(objAgent);
        }
        return arrObjAgents;
    }

    public static void insertAgent(BoAgent objAgent) throws SQLException {
        int idAgent = objAgent.getI_IdAgent();
        String strNameAgent = objAgent.getS_NameAgent();
        String strFirstNameAgent = objAgent.getS_FirstNameAgent();
        String strEmailAgent = objAgent.getS_EmailAgent();
        String strPhoneNumberAgent = objAgent.getS_PhoneNumberAgent();
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "INSERT INTO AGENT (ID_AGENT, LASTNAME, FIRSTNAME, EMAIL, PHONENUMBER) VALUES (idAgent, strNameAgent, strFirstNameAgent, strEmailAgent, strPhoneNumberAgent)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(idAgent, 1);
        //noinspection JpaQueryApiInspection
        pstmt.setString(1, strNameAgent);
        //noinspection JpaQueryApiInspection
        pstmt.setString(1, strFirstNameAgent);
        //noinspection JpaQueryApiInspection
        pstmt.setString(1, strEmailAgent);
        //noinspection JpaQueryApiInspection
        pstmt.setString(1, strPhoneNumberAgent);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objAgent = DalAgent.AgentFromResultSet(rs);
        }
    }

    public static BoAgent updateAgent ( int idAgent) throws SQLException {
        BoAgent objAgent = DalAgent.getOneById(idAgent);
        String strNameAgent = DalAgent.getOneById(idAgent).getS_NameAgent();
        String strFirstNameAgent = DalAgent.getOneById(idAgent).getS_FirstNameAgent();
        String strEmailAgent = DalAgent.getOneById(idAgent).getS_EmailAgent();
        String strPhoneNumberAgent = DalAgent.getOneById(idAgent).getS_PhoneNumberAgent();
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "UPDATE AGENT SET ID_AGENT = idAgent, LASTNAME = strNameAgent, FIRSTNAME = strFirstNameAgent, EMAIL = strEmailAgent, PHONENUMBER = strPhoneNumberAgent)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, strNameAgent);
        pstmt.setString(1, strFirstNameAgent);
        pstmt.setString(1, strEmailAgent);
        pstmt.setString(1, strPhoneNumberAgent);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objAgent = DalAgent.AgentFromResultSet(rs);
        }
        return objAgent;
    }

        public static void deleteAgent ( int idAgent) throws SQLException {
            BoAgent objAgent = DalAgent.getOneById(idAgent);
            ResultSet rs = null;
            PreparedStatement pstmt;
            Jdbc jdbc = Jdbc.getInstance();
            // Prepared request
            String requete = "DELETE FROM AGENT WHERE ID_AGENT = ?";
            pstmt = jdbc.getConnexion().prepareStatement(requete);
        }

    private static BoAgent AgentFromResultSet(ResultSet rs) throws SQLException {
        BoAgent objMaterial = null;
        int idUser = rs.getInt("ID_USER");
        String name = rs.getString("NAME");
        String firstname = rs.getString("FIRSTNAME");
        String email = rs.getString("EMAIL");
        String phonenumber = rs.getString("PHONENUMBER");
        objMaterial = new BoAgent(idUser, name, firstname, email, phonenumber);
        return objMaterial;
    }
}
