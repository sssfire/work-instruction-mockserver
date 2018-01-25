package com.workinstruction.mockserver;

import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataService {
    
    private HashMap<String, User> users = new HashMap<String, User>();
    private Work work = new Work();
    
    public DataService() {
        dataStore4User();
        dataStore4Workinstructions();
    }
    
    @RequestMapping(value="/validateuser", method = RequestMethod.POST)
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseMessage> validateUser(@RequestBody User responseUser) {
        
        ResponseMessage message=getResponseUser(responseUser.username,responseUser.password);
        return new ResponseEntity<ResponseMessage>(message, message.getStatus());
        
    }
    
    public ResponseMessage getResponseUser(String username, String password){
        User user = users.get(username);
        if(user!=null){
            if(encodePassword(user.getUsername(), user.getPassword()).equals(password)){
                ResponseMessage message = new ResponseMessage();
                message.setMessage("授权成功");
                message.setStatus(HttpStatus.OK);
                return message;
            }else{
                ResponseMessage message = new ResponseMessage();
                message.setMessage("用户密码错误");
                message.setStatus(HttpStatus.FORBIDDEN);
                return message;
            }
        }else{
            ResponseMessage message = new ResponseMessage();
            message.setMessage("用户不存在");
            message.setStatus(HttpStatus.NOT_FOUND);
            return message;
        }
    }
    
    @RequestMapping(value="/workinstructions", method = RequestMethod.GET)
    public ResponseEntity<Work> getWorkinstructions(){
    	return new ResponseEntity<Work>(work, HttpStatus.OK);
    }
    
    @RequestMapping(value="/workinstructions", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> dealWorkInstructionResult(@RequestBody WorkInstructionResult[] workInstructionResult){
    	for(int i=0;i<workInstructionResult.length;i++){
    		System.out.println("num:"+i);
    		System.out.println(workInstructionResult[i]);
    	}
    	
        ResponseMessage message = new ResponseMessage();
    	if(workInstructionResult.length > 0){
    		message.setMessage("工单结果提交成功");
    		message.setStatus(HttpStatus.OK);
        	return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
    	}else{
    		message.setMessage("工单结果提交失败");
    		message.setStatus(HttpStatus.NOT_ACCEPTABLE);
        	return new ResponseEntity<ResponseMessage>(message, HttpStatus.NOT_ACCEPTABLE);
    	}
    }
    
    public void dataStore4User(){
        
        User user;
        
        user = new User("admin", "88888888");
        users.put(user.getUsername(), user);
        
        user = new User("worker", "66666666");
        users.put(user.getUsername(), user);
        
        user = new User("worker1", "11111111");
        users.put(user.getUsername(), user);
        
        user = new User("worker2", "22222222");
        users.put(user.getUsername(), user);
        
    }
    
    public void dataStore4Workinstructions(){

    	work.setWorkid("AO8782C23203-001A");
    	work.setWorktype("安装");
    	
    	//workinstruction：安装左侧翼测试设备
    	WorkInstruction workInstruction = new WorkInstruction();
    	workInstruction.setId("P01");
    	workInstruction.setPid("");
    	workInstruction.setUid("P01-0001");
    	workInstruction.setType("process");
    	workInstruction.setLastmoddate("20180120");
    	workInstruction.setWorkdesc("安装左侧翼测试设备222");
    	workInstruction.addWorkAttribute("高度", "10m");
    	workInstruction.addWorkAttribute("宽度", "100m");
    	workInstruction.addWorkAttribute("设备", "起重机");
    	workInstruction.addWorkAttribute("负责人", "看着办");
    	workInstruction.addWorkAttribute("开工时间", "2018年1月1日");
    	workInstruction.addWorkAttribute("完工时间", "2018年12月31日");
    	//attachment
    	Attachment attachment = new Attachment();
    	attachment.setUid("A-01");
    	attachment.setName("Test.jpg");
    	attachment.setPath("/attachment/test.jpg");
    	attachment.setType("jpg");
    	workInstruction.addAttachment(attachment);
    	attachment = new Attachment();
    	attachment.setUid("A-02");
    	attachment.setName("xx.jt");
    	attachment.setPath("/attachment/xx.jt");
    	attachment.setType("DirectModel");
    	workInstruction.addAttachment(attachment);
    	//executor
    	workInstruction.addExecutor("张三");
    	workInstruction.addExecutor("李四");
    	workInstruction.addExecutor("王五");
    	workInstruction.addExecutor("麻六");
    	work.addWorkInstruction(workInstruction);
    	
    	//workinstruction：安装左侧翼测试设备=》器材准备
    	workInstruction = new WorkInstruction();
    	workInstruction.setId("P02");
    	workInstruction.setPid("P01");
    	workInstruction.setUid("P02-0001");
    	workInstruction.setType("operation");
    	workInstruction.setLastmoddate("20180120");
    	workInstruction.setWorkdesc("器材准备");
    	workInstruction.addWorkAttribute("attribute1", "value1");
    	workInstruction.addWorkAttribute("attribute2", "value2");
    	//attachment
    	attachment = new Attachment();
    	attachment.setUid("A-01");
    	attachment.setName("Test.jpg");
    	attachment.setPath("/attachment/test.jpg");
    	attachment.setType("jpg");
    	workInstruction.addAttachment(attachment);
    	attachment = new Attachment();
    	attachment.setUid("A-02");
    	attachment.setName("xx.jt");
    	attachment.setPath("/attachment/xx.jt");
    	attachment.setType("DirectModel");
    	workInstruction.addAttachment(attachment);
    	//executor
    	workInstruction.addExecutor("张三");
    	workInstruction.addExecutor("李四");
    	work.addWorkInstruction(workInstruction);
    	
    	//workinstruction：安装左侧翼测试设备=》定位机柜支架衡量
    	workInstruction = new WorkInstruction();
    	workInstruction.setId("P03");
    	workInstruction.setPid("P01");
    	workInstruction.setUid("P03-0001");
    	workInstruction.setType("operation");
    	workInstruction.setLastmoddate("20180120");
    	workInstruction.setWorkdesc("定位机柜支架衡量");
    	workInstruction.addWorkAttribute("attribute1", "value1");
    	workInstruction.addWorkAttribute("attribute2", "value2");
    	//attachment
    	attachment = new Attachment();
    	attachment.setUid("A-01");
    	attachment.setName("Test.jpg");
    	attachment.setPath("/attachment/test.jpg");
    	attachment.setType("jpg");
    	workInstruction.addAttachment(attachment);
    	attachment = new Attachment();
    	attachment.setUid("A-02");
    	attachment.setName("xx.jt");
    	attachment.setPath("/attachment/xx.jt");
    	attachment.setType("DirectModel");
    	workInstruction.addAttachment(attachment);
    	//executor
    	workInstruction.addExecutor("张三");
    	workInstruction.addExecutor("李四");
    	work.addWorkInstruction(workInstruction);
    	
    	//workinstruction：安装左侧翼测试设备=》机柜支架组件预安装
    	workInstruction = new WorkInstruction();
    	workInstruction.setId("P04");
    	workInstruction.setPid("P01");
    	workInstruction.setUid("P04-0001");
    	workInstruction.setType("operation");
    	workInstruction.setLastmoddate("20180120");
    	workInstruction.setWorkdesc("机柜支架组件预安装");
    	workInstruction.addWorkAttribute("attribute1", "value1");
    	workInstruction.addWorkAttribute("attribute2", "value2");
    	//attachment
    	attachment = new Attachment();
    	attachment.setUid("A-01");
    	attachment.setName("Test.jpg");
    	attachment.setPath("/attachment/test.jpg");
    	attachment.setType("jpg");
    	workInstruction.addAttachment(attachment);
    	attachment = new Attachment();
    	attachment.setUid("A-02");
    	attachment.setName("xx.jt");
    	attachment.setPath("/attachment/xx.jt");
    	attachment.setType("DirectModel");
    	workInstruction.addAttachment(attachment);
    	//executor
    	workInstruction.addExecutor("成吉思汗");
    	workInstruction.addExecutor("张三疯");
    	work.addWorkInstruction(workInstruction);
    	
    	//workinstruction：安装右侧翼测试设备
    	workInstruction = new WorkInstruction();
    	workInstruction.setId("P05");
    	workInstruction.setPid("");
    	workInstruction.setUid("P05-0001");
    	workInstruction.setType("process");
    	workInstruction.setLastmoddate("20180120");
    	workInstruction.setWorkdesc("安装右侧翼测试设备");
    	workInstruction.addWorkAttribute("attribute1", "value1");
    	workInstruction.addWorkAttribute("attribute2", "value2");
    	//attachment
    	attachment = new Attachment();
    	attachment.setUid("A-01");
    	attachment.setName("Test.jpg");
    	attachment.setPath("/attachment/test.jpg");
    	attachment.setType("jpg");
    	workInstruction.addAttachment(attachment);
    	attachment = new Attachment();
    	attachment.setUid("A-02");
    	attachment.setName("xx.jt");
    	attachment.setPath("/attachment/xx.jt");
    	attachment.setType("DirectModel");
    	workInstruction.addAttachment(attachment);
    	//executor
    	workInstruction.addExecutor("三月天");
    	workInstruction.addExecutor("TFBoy");
    	work.addWorkInstruction(workInstruction);
    	
    	//workinstruction：安装机头温度测试设备
    	workInstruction = new WorkInstruction();
    	workInstruction.setId("P06");
    	workInstruction.setPid("");
    	workInstruction.setUid("P06-0001");
    	workInstruction.setType("process");
    	workInstruction.setLastmoddate("20180120");
    	workInstruction.setWorkdesc("安装机头温度测试设备");
    	workInstruction.addWorkAttribute("attribute1", "value1");
    	workInstruction.addWorkAttribute("attribute2", "value2");
    	//attachment
    	attachment = new Attachment();
    	attachment.setUid("A-01");
    	attachment.setName("Test.jpg");
    	attachment.setPath("/attachment/test.jpg");
    	attachment.setType("jpg");
    	workInstruction.addAttachment(attachment);
    	attachment = new Attachment();
    	attachment.setUid("A-02");
    	attachment.setName("xx.jt");
    	attachment.setPath("/attachment/xx.jt");
    	attachment.setType("DirectModel");
    	workInstruction.addAttachment(attachment);
    	//executor
    	workInstruction.addExecutor("郭富城");
    	workInstruction.addExecutor("李哲");
    	work.addWorkInstruction(workInstruction);
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
