## 安装环境
1. **安装包管理工具** - ant vs maven vs gradle - 自动构建（build）工具，这里使用gradle(6.4), java 1.8.0_112

```brew install gradle```

2. 执行 ```gradle init``` - 初始化项目
4. 修改build.gradle 文件 [参考](https://cucumber.io/docs/installation/java/)
6. ```./gradlew build``` 构建项目
7. ```gradle cucumber```

## 定制命令，类似nodeJS里的script的作用
在build.gradle里添加task，可以使用```./gradlew tasks``` 在命令行里查看，其中Custom tasks为自定义task。
