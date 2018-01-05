package com.workinstruction.mockserver;

import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthentication {
    
    private HashMap<String, User> users = new HashMap<String, User>();
    
    public UserAuthentication() {
        dataStore();
    }
    
    @RequestMapping("/user")
    public ResponseEntity<User> home(@RequestParam String username, @RequestParam String password) {
        
        User user=getResponseUser(username,password);
       
        return new ResponseEntity<User>(user,user.getStatus());
    }
    
    public User getResponseUser(String username, String password){
        User user = users.get(username);
        if(user!=null){
            if(encodePassword(user.getUsername(), user.getPassword()).equals(password)){
                user.setMessage("授权成功");
                user.setStatus(HttpStatus.OK);
                return user;
            }else{
                user = new User();
                user.setMessage("用户密码错误");
                user.setStatus(HttpStatus.FORBIDDEN);
                return user;
            }
        }else{
            user = new User();
            user.setMessage("用户不存在");
            user.setStatus(HttpStatus.NOT_FOUND);
            return user;
        }
    }
    
    public void dataStore(){
        
        User user;
        
        user = new User("admin", "88888888");
        users.put(user.getUsername(), user);
        
        user = new User("worker", "66666666");
        users.put(user.getUsername(), user);
        
        user = new User("worker1", "11111111");
        users.put(user.getUsername(), user);
        
    }
    
    private String encodePassword(String username, String password){
        String encryPassword = username + password;
        return Base64.encodeBase64String(encryPassword.getBytes()); 
    }
    
    private String decodePassword(String username, String encryPassword){
        String encrypassword = new String(Base64.decodeBase64(encryPassword));
        return encrypassword.substring(username.length()); 
    }
    
}
