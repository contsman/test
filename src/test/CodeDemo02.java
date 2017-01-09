package test;

public class CodeDemo02{

public CodeDemo02(){

System.out.println("========这是构造方法=========");

}
    static {
        System.out.println("===========这是静态块===========");
    }

//这是构造代码块，而且在new对象时，构造代码块优先构造方法执行

{

System.out.println("=========这是构造块!=========");

}

public static void main(String[] args){

new CodeDemo02();

new CodeDemo02();

}

}
