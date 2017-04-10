package com.yx.command;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddCommand {

	private Scanner scan;
	
	private List<String> result = new LinkedList<String>();
	
	public AddCommand(Scanner scan) {
		super();
		this.scan = scan;
	}

	public String getCommandName(){
		return "add";
	}
	
	public List<String> getResult() {
		return result;
	}
	
	public void execute()
	{
		result.clear();
		System.out.println("xuehao");
		result.add(scan.next());
		System.out.println("xuehao");
		result.add(scan.next());
		System.out.println("xuehao");
		result.add(scan.next());
	}
}
