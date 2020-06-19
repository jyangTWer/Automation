## gradle 初始化项目
```gradle init```, 选2.application, 3.java, 1.Groovy, 4.JUnit Jupiter, 项目名用当前目录名或重新起都可以。 

## 安装rest-assured
将rest-assured放在maven的pop.xml文件或者是gralde的build.gradle文件里，命令在[这里](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.3.0).
*注意* 
1.如果运行gradle test显示warning message
```deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.```，需要把gradle 安装时用的testCompile 改为testImplementation
2. 这两天不知道抽什么风，突然IDE里运行测试就No tests found了，还有Test events were not received, 找了2天，才发现[这个](https://www.timbotetsu.com/blog/intellij-idea-unit-test-test-events-were-not-received/)，
原来是2019.2.1版开始Intellij IDEA用gradle来跑测试，换成IDEA的Runner是工作的，但是疑问是，就想用Gradle来跑测试，该怎么处理呢? 还没找到解决办法。

## ApiTest.java里
所有的API请求都是来自Swagger Editor，有很多API，大家可以自由练习，另外还有一个更新在[这里](https://www.cnblogs.com/arhatJing/p/13156411.html).

