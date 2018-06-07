package com.btrace;

import static com.sun.btrace.BTraceUtils.print;
import static com.sun.btrace.BTraceUtils.printArray;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

public class AntRuleAccept {
	@OnMethod(
	        clazz="+org.antlr.v4.runtime",
	        method="accept"
	    )
	public static void m(@ProbeClassName String probeClass, @ProbeMethodName String probeMethod,AnyType[] args) {
        print("enter " + probeClass+"."+probeMethod);
        printArray(args);
    }
}
