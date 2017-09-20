package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

/**
 *
 */
public class Wheels extends BulldogCommand
{
	private double mechnumpower;
	private double flywheelpower;
	private double delay;
	private int counter;

	public Wheels(double flywheelpower, double mechnumpower, double delay)
	{
		super("Wheels");
		requires(Robot.shooter);
		this.flywheelpower = flywheelpower;
		this.mechnumpower = -mechnumpower;
		this.delay = delay;
	}

	protected void initialize()
	{
		super.initialize();
	}

	protected void execute()
	{
		super.execute();
		Robot.shooter.setControlPower(mechnumpower);

		if (counter * 20 >= delay * 1000)
		{
			Robot.shooter.setFlyWheel(flywheelpower);
		}
		counter++;
	}

	protected boolean isFinished()
	{
		return false;
	}

	protected void end()
	{
		super.end();
		counter = 0;
	}

	protected void interrupted()
	{
		super.interrupted();
		end();
	}
}
