package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.utilities.BulldogLogger;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootCommand extends BulldogCommand
{

	private double shootspeed;
	private double kickspeed;
	private int timer = 0;
	private double expectedtime;

	public ShootCommand(double shootspeed, double kickspeed, double expectedtime)
	{
		super("ShootCommand");
		this.shootspeed = shootspeed;
		this.kickspeed = kickspeed;
		this.expectedtime = expectedtime * 50;
	}

	// Called just before this Command runs the first time
	protected void initialize()
	{
		super.initialize();
		this.timer = 0;
		Robot.shooter.setControlPower(-this.shootspeed);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute()
	{
		super.execute();
		this.timer = this.timer + 1;
		if (this.timer >= this.expectedtime)
		{
			Robot.shooter.setFlyWheel(this.kickspeed);
			BulldogLogger.getInstance().logEvent("cute text");
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return !Robot.oi.onebuttona.get();
	}

	// Called once after isFinished returns true
	protected void end()
	{
		super.end();
		Robot.shooter.setControlPower(0);
		Robot.shooter.setFlyWheel(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		super.interrupted();
	}

}
