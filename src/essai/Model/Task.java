/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai.Model;

import java.sql.Date;

/**
 *
 * @author Omar Ghlila
 */
public class Task {
    public int id;
    public String task_name;
    public String server_instance_name;
    public String dba_name;
    public String cube_name;
    public Date task_date;
    

    public Task(int id, String task_name, String server_instance_name, String dba_name, String cube_name, Date task_date) {
        this.id = id;
        this.task_name = task_name;
        this.server_instance_name = server_instance_name;
        this.dba_name = dba_name;
        this.cube_name = cube_name;
        this.task_date = task_date;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getServer_instance_name() {
        return server_instance_name;
    }

    public void setServer_instance_name(String server_instance_name) {
        this.server_instance_name = server_instance_name;
    }

    public String getDba_name() {
        return dba_name;
    }

    public void setDba_name(String dba_name) {
        this.dba_name = dba_name;
    }

    public String getCube_name() {
        return cube_name;
    }

    public void setCube_name(String cube_name) {
        this.cube_name = cube_name;
    }

    public Date getTask_date() {
        return task_date;
    }

    public void setTask_date(Date task_date) {
        this.task_date = task_date;
    }

   
    
    
}
