<%@page import="java.sql.*"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@page import="org.json.simple.*"%>

<%
    String pr_id = request.getParameter("userID");
    String userID = null;
    Connection conn=null;

    PreparedStatement prepared_stat = null;
    ResultSet rs = null;

    String url = "jdbc:mysql://101.101.211.66:3306/db_2018021097";
    String user = "mobile23";
    String password = "!Mjc2023";

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);

        String query = "select userID from MEMBER where userID ='" + pr_id + "'";
        prepared_stat = conn.prepareStatement(query);

        rs = prepared_stat.executeQuery();

        while(rs.next())
        {
            userID = rs.getString("userID");
        }

        JSONObject json = new JSONObject();
        json.put("userID", userID);

        if(userID != null) json.put("newID", false);
        else json.put("newID", true);

        out.println(json.toString());
    }
    catch(SQLException ex)
    {
        out.println("SQLException:" + ex.getMessage());
    }
    finally
    {
        if (rs != null) rs.close();
        if (prepared_stat != null) prepared_stat.close();
        if (conn != null) conn.close();
    }
%>