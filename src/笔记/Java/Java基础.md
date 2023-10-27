## 反射
反射是指在运行时动态地获取类的信息并操作类或对象的能力。通过反射，可以在运行时获取类的构造方法、
字段、方法等信息，并且可以在运行时动态地创建对象、调用方法、获取和设置字段的值。

反射在Java中有很多应用场景，包括但不限于以下几个方面：
* 类加载和动态代理：通过反射可以在运行时动态地加载类并创建对象，从而实现动态代理和扩展性较强的框架。
* 编写通用代码：通过反射可以在运行时获取类的信息，从而编写通用的代码，例如根据类的信息创建对象、调用方法等。
* 调试和测试：通过反射可以在运行时获取类的字段和方法，并对其进行调用和修改，方便进行调试和测试。
* 注解处理：通过反射可以在运行时获取类、方法、字段上的注解信息，并根据注解信息实现相应的逻辑。

Java是解释与编译共存的语言， 为什么这么说？
编译是将源代码（通常以高级语言写成）转换成机器码的过程。这个过程是在程序运行之前进行的。
编译器会检查所有的源代码，如果代码中没有错误，它将生成一个可执行文件。
解释器在运行程序时，会逐行读取源代码，然后执行相应的操作。这意味着源代码在每次运行时都需要通过解释器，
这可能会比直接运行机器码慢一些。
Java字节码在转化为机器码时会通过解释器或JIT编译器

为什么说 Java 语言“编译与解释并存”？
------
这是因为 Java 语言既具有编译型语言的特征，也具有解释型语言的特征。因为 Java 程序要经过先编译，后解释两个步骤，
由 Java 编写的程序需要先经过编译步骤，生成字节码（.class 文件），这种字节码必须由 Java 解释器来解释执行。


基本数据类型的局部变量存放在 Java 虚拟机栈中的局部变量表中，基本数据类型的成员变量
（未被 static 修饰 ）存放在 Java 虚拟机的堆中。包装类型属于对象类型，我们知道几乎所有对象实例都存在于堆中。

## 错误和异常
Error：
Error类及其子类表示Java运行时系统的内部错误和资源耗尽错误。这些错误无法预测，也无法避免，例如OutOfMemoryError
或StackOverflowError等。在一般情况下，程序不应该捕获这些错误。大多数情况下，一旦发生这些错误，JVM将无法恢复，并且应用程序将终止。

Exception：
Exception类及其子类表示程序可以处理的异常，它们可以被程序员捕获并适当处理。Exception又分为两类：
检查型异常（Checked Exceptions）和运行时异常（Runtime Exceptions）。
1. 检查型异常：这些异常在编译时需要处理（例如，IOExceptions，ClassNotFoundExceptions）。
编译器要求程序必须在编译期间捕获或声明这些异常。
2. 运行时异常：这些异常在运行时发生，常常是由于编程错误导致的，例如，NullPointerExceptions，
ArrayIndexOutOfBoundsExceptions。这些异常是非检查型异常，编译器不会强制要求你处理它们。

## 什么是泛型
Java泛型（Generics）是JDK 5中引入的一个新特性，泛型的本质是**参数化类型**，也就是说所操作的数据类型被指定为一个参数。
这种参数类型可以用在类、接口和方法的创建中，分别被称为泛型类、泛型接口和泛型方法。

使用泛型的主要好处有：
类型安全：泛型的主要目标是提高Java的类型安全。通过知道在编译时使用的具体类型，你可以在编译时捕获许多类型错误。
消除类型转换：泛型提供了一个更好的解决方案，让你在编译时检查到类型问题，并且所有的强制类型转换都是自动和隐式的。
代码重用：你可以对不同的类型执行相同的操作。

## 反射及其作用
反射允许程序在运行时访问、检查和修改它自身的结构和行为。更具体的说，Java的反射功能可以让我们在运行时获得类的完整构造，
并且可以动态调用对象的任何方法和属性。

使用反射的主要好处包括：
1. 运行时类型识别：比如你有一个对象，你不知道它的类型（比如 Object 类型），但是你想调用它的某个方法，你可以使用反射来实现。
2. 动态加载和使用类：有时你可能想动态加载一个类并使用它，但是在编译时你并不知道要加载哪个类。反射可以在运行时加载和初始化一个类，
然后你可以使用它。
3. 在运行时检查类、接口、字段和方法：反射允许你在运行时查看任何对象的方法和字段，这对于开发和调试非常有用。
4. 实现通用的数组操作代码：反射有一个Array类，允许我们动态创建和操作数组，无论它们的类型和维数。
5. 利用Method对象：这是一个强大的能力，因为这意味着你可以写一些非常通用的代码来执行复杂的操作。

## 反射的应用
获取Class对象的几个方法
1.Class.forName(""全类名")  2. 类.class  3. 对象.getClass()
获取方法信息、调用方法  获取类成员变量  创建对象

应用
1. 通过配置信息调用类的方法
public void invokeClassMethod(String className,String methodName) throws ClassNotFoundException,
   NoSuchMethodException,
   InvocationTargetException,
   InstantiationException,
   IllegalAccessException {
   //获取类信息
   Class cls = Class.forName(className);
   //对象实例化
   Object obj = cls.getDeclaredConstructor().newInstance();
   //根据方法名获取并执行方法
   Method dinnerMethod = cls.getDeclaredMethod(methodName);
   dinnerMethod.invoke(obj);
   }
2. 结合注解实现特殊功能，比如？
   //要扫描的包
   String packageName = "com.zimug.java.reflection";
   Reflections f = new Reflections(packageName);
   // 获取扫描到的标记注解的集合
   Set<Class<?>> set = f.getTypesAnnotatedWith(TableName.class);
for (Class<?> c : set) {
   // 循环获取标记的注解
   TableName annotation = c.getAnnotation(TableName.class);
   // 打印注解中的内容
   System.out.println(c.getName() + "类，TableName注解value=" + annotation.value());
3. 按需加载jar包货class类
   //java的.class文件所在路径
   File file = new File("D:/com/zimug");
   URL url = file.toURI().toURL();
   //创建类加载器
   ClassLoader classLoader = new URLClassLoader(new URL[]{url});
   //加载指定类，package全路径
   Class<?> cls = classLoader.loadClass("com.zimug.java.reflection.Student");


