package fanxing;

public class GenericMethodClass<T> {
    
    /** 泛型类跟静态泛型方法的类型参数T重名，但作用域无交集，因此它们不冲突 */
    public static <T> void printClassByStaticMethod(T t) {
    
        System.out.println(t.getClass());
    }
    /**
     * 编译器警告：Type parameter 'T' hides type parameter 'T'，
     * 这是因为泛型类跟其实例泛型方法的类型参数T重名，作用域有交集，
     * 因此在该实例泛型方法体中，该实例泛型方法的类型参数T生效。
     */
    public <T> void printClassByInstanceMethod(T t) {
    
        System.out.println(t.getClass());
    }
    public T returnItself(T t) {
    
        return t;
    }
    public void emptyMethod() {
    }
    public static void main(String[] args) {
    
        GenericMethodClass<String> genericMethodClass = new GenericMethodClass<>();
        //编译提示：Explicit type arguments can be inferred，即我们显式指定的<Object>可以不用写
        //，因为编译器可通过上下文推断出这个泛型方法的实际类型参数
        GenericMethodClass.<Object>printClassByStaticMethod(new Object());
        //可以用对象来调用静态泛型方法，但是不推荐这么做，因为这种做法不符合泛型方法的设计初衷
        genericMethodClass.<Object>printClassByInstanceMethod(new String());
        //也可以在实例方法中显式指定实际类型参数，但是编译器会提示：Type arguments are redundant for the non-generic method call
        //，也就是说对于非泛型方法显式指定实际类型参数是无效的，因为非泛型方法的实际类型参数是在该对象初始化时就指定了，而不是像泛型方法需要
        // 显式指定或者系统通过上下文推断，即使像下面代码指定了Integer，但returnItself()方法的返回值还是String类型
        //，因为非泛型方法的实际类型参数在创建对象时就已经显式指定了
        String string = genericMethodClass.<Integer>returnItself(new String());
        //也可以在无类型参数的实例方法中显式指定实际类型参数，但这也是无效的，原因同上
        //，因此编译器也会提示：Type arguments are redundant for the non-generic method call
        genericMethodClass.<String>emptyMethod();
    }
}
