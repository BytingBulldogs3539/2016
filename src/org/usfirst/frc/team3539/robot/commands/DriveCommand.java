package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

/**
 *
 */
public class DriveCommand extends BulldogCommand
{

	public DriveCommand()
	{
		super("DriveCommand");
		requires(Robot.driveTrain);
	}

	protected void initialize()
	{
		super.initialize("DriveCommand");
		System.out.println("DriveCommand was initialized");
		Robot.driveTrain.talonControlVBus();
	}

	protected void execute()
	{
		Robot.driveTrain.driveArcade(-Robot.oi.controller1.getRawAxis(RobotMap.Y_AxisL),
				-Robot.oi.controller1.getRawAxis(RobotMap.X_AxisR));

	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		super.end("DriveCommand");
		System.out.println("DriveCommand was ended");
	}

	protected void interrupted()
	{
		end();
	}
}
