1. node环境，下载安装包安装，v12.16.2
2. 包管理器：npm，整个nodeJs平台的包管理器，用来管理不同工具的安装，卸载以及自动解决依赖包的冲突等等。6.14.4
3. 安装：```npm install cypress```
4. [第一个例子](https://www.valentinog.com/blog/cypress/)， 用```npx serve```启动一个登录首页。
5. 第二个例子，同样的登录首页，用Page Object的方式重写
6. 第三个例子，用Command方式重写。如果selector不会被反复重用，那直接写在函数方法里是ok的，去除重复的重构原则是，当出现第三次重用的时候，需要抽取方法。
