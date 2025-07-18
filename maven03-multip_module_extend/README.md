### 创建多模块pom继承关系项目的步骤：
1. 使用IDEA创建一个非empty project的 new project
   > ![step1](C:\Users\admin\Desktop\project-J\maven03-multip_module_extend\imgs\step1.png)
2. 删除src目录
   > ![step2](C:\Users\admin\Desktop\project-J\maven03-multip_module_extend\imgs\step2.png)
3. 在项目根目录右键单击 -> 新增模块
   > ![step3](C:\Users\admin\Desktop\project-J\maven03-multip_module_extend\imgs\step3.png)
4. 新增子模块
   > ![step4](C:\Users\admin\Desktop\project-J\maven03-multip_module_extend\imgs\step4.png)
5. 根目录（父模块）下的pom.xml会声明modules，包含所有的子模块
6. 子目录（子模块）下的pom.xml会声明parent，标记父模块的坐标
7. 用于解决依赖包在多个模块需要用到，但需要多个模块都在pom.xml中声明的问题。如单元测试junit在dao/pom.xml中声明了
，在service/test下却无法使用的问题。
8. web模块下放servlet，在web/pom.xml中配置<packaging>war</packaging>；
9. web右键选择open module setting(F4), 新增webapp模块和WEB-INF/web.xml文件
   > ![step5](C:\Users\admin\Desktop\project-J\maven03-multip_module_extend\imgs\step5.png)
10. 配置tomcat服务
   > ![step6](C:\Users\admin\Desktop\project-J\maven03-multip_module_extend\imgs\step6.png)
11. 往后正常编写代码即可。