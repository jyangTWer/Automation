## Karate简介
Karate是Twitter的一个大佬2017年2月份release的一个开源工具，结合了API自动化测试，Mock，性能测试，UI测试于一身的工具，
2019年4月被收录在[ThoughtWorks技术雷达](https://www.thoughtworks.com/radar/languages-and-frameworks/karate)的评估阶段，
2020年5月被收录在TW技术雷达的使用阶段，发展速度也是非常快的，在做API测试时，它的好处是虽然是用了cucumber这种*.feature的语法来写API测试，
但是完全不用自己写step，所有可以用到的step都已经被karate内嵌进去，以关键字的形式给大家使用了，基本你能想到的它都有了，不需要在工具上花费太多心思，开心。

## 安装 初探
[karate](https://github.com/intuit/karate), 所有内容都是来自这里，README是辅助你理解它的文档的。
用IntelliJ IDEA以karate-archetype为原型进行安装，两种方式:

* 方式一，命令行，会在你运行这个命令的目录生成一个myproject的文件夹，里边有pop.xml文件和src文件夹
```$xslt
mvn archetype:generate \
-DarchetypeGroupId=com.intuit.karate \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=0.9.5 \
-DgroupId=com.mycompany \
-DartifactId=myproject
```
* 方法二：看这个[视频](https://www.youtube.com/watch?v=W-af7Cd8cMc&feature=youtu.be) 会更直观。

安装后可以直接在pop.xml所在的文件内运行 mvn test，就可以看到有测试在运行以及最后生成html report。运行时可能会失败，因为这里的按照id取Pet的请求时间有点长，大概29s多。

## 规范
在建好之后你会发现部分文件结构入有users目录，有users.feature和UsersRunner.java两个文件，与users并列还有一个ExamplesTest.java文件，
这里强调以每个API来分类组织，它的CRUD，准备数据，运行都在一个目录下
![Hierarchy][logo]
比如Cats有关的所有请求方法都放在一起，包括数据准备的json文件，CatsRunner是指明了要运行哪个feature文件，通常用mvn test跑测试时，会运行*Test.java的测试，这里故意没有遵循这个规则就是不想用它来运行，而是用整个结构最顶层的AnimalsTest来运行所有子目录下的*.feature文件呢，这个*Runner.java可以用来做开发阶段调试。

## report
在运行完测试后，报告会在target/surefire-reports目录下有个html文件，也有xml的，一般CI上集成的时候有的解析xml有的可以直接显示html，按需选择。

[logo]: /Users/jyang/Projects/Automation/karate/Pets/1592449744888.jpg "hierarchy"
