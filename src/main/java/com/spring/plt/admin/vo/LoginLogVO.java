package com.spring.plt.admin.vo;

import org.springframework.stereotype.Component;

@Component("loginLogVO")
public class LoginLogVO {
   private int no;
   private String id;
   private String logtime;
   
   public int getNo() {
      return no;
   }
   public void setNo(int no) {
      this.no = no;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getLogtime() {
      return logtime;
   }
   public void setLogtime(String logtime) {
      this.logtime = logtime;
   }
}