package DAL;

import BO.BoMaterial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DalMaterial {

    public static BoMaterial getOneById(int idMaterial) throws SQLException {
        BoMaterial objMaterial = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "SELECT * FROM MATERIAL WHERE ID_MATERIAL = ?";
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


    public static void insertMaterial(BoMaterial objMaterial) throws SQLException {
        int idMaterial = objMaterial.getI_IdMaterial();
        String strLabel = objMaterial.getS_LabelMaterial();
        int intMaxAmount = objMaterial.getI_MaxAmount();
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "INSERT INTO MATERIAL (ID_MATERIAL, LABEL, MAX_AMOUNT) VALUES (idMaterial, label, maxAmount)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(idMaterial, 1);
        //noinspection JpaQueryApiInspection
        pstmt.setString(1, strLabel);
        pstmt.setInt(intMaxAmount, 1);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objMaterial = DalMaterial.MaterialFromResultSet(rs);
        }
    }

    public static BoMaterial updateMaterial(int idMaterial) throws SQLException {
        BoMaterial objMaterial = DalMaterial.getOneById(idMaterial);
        String strLabel = DalMaterial.getOneById(idMaterial).getS_LabelMaterial();
        int intMaxAmount = DalMaterial.getOneById(idMaterial).getI_MaxAmount();
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // Prepared request
        String requete = "UPDATE MATERIAL SET ID_MATERIAL = idMaterial, LABEL = strLabel, MAX_AMOUNT = intMaxAmount";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        //noinspection JpaQueryApiInspection
        pstmt.setString(1, strLabel);
        //noinspection JpaQueryApiInspection
        pstmt.setInt(1, intMaxAmount);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            objMaterial = DalMaterial.MaterialFromResultSet(rs);
        }
        return objMaterial;
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
