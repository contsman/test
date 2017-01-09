package javadesign.classadapter;

public class Adapter extends Source implements Targetable {

//    @Override
//    public void method1() {
//        System.out.println("this is implement method..");
//    }

    @Override
    public void method2() {  
        System.out.println("this is the targetable method!");  
    }  
}  