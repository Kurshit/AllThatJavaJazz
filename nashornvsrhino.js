/*importPackage(com.kurshit.ScriptEngine);

var o1 = new TestJS();
print(o1);
*/

//Nashorn does not support above syntax anymore use following to import package by default

var s = new JavaImporter(com.kurshit.ScriptEngine,java.lang); // allows many packages to import, separated by comma

s.String.v
var o1 = new s.TestJS();

o1.m1();

//to call a stayic method in Nashorn -- below will not work

//o1.myJavaMethod(); --> calling a static method using instance variable does not work in nashorn
// and used to work in rhino

s.TestJS.myJavaMethod();

com.kurshit.ScriptEngine.TestJS.myJavaMethod();






