# KotlinJetPack

* [Kotlin Jetpack 实战｜开篇](https://juejin.im/post/6844904191089999886)
* [第一部分：快速入门 Kotlin](https://juejin.im/post/6844904191098355719)
* [Kotlin Jetpack 实战 | 01. 从一个膜拜大神的 Demo 开始](https://juejin.im/post/6844904191232573447)
* [Kotlin Jetpack 实战 | 02. Kotlin 写 Gradle 脚本是一种什么体验？](https://juejin.im/post/6844904192336003079)
1. grale kotlin dsl
2. 建立 buildSrc 用于存放依赖库

* [Kotlin Jetpack 实战 | 03. Kotlin 编程的三重境界](https://juejin.im/post/6844904201437331470)
1. 用注解的方式定义Contant输出java可以访问的类，同时定义一些常量
2. 用 by lazy 的方式延迟初始化，一般情况用这个安全
3. lambda 表达式
4. 使用kotlin扩展
5. 使用kotlin applay  also run  let 方法
6. 定义数据类

* [Kotlin Jetpack 实战 | 04. Kotlin 高阶函数](https://juejin.im/post/6854573222457769991)
1. SAM 转换(Single Abstract Method Conversions)
    > SAM(Single Abstract Method)，顾名思义，就是：只有一个抽象方法的类或者接口，
    但在 Kotlin 和 Java8 里，SAM 代表着：只有一个抽象方法的接口。符合 SAM 要求的接口，编译器就能进行 SAM 转换：
    让我们可以用 Lambda 表达式来简写接口类的参数。
2. 注：Java8 中的 SAM 有明确的名称叫做：函数式接口(FunctionalInterface)。FunctionalInterface 的限制如下，缺一不可：
    1. 必须是接口，抽象类不行
    2. 该接口有且仅有一个抽象的方法，抽象方法个数必须是1，默认实现的方法可以有多个。
3. View.setOnClickListner 转kotlin的分步骤
    ```
    //public void setOnClickListener(OnClickListener l)
    // 转 koltin
    // fun setOnClickListener(l: (View) -> Unit)
    // 实际上是这样：
    //fun setOnClickListener(l: ((View!) -> Unit)?)

    // 写法1 object 关键字定义了一个匿名内部类：
    username.setOnClickListener(object : View.OnClickListener {
        override fun onClick(v: View?) {
        }
    })

    // 写法2 上面的 View.OnClickListener 被称为： SAM Constructor—— SAM 构造器，
    // 它是编译器为我们生成的。Kotlin 允许我们通过这种方式来定义 Lambda 表达式
    username.setOnClickListener(View.OnClickListener { view: View? ->
        {}
    })

    // 写法3 由于 Kotlin 的 Lambda 表达式是不需要 SAM Constructor的，所以它也可以被删掉
    username.setOnClickListener({ view: View? ->        {}
    })
    // 写法4 由于 Kotlin 支持类型推导，所以 View? 可以被删掉：
    username.setOnClickListener({ view ->
        {}
    })

    // 写法5 当 Kotlin Lambda 表达式只有一个参数的时候，它可以被写成 it。
    username.setOnClickListener({ it ->
        {}
    })

    // 写法6 Kotlin Lambda 的 it 是可以被省略的：
    username.setOnClickListener({
    })

    // 写法7 当 Kotlin Lambda 作为函数的最后一个参数时，Lambda 可以被挪到外面：
    username.setOnClickListener() {
    }
    // 写法8 当 Kotlin 只有一个 Lambda 作为函数参数时，() 可以被省略：
    username.setOnClickListener {
    }
    ```
4. 带接收者(Receiver)的函数类型：A.(B，C) -> D
```
fun User.apply(block: User.() -> Unit): User{
//  不用再传this
//       ↓
    block()
    return this
}

```
