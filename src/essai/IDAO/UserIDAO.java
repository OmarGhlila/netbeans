/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai.IDAO;

import java.util.List;
import essai.Model.User;
import essai.Exception.ExceptionError;
/**
 *
 * @author Omar Ghlila
 */
public interface UserIDAO {
    
    public void insertUser (User user) throws  ExceptionError;
    
    public void updateUser (User user) throws  ExceptionError;
    
    public void deleteUser (int id) throws  ExceptionError;
    
    public List<User> getByAll() throws ExceptionError;
    
    public User connection (String login,String pwd) throws  ExceptionError;
    
}
