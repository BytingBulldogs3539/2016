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
		super.initialize();
		System.out.println("DriveCommand was initialized");
		Robot.driveTrain.talonControlVBus();
		
	}

	protected void execute()
	{
		double x = Robot.oi.controller1.getRawAxis(RobotMap.RIGHT_TRIGGER)-Robot.oi.controller1.getRawAxis(RobotMap.LEFT_TRIGGER);
		super.execute();
		Robot.driveTrain.driveArcade(x, -Robot.oi.controller1.getRawAxis(RobotMap.X_AxisL));
	}

	protected boolean isFinished()
	{
		return false;
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
