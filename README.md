1.
2.
3.
4. application.yml<br/>
``spring: 
    profiles:
        active: dev``<br>
> 通过mvn install生成jar或者war<br>
> java -jar target/SpringBoot-1.0-SNAPSHOT.war --spring.profiles.active=prod(此处为修改application.yml配置为prod模式发布)<br>
### 定义两个不同版本的yml配置
application-dev.yml<br>
application-prod.yml<br>
###获取配置文件中值得两种方法
```
// 找到配置文件中的指定对象节点并赋值给该对象
@ConfigurationProperties(prefix = "girl")
// 使之能被Autowire
@Component
public class girlProperties {
    private String cupSize;
    private Integer age;
    }
```
```
// 获取配置文件中的值
@Value("${age}")
private Long age;
```

###JPA(Java Persistence API)定义对象持久化的标准\
#### POM中加入
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
#### datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://localhost:3306/sakila
    username: root
    password: 950220
####  jpa:
    # create每次跑的时候会创建一个空的表,会删除之前的表
    # update回创建一个表,但是更新的时候不会删除之前的信息
    # create-drop结束时会删除对应表
    # validate验证跟数据库的字段是否一致
    # none 默认什么都不做
    # 自动与数据库表进行关联
    hibernate:
      ddl-auto: update
    show-sql: true

####查询
>#####通过RESTful类型定义
```
// 查询全部
GetMapping(value = "/girls")
{
    dtoRepository.findAll();
}

```
```
// 查询指定
@GetMapping(value= "/girls/{id}")
public girl girlFindOne(@PathVariable("id") Long id){
        return girlRepository.findOne(id);
    }
```
```
// 新增
@PostMapping(value = "/girls")
public girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Long age){
        girl girl = new girl().setAge(age).setCupSize(cupSize);
        return girlRepository.save(girl);
    }
```
```
// 更新
  @PutMapping(value= "/girls/{id}")
    public girl update(@PathVariable("id") Long id,
                       @RequestParam("cupSize") String cupSize,
                       @RequestParam("age") Long age
    ){
        girl girl = new girl().setId(id).setCupSize(cupSize).setAge(age);
        return girlRepository.save(girl);
    }
```
```
// 删除
  @DeleteMapping(value= "/girls/{id}")
    public void delete(@PathVariable("id") Long id){
        girlRepository.delete(id);
    }
```


####自定义查询
```
public interface dtoRepository extends JpaRepository<dto,Long>{
    // 对应的dto以及用到的参数
    public List<dto> findByAge(Long age);
    }
```
####事务
    只有查询的时候不用加事务
    在Service中方法上加@Transactional无论是否是多条sql语句
