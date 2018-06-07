package com.btrace;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.AnyType;

@BTrace
public class ImplementMethods {
	@OnMethod(
	        clazz="+org.apache.hadoop.mapred.InputFormat",
	        method="/.*/"
	    )
	public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,AnyType[] args) {
        print("enter " + probeClass+"."+probeMethod);
        printArray(args);
    }
}
