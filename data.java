import java.sql.*;
public class data
{
public static void main(String[] args)
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe","scott","tiger");
Statement stmt=con.createStatement();
ResultSet rs=stmt.excuteQuery("select * from emp");
while(rs.next())
{
System.out.println(rs.getInt(1));
System.out.println(rs.getString(2));
System.out.println(rs.getFloat(3));
System.out.println("=============");
}
con.close();
}
}

