/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab4v1.entity;

import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hamza
 */
@Entity
@Table(name = "appuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "appuser.findAll", query = "SELECT a FROM appuser a"),
    @NamedQuery(name = "appuser.findByUserid", query = "SELECT a FROM appuser a WHERE a.userid = :userid"),
   
    
    @NamedQuery(name = "appuser.findByGroupname", query = "SELECT a FROM appuser a WHERE a.groupname = :groupname"),
    
    @NamedQuery(name = "appuser.findByPassword", query = "SELECT a FROM appuser a WHERE a.password = :password")})

@DatabaseIdentityStoreDefinition(
   dataSourceLookup = "${'java:comp/DefaultDataSource'}", 
   callerQuery = "#{'select password from app.appuser where userid = ?'}", //should be changed to: "#{'select password from AppUser where userid = ?'}"
   groupsQuery = "select groupname from app.appuser where userid = ?", //should be changed to: "select groupname from AppUser where userid = ?"
   hashAlgorithm = PasswordHash.class,
   priority = 10
)
public class appuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "USERID")
    protected String userid;
    @Size(max = 255)
    
    @Column(name = "PASSWORD")
    protected String password;
    @Size(max = 255)
    
    @Column (name = "GROUPNAME")
    protected String groupname;
    @Size(max = 255)
    
    public appuser(){
        
    }
    
    public appuser(String userid){
        this.userid = userid;
    }
    public String getUserid(){
        return userid;
    }
    
    public void setUserid(String userid){
        this.userid = userid;
    }
    
    public String getGroupname(){
        return groupname;
    }
    
    public void setGroupname(String groupname){
        this.groupname = groupname;
    }
    
    public String getPassword(){
        return "";
    }
    
    public void setPassword(String pass){
        if(pass.equals("") ){
            
            return;
        }
          // initialize a PasswordHash object which will generate password hashes
     Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
     PasswordHash passwordHash = instance.get();
     passwordHash.initialize(new HashMap<>());  // todo: are the defaults good enough?
     // now we can generate a password entry for a given password
     String passwordEntry = pass; //pretend the user has chosen a password mySecretPassword
     passwordEntry = passwordHash.generate(passwordEntry.toCharArray());
     //at this point, passwordEntry refers to a salted/hashed password entry corresponding to mySecretPassword
             this.password = passwordEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof appuser)) {
            return false;
        }
        appuser other = (appuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.lab4v1.appuser[ id=" + id + " ]";
    }
    
}
