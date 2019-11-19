# spring对bean管理细节
1. 创建bean的三种方式
    1. 第一种方式：使用默认的构造函数创建。在spring的配置文件中使用bean标签，配以
    id和class属性之后，且没有其他属性和标签时。采用的就是默认构造函数创建bean对象
    ，此时如果类中没有默认的构造函数，则对象无法创建
    2. 第二种方式：使用普通工厂中的方法创建对象（使某个类的方法创建对象，并存入Spring）容器
    ```
   <bean id = "instanceFactory" class = "com.xupt.ff.InstanceFactory"></bean>
   <bean id = "accountService" factory-bean = "instanceFactory" factory-method = "getAccountService" ></bean>
   ```
   3. 第三种方式：使用工厂中的静态方法创建对象（使用某个类中的静态方法创建对象，并存入Spring容器）
   ```
   <bean id = "accountService" class = "com.xupt.ff.StaticFactory" factory-method = "getAccountService" >
   ```
2. bean对象的作用范围  
    bean标签的scope属性：  
    &emsp;&emsp;作用：用于指定bean的作用范围  
    &emsp;&emsp;取值：常用的就是单例和多例的  
    &emsp;&emsp;&emsp;&emsp;&emsp;singleton：单例的（默认值）  
    &emsp;&emsp;&emsp;&emsp;&emsp;prototype：多例的  
    &emsp;&emsp;&emsp;&emsp;&emsp;request：作用于web应用的请求范围  
    &emsp;&emsp;&emsp;&emsp;&emsp;session：作用于web应用的会话范围  
    &emsp;&emsp;&emsp;&emsp;&emsp;global-session：作用于集群环境的会话范围（全局会话范围），当不是集群环境时，他相当于session
3. bean对象的生命周期  
    1. 单例对象：  
    &emsp;&emsp;出生：当容器创建是出生  
    &emsp;&emsp;活着：只要容器还在，对象一直活着  
    &emsp;&emsp;死亡：容器销毁，对象死亡  
    &emsp;&emsp;&emsp;&emsp;**总结：单例对象的生命周期和容器相同**  
    2. 多例对象：  
    &emsp;&emsp;出生：当我们使用对象时Spring为我们创建  
    &emsp;&emsp;活着：对象只要是在使用过程中就一直活着  
    &emsp;&emsp;死亡：当对象长时间不使用，且没有别的对象引用时，由java的垃圾回收器回收  
### Spring的依赖注入
   &emsp;&emsp;依赖注入：Dependency Injection  
   &emsp;&emsp;IOC作用：降低程序间耦合（依赖关系）  
   &emsp;&emsp;依赖关系的管理：以后都交给Spring来维护。  
   &emsp;&emsp;在当前类需要用到其他的类对象，由spring为我们提供，我们只需要在配置文件中说明依赖的维护就称之为依赖注入 
   &emsp;&emsp;经常变化的数据，不适合注入  
   &emsp;&emsp;能注入的类型有三种：  
   > 1. 基本类型和String   
   > 2. 其他bean类型（配置文件中或注解中配置过的bean）  
   > 3. 复杂类型/集合类型  
   &emsp;&emsp;用于给List集合注入的标签：  
   &emsp;&emsp;&emsp;&emsp;list&emsp;set&emsp;array  
   &emsp;&emsp;用于给Map结构集合注入的标签：  
   &emsp;&emsp;&emsp;&emsp;map&emsp;props  
   **总结：结构相同，标签可以互换**
   > ```
   > <bean id = "accountService" class = "com.xupt.ff.service.impl.accountServiceImpl" >
   >    <property name = "myList">
   >        <list>
   >            <value>AAA</value>
   >            <value>BBB</value>
   >            <value>CCC</value>
   >        </list>
   >    <property
   > 
   >    <property name = "myMap">
   >        <map>
   >            <entry key = "testA" value = "AAA" ></entry>
   >            <entry key = "testB">
   >                <value>bbb</value>
   >            </entry>
   >        </map>
   > </bean>
   > ```
   &emsp;&emsp;注入方式有三种：  
   > * 使用构造函数提供  
   > &emsp;&emsp;使用的标签：constructor-age  
   > &emsp;&emsp;标签出现的位置：bean标签内部  
   > &emsp;&emsp;标签中的属性：  
   > &emsp;&emsp;&emsp;&emsp;type：用于指定要注入的数据的数据类型，该数据类型也是构造函数中某个或某些的类型  
   > &emsp;&emsp;&emsp;&emsp;index：用于指定要注入的数据给构造函数中指定索引位置的参数赋值。索引的位置是从0开始  
   > &emsp;&emsp;&emsp;&emsp;name：用于指定给构造函数中指定名称的参数赋值  
   > &emsp;&emsp;*以上三个用于指定给构造函数的哪个参数赋值*  
   > &emsp;&emsp;&emsp;&emsp;value：用于提供基本类型和String类型的数据  
   > &emsp;&emsp;&emsp;&emsp;ref：用于指定其他bean类型的数据。它指的就是在Spring的IOC核心容器中出现过的bean对象  
   > &emsp;&emsp;优势：*在获取bean对象时，注入数据是必须的操作，否则对象无法创建成功*  
   > &emsp;&emsp;弊端：*改变了bean对象的实例化方式，使我们在创建对象时，不用到这些数据，也必须提供* 
   >> ```
   >> <bean id = "accountService" class = "com.xupt.ff.service.impl.accountServiceImpl" >  
   >> <constructor-arg name = "name" value = "简十初"></constructor-arg>
   >> <constructor-arg name = "age" value = "18"></constructor-arg>
   >> <constructor-arg name = "birthday" value = "now"></constructor-arg>
   >> </bean>
   >> 
   >> <bean id = "now" class = "java.util.Date" >
   >> ```
   > * 使用set方法提供   
   > &emsp;&emsp;涉及的标签：property  
   > &emsp;&emsp;出现的位置：bean标签内部  
   > &emsp;&emsp;标签的属性：  
   > &emsp;&emsp;&emsp;&emsp;name：用于注入时所调用的set方法名称  
   > &emsp;&emsp;&emsp;&emsp;value：用于提供基本类型和String类型的数据  
   > &emsp;&emsp;&emsp;&emsp;ref：用于指定其他bean类型的数据。它指的就是在Spring的IOC核心容器中出现过的bean对象  
   > &emsp;&emsp;优势：*创建对象没有明确的限制，可以直接使用默认的构造函数*
   > &emsp;&emsp;弊端：*如果在创建对象时，有些数据必须有值，则获取对象set方法可能没有提供*
   >> ```
   >> <bean id = "accountService" class = "com.xupt.ff.service.impl.accountServiceImpl" >
   >> <prorerty name = "name" value = "简十遇"  ></property>
   >> <prorerty name = "age" value = "18"  ></property>
   >> <prorerty name = "birthday" value = "now"  ></property>
   >> </bean>
   >> 
   >> <bean id = "now" class = "java.util.Date"></bean>
   >> ```
   >> 
   > * 使用注解提供  
