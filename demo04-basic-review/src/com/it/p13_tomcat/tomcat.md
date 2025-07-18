### 常见服务器
- 免费
  - tomcat 开源，适合初学者
  - jetty 淘宝，效率比tomcat高
  - Undertow SpringBoot 异步io，效率高
  - resin 新浪，所有开源中，运行效率最高
- 收费
  - WebLogic(oracle)
  - WebSphere(IBM)

  
### 使用
> 依赖JDK，设备未下载JDK, tomcat服务无法启动
- 下载
  - 官网下载zip解压 tomcat.apache.org
- 启动应用
  - bin/startup.bat
- 关闭应用
  - bin/shutdown.bat
- 访问
  - 默认端口8080，浏览器访问localhost:8080
  

### 打包
> 使用maven运行命令 mvn clean package 打包为name.war
> 部署
>   1. 找到服务端tomcat文件夹的webapps文件夹
>   2. 将name.war复制到webapps文件夹中
>   3. 启动tomcat
>   4. 访问localhost:8080/name
