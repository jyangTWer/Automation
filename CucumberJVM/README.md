## 包管理器
1. ant vs maven vs gradle - 自动构建（build）工具，这里使用gradle
2. brew install gradle - 6.4, java 1.8.0_112
3. 安装后执行 ```gradle init```
4. 修改build.gradle 文件 [参考](https://cucumber.io/docs/installation/java/)
5. *注意：*如果想使用最新的lambda API的方式，需要使用java8的那种依赖，如果是使用注解的方式，需要引入java的那种，如果有包引入不成功时，可以重新编译一下项目
6. ```./gradlew build```
7. ```gradle cucumber```

## 定制命令，类似nodeJS里的script的作用
在build.gradle里添加task，可以使用```./gradlew tasks``` 在命令行里查看，其中Custom tasks为自定义task。

