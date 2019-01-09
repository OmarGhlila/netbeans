/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai.DAO;

import essai.Essai;
import essai.Exception.ExceptionError;
import essai.IDAO.UserIDAO;
import essai.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omar Ghlila
 */
public class UserDAO implements UserIDAO{
    
    private Connection connection;
   // Connection cnx;
    PreparedStatement pst;
    ResultSet rs;

   
    public UserDAO(Connection connection) {
        this.connection = connection ;
    }
    
    private final String insert = "insert into user (user_id,name,login,pwd,email,tel) values (?,?,?,?,?,?)";
    private final String update = "update from user set name=? , login=? , pwd=? , email=?, tel=? where user_id=?" ;
    private final String delete = "delete user where user_id=?";
    private final String selectAll = "select * from user";

    @Override
    public void insertUser(User user) throws ExceptionError {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPwd());
            statement.setString(5, user.getEmail());
            statement.setDouble(6, user.getTel());
            statement.executeUpdate();
            
            
        
            
        }catch(SQLException ex){
            throw new ExceptionError(ex.getMessage());        
    
    }finally{
            if(statement!=null){
                try{
                statement.close();
            }catch(SQLException ex){
        }
    }
        }
    }

    @Override
    public void updateUser(User user) throws ExceptionError {
            PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            
            statement.setInt(6, user.getId());
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPwd());
            statement.setString(4, user.getEmail());
            statement.setDouble(5, user.getTel());
            statement.executeUpdate();
            
            
        
            
        }catch(SQLException ex){
            throw new ExceptionError(ex.getMessage());        
    
    }finally{
            if(statement!=null){
                try{
                statement.close();
            }catch(SQLException ex){
        }
    }
        }
    }

    @Override
    public void deleteUser(int id) throws ExceptionError {
            PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id );
            
            statement.executeUpdate();
            
            
        
            
        }catch(SQLException ex){
            throw new ExceptionError(ex.getMessage());        
    
    }finally{
            if(statement!=null){
                try{
                statement.close();
            }catch(SQLException ex){
        }
    }
        }
    }

    @Override
    public List<User> getByAll() throws ExceptionError {
        List<User> list = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null ;
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(selectAll);
            
            while(result.next()){
                User user = new User();
                user.setId(result.getInt("user_id"));
                user.setName(result.getString("name"));
                user.setLogin(result.getString("login"));
                user.setPwd(result.getString("pwd"));
                user.setEmail(result.getString("email"));
                user.setTel(result.getDouble("tel"));
                
                list.add(user);
            }
            return list;
        }catch(SQLException ex){
            throw new ExceptionError(ex.getMessage());
            
        }finally{
            if(statement!=null){
                try{
                    statement.close();
                }catch(Exception ex){
                    
                }
            }
            if(result !=null){
                try{
                    result.close();
                }catch(Exception ex){
                    
                }
            }
        }
        

    }

    @Override
    public User connection(String login, String pwd) throws ExceptionError {
        User user=null;
        connection= Essai.connecterDB();
        try {
            
            pst = connection.prepareStatement("select * from user where login = ? and pwd =md5(?) ");
       
                
                pst.setString(1, login);
                pst.setString(2, pwd);
                
                rs= pst.executeQuery();
                
                if(rs.next()){
                    String id= rs.getString("id");
                    String type= rs.getString("type");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                   String log = rs.getString("login");
                    String tel = rs.getString("tel");
                  user= new User(Integer.parseInt(id), name, log, email, Double.parseDouble(tel), type);
                 return user;
                }
        }catch(SQLException ex){
            throw new ExceptionError(ex.getMessage());
            
    
        }finally{
            if(rs!=null){
                try{
                rs.close();
            }catch(SQLException ex){
        }
    }
            
        }

    }
    
}
