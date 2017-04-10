package com.yx.command;

import java.util.List;
import java.util.Scanner;

public class Console {

	public void start()
	{
		Scanner scan = new Scanner(System.in);
		AddCommand ac = new AddCommand(scan);
		AddCommand ac1 = new AddCommand(scan);
		AddCommand ac2 = new AddCommand(scan);
		AddCommand ac3 = new AddCommand(scan);
		
		while(scan.hasNext())
		{
			String command = scan.next();
			if (ac.getCommandName().equals(command)) {
				ac.execute();
				List<String> result = ac.getResult();
			} else if (ac.getCommandName().equals(command))
			{
				
			}
		}
	}
}
