package com.btrace;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.AnyType;

@BTrace
public class AllMethods {
	@OnMethod(
            //clazz="/org\\.apache\\.spark\\..*/",
            clazz="org.apache.spark.SparkContext",
            method="/.*/"
        )
    public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod, AnyType[] args ) {
            print(probeClass+"."+probeMethod);
            printArray(args);
	}
	
	@OnMethod(
            clazz="/org\\.apache\\.spark\\..*/",
            method="/.*/",
            location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
    public static void ml(@Self Object self,@TargetInstance Object instance, @TargetMethodOrField String method, @ProbeMethodName String probeMethod, AnyType[] args ) {
        if(instanceOf(self,"org.apache.spark.SparkContext")) {   
        	print(instance+"."+method);
            printArray(args);
        }    
	}
	
}

