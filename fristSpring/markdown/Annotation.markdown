#Spring常用注解
* 用于创建对象的  
他们的作用就和在XML配置文件中编写一个<bean>标签的实现的功能是一样的  
CommComponent：  
&emsp;&emsp;作用：用于把当前类对象注入Spring容器中  
&emsp;&emsp;属性：  
&emsp;&emsp;&emsp;&emsp;value：用于指定bean的id。当我们不写时，默认喂类名，且首字母为小写  
Controller：一般用于表现层  
Service：一般用于业务层  
Repository：一般用于持久层  
*以上三个注解的作用和属性与Component是一模一样的，使我们三层对象更加清晰*  

* 用于注入数据的  
他们的作用就和xml配置文件中的bean标签中的property作用是一样的
Autowired：  
&emsp;&emsp;作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和注入的变量类型匹配，就可以注入成功。    
&emsp;&emsp;出现的位置：可以是变量上，也可以是方法上  
&emsp;&emsp;细节：在使用注解注入时，set方法就不是必须的了  
Qualifier：  
&emsp;&emsp;作用：在按照类中注入的基础之上在按照名称注入。他在给类成员注入时不能单独使用。但是在给方法参数注入时可以。
