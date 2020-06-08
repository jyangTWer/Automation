## 安装rest-assured
将rest-assured放在maven的pop.xml文件或者是gralde的build.gradle文件里，命令在[这里](https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.3.0).

*注意* 如果运行gradle test显示warning message
```deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.```，需要把gradle 安装时用的testCompile 改为testImplementation

## ApiTest.java里
第14行，我把baseurl里的host地址改成一个假的了，这个实际使用中，替换成真实的API地址就好

