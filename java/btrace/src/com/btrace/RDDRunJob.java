package com.btrace;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

import com.sun.btrace.AnyType;

@BTrace
public class RDDRunJob {
	@OnMethod(
	        clazz="+org.apache.spark.RDD",
	        method="/.*/"
	    )
	public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,AnyType[] args ) {
        print("entered " + probeClass+"."+probeMethod);
        printArray(args);
        println("===========") ;
    }
	
	@OnMethod(
	        clazz="org.apache.spark.SparkContext",
	        method="runJob"
	    )
	public static void m2(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,AnyType[] args ) {
        print("entered " + probeClass+"."+probeMethod);
        printArray(args);
        println("------") ;
    }
}
