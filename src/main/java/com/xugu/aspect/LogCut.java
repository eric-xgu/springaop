package com.xugu.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
* 切面由通知与切入点组成
* 切入点：拦截哪些类的哪些方法
* 通知：拦截了方法后做什么
* */
@Component //交个ioc实例化
@Aspect //声明这是一个切面
public class LogCut {
    /*
    * @Poincut("匹配规则")
    * @Poincut("execute(* com.xugu.service.*.*(..))")
    * 第一个*为类属性 public，private，protect
    * 第二个*为service下的所有类
    * 第三个*为所有的方法
    * 第四个为..所有的参数
    * 1、拦截所有的公共方法
    * @Pointcut("execution(public *(..)")
    * 2、所有的set方法
    * @Pointcut("execution(* set*(..)")
    *
    * 3、指定包下的任意方法
    * @Pointcut("execution(* com.xugu.service.*.*(..))")
    *
    * 4、指定包及子包的方法
    * @Pointcut("execution(* com.xugu.service..*.*(..))")
    *
     * */
    //@Pointcut //定义切入点
    @Pointcut("execution(* com.xugu.service..*.*(..))")
    public void cut(){

    }


    /*
    * 通知,执行前执行通知
    * */
    @Before(value = "cut()")
    public void before(){
        System.out.println("前置通知");
    }

    @AfterReturning(value = "cut()")
    public void afterReturn(){
        System.out.println("结束通知");
    }

    @After(value = "cut()")
    /*
    * finally
    * */
    //有无异常，执行结束都会通知
    public void after(){
        //service方法执行后
        System.out.println("后置通知");
    }

    @AfterThrowing(value = "cut()",throwing = "e")
    public void afterThrow(Exception e){
        System.out.println("异常通知"+e.getMessage());
    }

    /*
    *需要显示调用方法，否则无法访问指定方法pjp.proceed()
    * */

    @Around(value = "cut()")
    public  Object around(ProceedingJoinPoint pjp){
        System.out.println("around通知 ->前置通知");
        Object object=null;
        try{
            object=pjp.proceed();
            System.out.println("环绕-返回通知");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕-异常通知");
        }
        System.out.println("环绕-最终通知");
        return  object;
    }


}
