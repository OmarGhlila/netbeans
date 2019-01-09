/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai.Model;

import java.util.Objects;

/**
 *
 * @author Omar Ghlila
 */


public class User {
    public int id;
    private String name ;
    public String login;
    private String pwd;
    private String email;
    private double tel;
    private String type;
    
    //public static int id_static;
    
    
    public User (){
        this.id = 0;
        this.name= "";
        this.login = "";
        this.pwd = "";
        this.email= "";
        this.tel= 0;
        this.type= "";
    }
    public User (int id, String name, String login, String pwd, String email, double tel, String type){
        this.id = id;
        this.name= name;
        this.login = login;
        this.pwd = pwd;
        this.email= email;
        this.tel= tel;
        this.type= type;
    }
    
    public User(int id, String name, String login, String email, double tel, String type) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.tel = tel;
        this.type = type;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.login);
        hash = 37 * hash + Objects.hashCode(this.pwd);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tel) ^ (Double.doubleToLongBits(this.tel) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (Double.doubleToLongBits(this.tel) != Double.doubleToLongBits(other.tel)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.pwd, other.pwd)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", login=" + login + ", pwd=" + pwd + ", email=" + email + ", tel=" + tel + ", type=" + type + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
    //public static int getId_static() {
      //  return id_static;
    //}

    //public static void setId_static(int id_static) {
      //  User.id_static = id_static;
    //}
    
    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }
    
    
}
