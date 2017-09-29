package ec.mil.ejercito.negocio.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @unidad SIPER
 * @author Cbop. Cacuango Luis
 */
public class FuncionesUtil {

    private javax.sql.DataSource getJdbcParte() throws NamingException {
        Context c = new InitialContext();
        return (javax.sql.DataSource) c.lookup("jdbc/Parte");
    }

    public String desencriptar(String dato) throws SQLException {
        java.sql.Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = ""
                + " select PACK_CODIFICA.decrypt('" + dato + "')"
                + " from DUAL";
        try {
            conn = getJdbcParte().getConnection();
            st = conn.prepareStatement(query);
            rs = st.executeQuery(query);
            String num = "";
            while (rs.next()) {
                num = rs.getString(1);
            }
            st.close();
            rs.close();
            return num;
        } catch (Exception e) {
            System.out.print("Error desencriptar " + e);
            return "";
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                    st = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String encriptar(String dato) {
        java.sql.Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String query = ""
                + " select PACK_CODIFICA.encrypt('" + dato + "')"
                + " from DUAL";
        try {
            conn = getJdbcParte().getConnection();
            st = conn.prepareStatement(query);
            rs = st.executeQuery(query);
            String num = "";
            while (rs.next()) {
                num = rs.getString(1);
            }
            st.close();
            rs.close();
            return num;
        } catch (Exception e) {
            System.out.print("Error encriptar " + e);
            return "";
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                    st = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
