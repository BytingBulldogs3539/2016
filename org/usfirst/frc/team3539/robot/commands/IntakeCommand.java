package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

/**
 *
 */
public class IntakeCommand extends BulldogCommand
{
	
	private double motorpower;
	private double flywheelpower;

	public IntakeCommand(double power, double power1)
	{
		super("IntakeCommand");
		requires(Robot.arm);
		this.flywheelpower = power;
		this.motorpower = power1;
	}

	protected void initialize()
	{
		super.initialize("IntakeCommand");
	}

	protected void execute()
	{
		Robot.shooter.setControlPower(motorpower);
		Robot.shooter.setFlyWheel(this.flywheelpower);
	}

	protected boolean isFinished()
	{
		return !Robot.oi.onebumperl.get();
	}

	protected void end()
	{
		super.end("IntakeCommand");
		Robot.shooter.setControlPower(0);
		Robot.shooter.setFlyWheel(0);

	}

	protected void interrupted()
	{
		end();
	}
}
