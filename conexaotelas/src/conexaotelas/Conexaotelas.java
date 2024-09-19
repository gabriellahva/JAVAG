/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexaotelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author CAMARGO
 */
public class Conexaotelas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Restaurante";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement st = con.createStatement();
            
            ResultSet resultSet = st.executeQuery( "select * from Funcionarios");
            
            while(resultSet.next()){
                
                String id = resultSet.getString(1);
                String cpf = resultSet.getString(2);
                String nome = resultSet.getString(3);
                String sexo = resultSet.getString(4);
                String idade = resultSet.getString(5);
                String endereco = resultSet.getString(6);
                String email = resultSet.getString(7);
                String tel = resultSet.getString(8);
                
                System.out.println("ID: " + id + "\n" +
                        "CPF: " + cpf +
                        "\n" + "NOME: " + nome +
                        "\n" + "IDADE: " + idade +
                        "\n" + "SEXO: " + sexo +
                        "\n" + "ENDERECO: " + endereco +
                        "\n" + "EMAIL: " + email +
                        "\n" + "TELEFONE: " + tel);
            
            }
            con.close();
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }    
}