import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CAMARGO
 */
public class adicionarfunc {
    
 public static String adicionarfunc(String[] funcionario){
        String sql = "insert into Funcionarios (CPF, Nome, Sexo, Idade, Endereco, Email, Telefone, Cargo) values(?,?,?,?,?,?,?,?)";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Restaurante";
            String username = "root";
            String password = "";
            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement st = con.createStatement();
                        
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario[0] /*cpf*/);
            stmt.setString(2, funcionario[1] /*nome*/);
            stmt.setString(3, funcionario[2] /*sexo*/);
            stmt.setString(4, funcionario[3] /*idade*/);
            stmt.setString(5, funcionario[4] /*endereco*/);
            stmt.setString(6, funcionario[5] /*email*/);
            stmt.setString(7, funcionario[6] /*tel*/);
            stmt.setString(8, funcionario[7] /*cargo*/);
    
            stmt.execute();
            
            con.close();
            return "Funcionário cadastrado com Sucesso!";
         
        }
        catch(Exception e) {
            System.out.println(e);
            return "Erro ao cadastrar";
        }
    }
}
