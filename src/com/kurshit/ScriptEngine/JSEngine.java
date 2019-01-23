package com.kurshit.ScriptEngine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSEngine
{

	public static void main(String[] args) throws FileNotFoundException, ScriptException
	{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
		
		Bindings binding = engine.getBindings(ScriptContext.ENGINE_SCOPE);
		engine.eval(new FileReader("Sample.js"));
	
		
	}
	
	public void m1()
	{
		System.out.println("hey");
	}
}

