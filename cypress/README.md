## 安装环境
* node环境，下载安装包安装，v12.16.2
* 包管理器：npm，整个nodeJs平台的包管理器，用来管理不同工具的安装，卸载以及自动解决依赖包的冲突等等。6.14.4
* 安装：```npm install cypress```

## 例子 - Simple，PageObject，Command，Application Action
* 第一个例子，进入TW首页，搜索BDD关键字，查到相关文章。
* 第二个例子，把第一个例子用PO的方式改写。
* 第三个例子，把第一个例子用Command方式改写。如果selector不会被反复重用，那直接写在函数方法里是ok的，去除重复的重构原则是，当出现第三次或更多重用的时候，进行抽取。
* 第四个例子，用APP Action的方式改写。App Action的方式前提是需要有获取前端代码的权限，在测试中直接引入前端方法，而不必通过页面去做数据准备。

**练习 -  Application Action [参考](https://github.com/cypress-io/cypress-example-todomvc/tree/8055be803f1a7c5dc380a8a19a7c79f7cc138c8e)**

  * git clone https://github.com/<your-username>/cypress-example-todomvc.git
  * cd cypress-example-todomvc
  * npm install
  * npm start
  * 新建文件utils.js，放在support目录下
    ```
    #cypress-example-todomvc/cypress/support/utils.js

    const TODO_ITEM_ONE = 'buy some cheese'
    const TODO_ITEM_TWO = 'feed the cat'
    const TODO_ITEM_THREE = 'book a doctors appointment'

    export const addDefaultTodos = () => {
      cy.visit('/')
      cy.window().its('model').invoke('addTodo', TODO_ITEM_ONE)
      cy.window().its('model').invoke('addTodo', TODO_ITEM_TWO)
      cy.window().its('model').invoke('addTodo', TODO_ITEM_THREE)
      cy.get('.todo-list li').as('todos')
    }
    ```
  * app.jsx中增加以下内容
    ```
    # cypress-example-todomvc/js/app.jsx

    if (window.Cypress) {
      window.model = model
    }
    ```
  * 为了验证这一个功能，可以把app_spec.js中的其他测试都注释掉，只留一个，留下的内容
    ```
    #cypress-example-todomvc/cypress/integration/app_spec.js

    import { addDefaultTodos } from '../support/utils.js'

    describe('TodoMVC - React', function () {
      beforeEach(addDefaultTodos)

      it('Already have 3 todo items', function () {
        cy.get('@todos').should('have.length', 3)
      })
    })
    ```
  * 运行以上的测试你会发现，大概39s的时间，但是如果把support/utils.js中的部分内容换成
  ```
  export const addDefaultTodos = () => {
    cy.visit('/')
    cy.get('.new-todo')
      .type(`${TODO_ITEM_ONE}{enter}`)
      .type(`${TODO_ITEM_TWO}{enter}`)
      .type(`${TODO_ITEM_THREE}{enter}`)
      .get('.todo-list li').as('todos')
  }
  ```
  时间就是1m39s，速度上还是有很大差异的。

* [重试机制](https://docs.cypress.io/guides/core-concepts/retry-ability.html), 行为和断言里已经内嵌了重试的机制。
行为和断言两种，跟在行为后的断言如果成功就立即结束，如果断言未成功，重试之前的行为（除了可能会潜在改变应用状态的行为，如click这种），直到断言成功或者之前的行为超时（超时的默认时间是4s，可设置）失败结束。
多个行为后紧跟一个断言时且断言失败时，只重复最后一个行为，参见文章中例子，解决方法：1）合并行为 2）每个行为后紧跟断言验证 3）若之前的行为是不可重试的，如then，可以使用.should(callback)的方式解决。
并行线程
* Tag用例管理
* CI/CD流水线
* 生成测试报告

## 生成测试报告
[参考](https://medium.com/egnyte-engineering/3-steps-to-awesome-test-reports-with-cypress-f4fe915bc246)

cypress是基于mocha的，所以mocha可以用的reporter，cypress都可以用，对于E2E来说，漂亮的report也是挺必要的，不过也得看CI对生成的report的解析，有的显示xml或json的报告也挺友好的。这里不说直接使用junit和mochawesome这两个简单report，而是按照文章中所说，将失败结果放到报告里，主要思路是：
1. 生成json的报告，每个spec文件是一份报告
2. 把生成的众多report合并成一个json的报告
3. 把这个合并的json的报告生成一个html的报告
4. 对于失败的用例，把产生的截图内嵌到报告中
