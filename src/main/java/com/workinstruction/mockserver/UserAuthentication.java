package com.workinstruction.mockserver;

import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthentication {
    
    private HashMap<String, ResponseUser> users = new HashMap<String, ResponseUser>();
    
    public UserAuthentication() {
        dataStore();
    }
    
    @RequestMapping(value="/user", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseUser> home(@RequestBody ResponseUser responseUser) {
        
        ResponseUser user=getResponseUser(responseUser.username,responseUser.password);
        return new ResponseEntity<ResponseUser>(user, user.getStatus());
        
    }
    
    public ResponseUser getResponseUser(String username, String password){
        ResponseUser user = users.get(username);
        if(user!=null){
            if(encodePassword(user.getUsername(), user.getPassword()).equals(password)){
            	user = new ResponseUser();
                user.setMessage("授权成功");
                user.setStatus(HttpStatus.OK);
                user.setUsername(username);
                user.setPassword("******");
                return user;
            }else{
                user = new ResponseUser();
                user.setMessage("用户密码错误");
                user.setStatus(HttpStatus.FORBIDDEN);
                user.setUsername(username);
                user.setPassword("******");
                return user;
            }
        }else{
            user = new ResponseUser();
            user.setUsername(username);
            user.setPassword("******");
            user.setMessage("用户不存在");
            user.setStatus(HttpStatus.NOT_FOUND);
            return user;
        }
    }
    
    public void dataStore(){
        
        ResponseUser user;
        
        user = new ResponseUser("admin", "88888888");
        users.put(user.getUsername(), user);
        
        user = new ResponseUser("worker", "66666666");
        users.put(user.getUsername(), user);
        
        user = new ResponseUser("worker1", "11111111");
        users.put(user.getUsername(), user);
        
        user = new ResponseUser("worker2", "22222222");
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
