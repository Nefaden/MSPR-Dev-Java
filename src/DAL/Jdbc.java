package DAL;

import java.sql.*;

/**
 * Singleton fournit un objet de connexion JDBC
 *
 * @author nbourgeois
 * @version 2 22 novembre 2013
 */
public class Jdbc {

    // Jdbc instance
    private static Jdbc singleton = null;
    // Connexion setting
    private String piloteJdbc = "";
    private String protocoleJdbc = "";
    private String serveurBd = "";
    private String dbName = "";
    private String loginSgbd = "";
    private String pswSgbd = "";
    // Connexion
    private Connection connexion = null; // java.sql.Connection

    private Jdbc() {
    }

    /**
     * @param pilote : Class' pilote Jdbc
     * @param protocole : Server's URL | Depends on the SGBD's type
     * @param serveur : Serveur adress + port
     * @param base : Database's name
     * @param login : Login with authorized access
     * @param mdp : Password
     */
    private Jdbc(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        this.piloteJdbc = pilote;
        this.protocoleJdbc = protocole;
        this.serveurBd = serveur;
        this.dbName = base;
        this.loginSgbd = login;
        this.pswSgbd = mdp;
    }

    public static Jdbc creer(String pilote, String protocole, String serveur, String base, String login, String mdp) {
        if (singleton == null) {
            singleton = new Jdbc(pilote, protocole, serveur, base, login, mdp);
        }
        return singleton;
    }

    public static Jdbc getInstance() {
        return singleton;
    }

    public void connected() throws ClassNotFoundException, SQLException {
        Class.forName(this.getPiloteJdbc());
        setConnexion(DriverManager.getConnection(this.getProtocoleJdbc() + this.getServeurBd() + this.getDbName(), this.getLoginSgbd(), this.getPswSgbd()));
        getConnexion().setAutoCommit(true);
    }

    public void disconnected() throws SQLException {
        getConnexion().close();
    }

    public static java.sql.Date utilDateToSqlDate(java.util.Date uneDate) {
        return (new java.sql.Date(uneDate.getTime()));
    }

    /**
     *
     * @return the pilote used by Jdbc
     */
    public String getPiloteJdbc() {
        return piloteJdbc;
    }

    public void setPiloteJdbc(String piloteJdbc) {
        this.piloteJdbc = piloteJdbc;
    }

    /**
     * @return the protocoleJdbc
     */
    public String getProtocoleJdbc() {
        return protocoleJdbc;
    }

    /**
     * @param protocoleJdbc the protocoleJdbc to set
     */
    public void setProtocoleJdbc(String protocoleJdbc) {
        this.protocoleJdbc = protocoleJdbc;
    }

    public String getServeurBd() {
        return serveurBd;
    }

    public void setServeurBd(String serveurBd) {
        this.serveurBd = serveurBd;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getLoginSgbd() {
        return loginSgbd;
    }

    public void setLoginSgbd(String loginSgbd) {
        this.loginSgbd = loginSgbd;
    }

    public String getPswSgbd() {
        return pswSgbd;
    }

    public void setPswSgbd(String pswSgbd) {
        this.pswSgbd = pswSgbd;
    }

    public Connection getConnexion() {
        return connexion;
    }

    public void setConnexion(Connection connexion) {
        this.connexion = connexion;
    }
}