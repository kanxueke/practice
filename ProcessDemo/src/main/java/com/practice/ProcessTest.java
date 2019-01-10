package com.practice;

import java.io.IOException;

public class ProcessTest 
{
    public static void main( String[] args )
    {
    	try {
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec("cmd.exe /k start dir");
			System.out.println(p.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
