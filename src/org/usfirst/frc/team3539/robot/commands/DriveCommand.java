package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command
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
		super.execute();
	Robot.driveTrain.driveArcade(Robot.oi.controller1.getRawAxis(RobotMap.Y_AxisL), Robot.oi.controller1.getRawAxis(RobotMap.X_AxisR));
	System.out.print(Robot.oi.controller1.getRawAxis(RobotMap.Y_AxisL));
	System.out.print(Robot.oi.controller1.getRawAxis(RobotMap.X_AxisR));

	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
Robot.driveTrain.stopTrain();
super.end();
	}

	protected void interrupted()
	{
		super.interrupted();
		end();
	}
}
