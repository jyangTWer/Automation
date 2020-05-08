* node环境，下载安装包安装，v12.16.2
* 包管理器：npm，整个nodeJs平台的包管理器，用来管理不同工具的安装，卸载以及自动解决依赖包的冲突等等。6.14.4
* 安装：```npm install cypress```
* 第一个例子，进入TW首页，搜索BDD关键字，查到相关文章。
* 第二个例子，同样的登录首页，用[Page Object](https://github.com/jyangTWer/WebAutomation/commit/fbf39d0b1fc4641981128fec238b34112113d9ae#diff-5c1295e2c38c78f5eb2dc81c83eb3c06)的方式改写
* 第三个例子，用[Command](https://github.com/jyangTWer/WebAutomation/commit/5549ebf9fdd295f96fa54346d5d69ba02e6c72e0#diff-5c1295e2c38c78f5eb2dc81c83eb3c06)方式改写。如果selector不会被反复重用，那直接写在函数方法里是ok的，去除重复的重构原则是，当出现第三次重用的时候，需要抽取方法。
* [重试机制](https://docs.cypress.io/guides/core-concepts/retry-ability.html), 行为和断言里已经内嵌了重试的机制。
行为和断言两种，跟在行为后的断言如果成功就立即结束，如果断言未成功，重试之前的行为（除了可能会潜在改变应用状态的行为，如click这种），直到断言成功或者之前的行为超时（超时的默认时间是4s，可设置）失败结束。
多个行为后紧跟一个断言时且断言失败时，只重复最后一个行为，参见文章中例子，解决方法：1）合并行为 2）每个行为后紧跟断言验证 3）若之前的行为是不可重试的，如then，可以使用.should(callback)的方式解决。
并行线程
* Tag用例管理
* CI/CD流水线
* 生成测试报告
