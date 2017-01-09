package testdbpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {

    private final static String sql = "SELECT * FROM re_music u WHERE u.id=7832";

    public void query(Connection conn) {
        try {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);
            result.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}