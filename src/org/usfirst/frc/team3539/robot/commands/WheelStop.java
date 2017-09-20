package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

/**
 *
 */
public class WheelStop extends BulldogCommand
{
	public WheelStop()
	{
		super("WheelStop");
		
		requires(Robot.shooter);
	}

	protected void initialize()
	{
		super.initialize();
	}

	protected void execute()
	{
		super.execute();
		Robot.shooter.setControlPower(0);
		Robot.shooter.setFlyWheel(0);
	}

	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
		super.end();
	}

	protected void interrupted()
	{
		super.interrupted();
		end();
	}
}
