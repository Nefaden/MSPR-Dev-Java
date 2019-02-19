package DAL;

import BO.BoMaterial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DalMaterial {

    public static BoMaterial getOneById(int idMaterial) throws SQLException {
        BoMaterial objMaterial = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "SELECT * FROM MATERIAL WHERE ID_MATERIAL= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idMaterial);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objMaterial = DalMaterial.MaterialFromResultSet(rs);
        }
        return objMaterial;
    }

    public static List<BoMaterial> getAll() throws SQLException {
        ArrayList<BoMaterial> arrObjMaterial = new ArrayList<BoMaterial>();
        BoMaterial objMaterial;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM MATERIAL";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            objMaterial = DalMaterial.MaterialFromResultSet(rs);
            arrObjMaterial.add(objMaterial);
        }
        return arrObjMaterial;
    }


    public static BoMaterial insertMaterial(int idMaterial, String strLabel, int intMaxAmount) throws SQLException {
        BoMaterial objMaterial = new BoMaterial(0, null, 0);
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "INSERT INTO MATERIAL (ID_MATERIAL, LABEL, MAX_AMOUNT) VALUES (idMaterial, label, maxAmount)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(idMaterial, 1);
        pstmt.setString(1, strLabel);
        pstmt.setInt(intMaxAmount, 1);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objMaterial = DalMaterial.MaterialFromResultSet(rs);
        }
        return objMaterial;
    }

    public static void updateMaterial(int idMaterial, String strLabel, int intMaxAmount) throws SQLException {
        AtomicReference<BoMaterial> objMaterial = new AtomicReference<>(DalMaterial.getOneById(idMaterial));
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "UPDATE MATERIAL (ID_MATERIAL, LABEL, MAX_AMOUNT) VALUES (idMaterial, label, maxAmount)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, strLabel);
        pstmt.setInt(1, intMaxAmount);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objMaterial.set(DalMaterial.MaterialFromResultSet(rs));
        }
    }

    public static void deleteMaterial(int idMaterial) throws SQLException {
        BoMaterial objMaterial = DalMaterial.getOneById(idMaterial);
        ResultSet rs = null;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "DELETE FROM MATERIAL WHERE ID_MATERIAL = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
    }

    private static BoMaterial MaterialFromResultSet(ResultSet rs) throws SQLException {
        BoMaterial objMaterial = null;
        int idMaterial = rs.getInt("ID_MATERIAL");
        String label = rs.getString("LABEL");
        int maxAmount = rs.getInt("MAX_AMOUNT");
        objMaterial =  new BoMaterial(idMaterial, label, maxAmount);
        return objMaterial;
    }
}
