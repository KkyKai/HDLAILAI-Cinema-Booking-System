package com.csit314.backend.CustomerInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import com.csit314.backend.db.SQLConnection;
import com.csit314.backend.Hall.Hall;
import com.csit314.backend.Movie.Movie;
import com.csit314.backend.Seat.Seat;
import com.csit314.backend.UserAccount.UserAccount;

public class CustomerInfo {
    private Integer id = -1;
    private Date dob = null;
    private String address = "";
    private String gender = "";

    public CustomerInfo() {
        id = -1;
        dob = null;
        address = "";
        gender = "";
    }

    // To accept existing profile ids
    public CustomerInfo(Integer id) {
        this.id = id;
    }

    public CustomerInfo(Date dob, String address, String gender) {
        this.dob = dob;
        this.address = address;
        this.gender = gender;
    }

    public CustomerInfo(Integer id, Date dob, String address, String gender) {
        this.id = id;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String save(CustomerInfo user) throws SQLException {
        // Return failure early incase of incomplete fields
        if (user.dob.equals("") || user.address == "" || user.gender == "") {
            return "Failure";
        }
        Connection connection = null;
        try {
            SQLConnection sqlConnection = new SQLConnection();
            connection = sqlConnection.getConnection();
            String query = "INSERT INTO CustomerInfo (dob, address, gender) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(user.dob.getDate()));
            statement.setString(2, user.address);
            statement.setString(3, user.gender);
            statement.executeUpdate();
            return "Success";
        } catch (SQLException e) {
            System.out.println(e);
            return "Failure";
        } finally {
            // Close SQL connection when not in use
            if (connection != null) {
                connection.close();
            }
        }
    }

    public ArrayList<CustomerInfo> listAll() throws SQLException {
        Connection connection = null;
        try {
            SQLConnection sqlConnection = new SQLConnection();
            connection = sqlConnection.getConnection();
            String query = "SELECT * FROM CustomerInfo";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<CustomerInfo> results = new ArrayList<>();
            while (resultSet.next()) {
                // Get the data from the current row
                Integer id = resultSet.getInt("id");
                Date dob = resultSet.getDate("dob");
                String address = resultSet.getString("address");
                String gender = resultSet.getString("gender");
                // Convert the data into an object that can be sent back to boundary
                CustomerInfo result = new CustomerInfo(id, dob, address, gender);
                results.add(result);
            }
            return results;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public CustomerInfo get(Integer id) throws SQLException {
        Connection connection = null;
        try {
            SQLConnection sqlConnection = new SQLConnection();
            connection = sqlConnection.getConnection();
            String query = "SELECT * FROM CustomerInfo WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setMaxRows(1);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            Date dob = resultSet.getDate("dob");
            String address = resultSet.getString("address");
            String gender = resultSet.getString("gender");
            CustomerInfo result = new CustomerInfo(id, dob, address, gender);
            return result;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Boolean update(CustomerInfo customerInfo)
            throws SQLException {
        Connection connection = null;
        try {
            SQLConnection sqlConnection = new SQLConnection();
            connection = sqlConnection.getConnection();
            String query = "UPDATE CustomerInfo SET dob = ?, address = ?, gender = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(customerInfo.dob.getDate()));
            statement.setString(2, customerInfo.address);
            statement.setString(3, customerInfo.gender);
            statement.setInt(4, customerInfo.id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}