# [TraitExample](https://github.com/rjbhewei/scala-learn/blob/master/src/com/hewei/basics/TraitExample.scala) 例子解析

## 关系分析
~~~
public interface com.hewei.basics.TraitExample$B extends com.hewei.basics.TraitExample$A
public interface com.hewei.basics.TraitExample$C extends com.hewei.basics.TraitExample$A
public class com.hewei.basics.TraitExample$E implements com.hewei.basics.TraitExample$C,com.hewei.basics.TraitExample$B
~~~

##### `TraitExample.E` 分析
~~~
public int com$hewei$basics$TraitExample$B$$super$a();
    descriptor: ()I
    flags: ACC_PUBLIC, ACC_SYNTHETIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokestatic  #17                 // Method com/hewei/basics/TraitExample$C$class.a:(Lcom/hewei/basics/TraitExample$C;)I
         4: ireturn
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/hewei/basics/TraitExample$E;
      LineNumberTable:
        line 38: 0

  public int a();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokestatic  #24                 // Method com/hewei/basics/TraitExample$B$class.a:(Lcom/hewei/basics/TraitExample$B;)I
         4: ireturn
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/hewei/basics/TraitExample$E;
      LineNumberTable:
        line 38: 0

  public int com$hewei$basics$TraitExample$C$$super$a();
      descriptor: ()I
      flags: ACC_PUBLIC, ACC_SYNTHETIC
      Code:
        stack=1, locals=1, args_size=1
           0: aload_0
           1: invokestatic  #30                 // Method com/hewei/basics/TraitExample$A$class.a:(Lcom/hewei/basics/TraitExample$A;)I
           4: ireturn
        LocalVariableTable:
          Start  Length  Slot  Name   Signature
              0       5     0  this   Lcom/hewei/basics/TraitExample$E;
        LineNumberTable:
          line 38: 0
~~~

#### `TraitExample.C` 分析
~~~
public static int a(com.hewei.basics.TraitExample$C);
    descriptor: (Lcom/hewei/basics/TraitExample$C;)I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #13                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
         3: ldc           #15                 // String c
         5: invokevirtual #19                 // Method scala/Predef$.print:(Ljava/lang/Object;)V
         8: aload_0
         9: invokeinterface #25,  1           // InterfaceMethod com/hewei/basics/TraitExample$C.com$hewei$basics$TraitExample$C$$super$a:()I
        14: ireturn
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      15     0 $this   Lcom/hewei/basics/TraitExample$C;
      LineNumberTable:
        line 29: 0
        line 30: 8
~~~

#### `TraitExample.B` 分析
~~~
public static int a(com.hewei.basics.TraitExample$B);
    descriptor: (Lcom/hewei/basics/TraitExample$B;)I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #13                 // Field scala/Predef$.MODULE$:Lscala/Predef$;
         3: ldc           #15                 // String b
         5: invokevirtual #19                 // Method scala/Predef$.print:(Ljava/lang/Object;)V
         8: aload_0
         9: invokeinterface #25,  1           // InterfaceMethod com/hewei/basics/TraitExample$B.com$hewei$basics$TraitExample$B$$super$a:()I
        14: ireturn
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      15     0 $this   Lcom/hewei/basics/TraitExample$B;
      LineNumberTable:
        line 22: 0
        line 23: 8
~~~

###### 好的明白的应该已经明白了