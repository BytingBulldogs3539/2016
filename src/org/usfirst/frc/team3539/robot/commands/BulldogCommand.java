package org.usfirst.frc.team3539.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3539.robot.Robot;
// Standard Java libraries
import org.usfirst.frc.team3539.robot.utilities.*;

/**
 * Base class for all Commands for Team 3539
 * 
 * @author Programming team
 *
 */
public abstract class BulldogCommand extends Command
{
	String name;
	
	public BulldogCommand(String name)
	{
		super(name);
		this.name = name;
	}
	
	protected void initializes()
	{
		super.initialize();
		BulldogLogger.getInstance().logCommand(this.name + " Initialized");
	}
	
	protected void end()
	{
		super.end();
		BulldogLogger.getInstance().logCommand(this.name + " Ended");

		BulldogLogger.getInstance().logInfo("Ending " + this.name);
	}
	
	protected void interrupted()
	{
		super.interrupted();
		BulldogLogger.getInstance().logCommand(this.name + " interrupted");

		BulldogLogger.getInstance().logInfo("Interrupting " + this.name);
	}
}
