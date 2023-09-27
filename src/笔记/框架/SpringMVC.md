## 什么是SpringMVC
Spring MVC是一个基于Java的实现了MVC设计模式的请求驱动类型的轻量级Web框架，通过把模型-视图-控制器分离，
将web层进行职责解耦，把复杂的web应用分成逻辑清晰的几部分，简化开发，减少出错，方便组内开发人员之间的配合。

## SpringMVC的组件
（1）前端控制器 DispatcherServlet（不需要程序员开发）
作用：接收请求、响应结果，相当于转发器，有了DispatcherServlet 就减少了其它组件之间的耦合度。
（2）处理器映射器HandlerMapping（不需要程序员开发）
作用：根据请求的URL来查找Handler
（3）处理器适配器HandlerAdapter
注意：在编写Handler的时候要按照HandlerAdapter要求的规则去编写，这样适配器HandlerAdapter才可以正确的去执行Handler。
（4）处理器Handler（需要程序员开发）
（5）视图解析器 ViewResolver（不需要程序员开发）
作用：进行视图的解析，根据视图逻辑名解析成真正的视图（view）
（6）视图View（需要程序员开发jsp）
View是一个接口， 它的实现类支持不同的视图类型（jsp，freemarker，pdf等等）
————————————————

## 注解
元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种
分别表示作用范围、是否生成文档、目标、是否继承、是否重复