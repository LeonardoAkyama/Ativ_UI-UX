package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {
    
    //Metodo para realizar a conexão com o banco de dados
    public Connection conectarBD(){
        //variável de conexão declarada como nula
        Connection conn = null;
        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            //URL armazenando o usuario e a senha para o login
            String url ="jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            //Faz a conexão entre o banco de dados e o sistema
            conn = DriverManager.getConnection(url);
        }catch(Exception e) { }
        //retorna a conexão que foi estabelecida
        return conn;}
    //armazena o nome que foi buscado na consulta
    public String nome="";
    //Faz a verificação se o usuário foi encontrado ou não
    public boolean result = false;
    public boolean verficarUsuario(String login, String senha){
        String sql = "";
        //Chama o método de conexão 
        Connection conn = conectarBD();
        //INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += "and senha = " + "'" + senha + "';";
        try{
            Statement st = conn.createStatement(); 
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                //define se o login é válido
                result = true;
                nome = rs.getString("nome");}
        }catch (Exception e) { }
        //retorna true ou false.
        return result;}
    }

