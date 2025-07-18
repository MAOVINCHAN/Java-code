### 创建多模块项目步骤：
1. 使用IDEA创建一个empty project;
2. 在根目录Open module setting(F4);
   > ![Open module setting](C:\Users\admin\Desktop\project-J\maven02-multip_module\imgs\step1.png)
3. 在弹窗中选择：
   > ![choice](C:\Users\admin\Desktop\project-J\maven02-multip_module\imgs\step2.png)
4. 如果A模块依赖B模块，则在A模块中的pom.xml中配置dependencies,如service依赖dao:
    ``` xml
   <!-- service/pom.xml -->
   ...
     <dependencies>
         <dependency>
             <groupId>com.learn</groupId>
             <artifactId>dao</artifactId>
             <version>1.0-SNAPSHOT</version>
         </dependency>
     </dependencies>
   ...
    ```
5. 即可在service模块下，解析dao层的类或接口。
6. web模块用来放servlet，配置tomcat服务也是build此模块的代码。
   > ![server](C:\Users\admin\Desktop\project-J\maven02-multip_module\imgs\step3.png)
7. 往后正常编写代码即可。