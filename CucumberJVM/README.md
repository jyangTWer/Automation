## 安装环境
1. **安装包管理工具** - ant vs maven vs gradle - 自动构建（build）工具，这里使用gradle(6.4), java 1.8.0_112 ```brew install gradle```

2. 执行 ```gradle init``` - 初始化项目
3. 修改build.gradle 文件[参考](https://cucumber.io/docs/installation/java/)
4. ```./gradlew build``` 构建项目
5. ```gradle cucumber```
6. 另外有朋友有个由[maven写的例子](https://jmyblog.top/WebUI-AutoTest-Demo-1/),非常详细

## 对比
安装jar包时，mvn放在pop.xml文件里，gradle放在build.gradle的dependencies里

## 定制命令，类似nodeJS里的script的作用
在build.gradle里添加task，可以使用```./gradlew tasks``` 在命令行里查看，其中Custom tasks为自定义task。