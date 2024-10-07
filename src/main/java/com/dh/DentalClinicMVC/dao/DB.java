package com.dh.DentalClinicMVC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    private static final String DRIVER ="org.h2.Driver";
    private static final String URL = "jdbc:h2:./dc";
    private static final String USER = "sa";
    private static final String PASSWORD = "password";
    private static final String SQL_DROP_CREATE_ADDRESSES = "DROP TABLE IF EXISTS ADDRESSES; CREATE TABLE ADDRESSES(ID INT AUTO_INCREMENT PRIMARY KEY,"+
            " STREET VARCHAR(100) NOT NULL,"+
            " NUMBER INT NOT NULL,"+
            " LOCATION VARCHAR(100) NOT NULL," +
            " PROVINCE VARCHAR(100) NOT NULL";
    private static final String SQL_DROP_CREATE_PATIENTS = "DROP TABLE IF EXISTS PATIENTS; CREATE TABLE PATIENTS(ID INT AUTO_INCREMENT PRIMARY KEY,"+
            " NAME VARCHAR(100) NOT NULL,"+
            " LAST_NAME VARCHAR(100) NOT NULL,"+
            " CARD_IDENTITY INT NOT NULL," +
            " ADMISSION_OF_DATE DATE NOT NULL,"+
            " ADDRESSES_ID VARCHAR(100) NOT NULL";
    private static final String SQL_DROP_CREATE_DENTIST = "DROP TABLE IF EXISTS DENTIST; CREATE TABLE DENTIST(ID INT AUTO_INCREMENT PRIMARY KEY,"+
            " REGISTRATION INT NOT NULL" +
            " NAME VARCHAR(100) NOT NULL,"+
            " LAST_NAME VARCHAR(100) NOT NULL";

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASSWORD);

    }
    public static void createTables(){
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_DROP_CREATE_ADDRESSES);
            statement.execute(SQL_DROP_CREATE_PATIENTS);
            statement.execute(SQL_DROP_CREATE_DENTIST);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();

            }catch (Exception e){
               e.printStackTrace();
            }
        }
    }

}
