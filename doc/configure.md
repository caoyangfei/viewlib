# 配置utillib

##  使用nexus 配置

项目gradle
 
   maven {
         
         url("http://192.168.249.100:8081/repository/basic_beta/")           
   }
   
模块gradle

  utilVersion = "2.1.1.2019_beta_01"
  
  dep = [
  
           util: "com.flyang.common:util:$utilVersion",
           
           gson: "com.google.code.gson:gson:2.8.5",
           
   ]
   
##  使用GitHub jitpack 配置

 项目gradle
 
  maven {
  
           url 'https://jitpack.io'
           
  }
  
 模块gradle
  
  utilVersion = "1.1.1.2019_02"
  
  dep = [
  
          util: "com.github.caoyangfei:utillib:$utilVersion",
          
          gson: "com.google.code.gson:gson:2.8.5",
          
  ]
