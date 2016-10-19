Abstract Classes & methods. 
Inheritance & Diamond problem.
Interfaces. 
Marker Interfaces. 
Cloneable interface. 
Default methods (Java 8). 
Static methods in Interfaces. (Best practices) 

Exceptions & Exception handling. 
Checked & unchecked exceptions. 
Finally block. 
Try-with-resources statement. 
Suppressed exceptions. 
Assertion. 
Exceptions Best Practices. 


абстрактные классы
===
http://ru.stackoverflow.com/questions/43777/%D0%97%D0%B0%D1%87%D0%B5%D0%BC-%D0%B0%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%82%D0%BD%D1%8B%D0%B9-%D0%BA%D0%BB%D0%B0%D1%81%D1%81-%D0%B2-java

Суть вот в чем. Когда вы отмечаете класс как abstract , вы тем самым запрещаете создавать его экземпляры. Поскольку в классе Operation не определен метод calculate, вы не должны иметь возможность создавать его экземпляры:

Вообще, абстрактные классы широко применяются, когда нужно реализовать некоторую общую функциональность для семейства классов.




Интерфейсы
===
http://kostin.ws/java/java-abstract-and-interfaces.html

Интерфейс это консутрукция языка программирования Java, в рамках которой могут описываться только абстрактные публичные (abstract public) методы и статические константyst свойства (final static). То есть также, как и на основе абстрактных классов, на основе интерфейсов нельзя порождать объекты.

http://developer.alexanderklimov.ru/android/java/interface.php
Ключевое слово interface используется для создания полностью абстрактных классов. Создатель интерфейса определяет имена методов, списки аргументов и типы возвращаемых значений, но не тела методов.
Наличие слова interface означает, что именно так должны выглядеть все классы, которые реализуют данный интерфейс. Таким образом, любой код, использующий конкретный интерфейс, знает только то, какие методы вызываются для этого интерфейса, но не более того.

Константы в интерфейсах
---
модификаторы public static final
данный подход не рекомендуют использовать.

Расширение интерфейсов
---
Интерфейс может наследоваться от другого интерфейса через ключевое слово extends.


Методы обратного вызова
---
Интерфейсы часто используются для создания методов обратного вызова (callback). 



Exception 
===
https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html
Definition: An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.


Assertions
===
https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html
Enabling and Disabling Assertions
By default, assertions are disabled at runtime. Two command-line switches allow you to selectively enable or disable assertions.

enable assertions -enableassertions, or -ea
disable assertions -disableassertions, or -da
granularity:
	no arguments		- Enables or disables assertions in all classes except system classes.
	packageName... 		- Enables or disables assertions in the named package and any subpackages.
	...					- Enables or disables assertions in the unnamed package in the current working directory.
	className			- Enables or disables assertions in the named class
	
		For example, the following command runs a program, BatTutor, with assertions enabled in only package com.wombat.fruitbat and its subpackages:
		 java -ea:com.wombat.fruitbat... BatTutor
		enabled in package com.wombat.fruitbat but disabled in class com.wombat.fruitbat.Brickbat:
		 java -ea:com.wombat.fruitbat... -da:com.wombat.fruitbat.Brickbat BatTutor 

enable assertions in all system classes, use a different switch: -enablesystemassertions, or -esa. 
disable assertions in system classes, use -disablesystemassertions, or -dsa.

For example, the following command runs the BatTutor program with assertions enabled in system classes, as well as in the com.wombat.fruitbat package and its subpackages:
 java -esa -ea:com.wombat.fruitbat... 
