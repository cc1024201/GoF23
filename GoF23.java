//设计模式是一种解决软件设计中常见问题的经验总结，它提供了一套通用的解决方案，可以帮助开发人员更加高效地开发出高质量的软件。设计模式分为三类：创建型模式、结构型模式和行为型模式。每一种模式都有其特定的应用场景和解决问题的方法。
//创建型模式：
//创建型模式是一类设计模式，它们提供了一种在创建对象时更加灵活、更加可控的方式。这些模式可以帮助我们将对象的创建过程与使用过程分离开来，从而提高代码的可维护性和可扩展性。创建型模式包括工厂方法模式、抽象工厂模式、单例模式、建造者模式和原型模式。
//创建型模式的应用场景和解决问题的方法：
//1. 工厂方法模式（Factory Method）：当需要创建对象时，不希望直接使用new关键字来创建对象，而是希望通过一个工厂类来创建对象时，可以使用工厂方法模式。工厂方法模式可以将对象的创建过程封装在一个工厂类中，从而使得客户端无需关心对象的创建过程，只需要向工厂类请求所需的对象即可。
//2. 抽象工厂模式（Abstract Factory）：当需要创建一组相关或相互依赖的对象时，可以使用抽象工厂模式。抽象工厂模式可以将对象的创建过程封装在一个工厂类中，从而使得客户端无需关心对象的创建过程，只需要向工厂类请求所需的对象即可。
//3. 单例模式（Singleton）：当需要确保一个类只有一个实例时，可以使用单例模式。单例模式可以保证一个类只有一个实例，并提供一个全局访问点，使得客户端可以方便地访问该实例。
//4. 建造者模式（Builder）：当需要创建一个复杂的对象时，可以使用建造者模式。建造者模式可以将对象的创建过程分解为多个步骤，使得创建过程更加灵活。客户端可以通过指定不同的建造者来创建不同的对象。
//5. 原型模式（Prototype）：当需要创建一个与现有对象类似的对象时，可以使用原型模式。原型模式通过复制现有对象来创建新的对象，从而避免了对象的创建过程，提高了对象的创建效率。

//结构型模式：
//结构型模式是一类设计模式，它们关注如何组合类和对象以形成更大的结构。这些模式可以帮助我们将系统中的类和对象组织成更加清晰、更加灵活的结构，从而提高代码的可维护性和可扩展性。结构型模式包括适配器模式、桥接模式、组合模式、装饰模式、外观模式、享元模式和代理模式。
//结构型模式的应用场景和解决问题的方法：



//行为型模式：
//1. 职责链模式（Chain of Responsibility）：当需要为一个请求创建一个对象链时，可以使用职责链模式。

//2. 命令模式（Command）：当需要将请求发送者和接收者解耦时，可以使用命令模式。

//3. 解释器模式（Interpreter）：当需要解释一些特定的语法时，可以使用解释器模式。

//4. 迭代器模式（Iterator）：当需要访问一个聚合对象的内容而无需暴露它的内部表示时，可以使用迭代器模式。

//5. 中介者模式（Mediator）：当需要将多个对象之间的交互进行抽象化时，可以使用中介者模式。

//6. 备忘录模式（Memento）：当需要保存一个对象在某一个时刻的状态以便在以后恢复到该状态时，可以使用备忘录模式。

//7. 观察者模式（Observer）：当需要将一个对象的改变通知给其他对象时，可以使用观察者模式。

//8. 状态模式（State）：当需要根据对象的状态来改变对象的行为时，可以使用状态模式。

//9. 策略模式（Strategy）：当需要在多个算法中选择一个合适的算法时，可以使用策略模式。

//10. 模板方法模式（Template Method）：当需要在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中时，可以使用模板方法模式。

//11. 访问者模式（Visitor）：当需要对一个对象结构中的元素进行操作，并且这些元素具有不同的类型时，可以使用访问者模式。
