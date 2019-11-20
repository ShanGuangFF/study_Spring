### spring新注解  
* @Configuration  
&emsp;&emsp;作用：指定当前类是一个配置类  
&emsp;&emsp;细节：  
&emsp;&emsp;&emsp;&emsp;当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写
* @ComponentScan  
&emsp;&emsp;作用：用于通过注解指定spring在创建容器所扫描的包
&emsp;&emsp;属性：  
&emsp;&emsp;&emsp;&emsp;value：它和basePackage的作用是一样的，都是用于指定创建容器时要扫描的包  
* @Bean  
&emsp;&emsp;作用：用于把当前方法的返回值作为bean对象存入spring容器当中  
&emsp;&emsp;属性：  
&emsp;&emsp;&emsp;&emsp;name：用于指定bean的id。当不写时，默认值是当前方法的名称  
&emsp;&emsp;细节：  
&emsp;&emsp;&emsp;&emsp;当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象。查找的方式
和Autowired注解的作用是一样的  
* @Import  
&emsp;&emsp;作用：用于导入其他类  
&emsp;&emsp;属性：  
&emsp;&emsp;&emsp;&emsp;value：用于指定其他配置类的字节码。当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的是子
配置类  
* @PropertySource  
&emsp;&emsp;作用：指定properties文件位置  
&emsp;&emsp;属性：  
&emsp;&emsp;&emsp;&emsp;value：指定文件的名称和位置。**关键字**：classpath，表示类路径下
* Spring整合junit问题  
1. 导入spring整合junit的坐标  
2. 使用Junit提供的一个注解把原有的main方法替换了，替换成Spring提供的  
&emsp;&emsp;@RunWith
3. 告知spring容器，spring是基于xml还是注解建立的，并且说明位置  
&emsp;&emsp;@ContextConfiguration  
&emsp;&emsp;&emsp;&emsp;locations：指定xml文件的位置，加上classpath关键字，表示在类路径下  
&emsp;&emsp;&emsp;&emsp;classes：指定注解类所在的位置  
&emsp;&emsp;***当我们使用spring5.x版本的时候，要求junit的jar必须是4.12及以上***