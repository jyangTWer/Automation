## 安装
npm install -g appium <!-- 1.17.1 -->
Download jdk [here](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) for mac.
jdk安装好后，记得配置一个JAVA_HOME路径，把下面的内容配置到~/.bash_profile或者~/.bashrc里，再引用一下
```
export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-14.0.1.jdk/Contents/Home"
source ~/.bashrc  || source ~/.bash_profile
```
安装appium-doctor，检查针对ios或android是否所有需要的东西都安装完成了,我这里只把必须的安装了，可选项真正需要的时候再装喽。
```
npm install -g appium-doctor <!-- v.1.15.1 ->
appium-doctor --android || appium-doctor --ios
```

[android studio download](https://developer.android.com/studio/index.html)
