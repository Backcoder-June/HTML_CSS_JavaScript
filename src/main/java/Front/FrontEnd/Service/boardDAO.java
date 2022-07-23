package Front.FrontEnd.Service;

import Front.FrontEnd.Entity.Board;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class boardDAO {


    public List<Board> selectAll() {

        List<Board> list = new ArrayList<>();

    Connection con = null;

    try {
        con = DriverManager.getConnection
                ("jdbc:mysql://127.0.0.1:3306/backcoder", "backcoder", "1111");

//SQL

        String sql = "select * from board";

        PreparedStatement pr = con.prepareStatement(sql);

        ResultSet resultSet = pr.executeQuery();

        while (resultSet.next()) {
            Board board = new Board(
                    resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4)
            );

            list.add(board);
        }


    }catch(
    SQLException e)

    {
        System.err.println("연결 오류" + e.getMessage());
        e.printStackTrace();
    }
finally

    {
        try {
            con.close();
        } catch (SQLException e) {
        }
    }

return list;

}









//
}






