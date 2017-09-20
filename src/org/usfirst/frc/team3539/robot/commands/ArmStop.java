
package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmStop extends BulldogCommand
{
	public ArmStop()
	{
		super("ArmStop");
	}

	protected void initialize()
	{
		super.initialize();
	}

	protected void execute()
	{
		super.execute();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished()
	{
		return true;
	}

	protected void end()
	{
		super.end();
		Robot.arm.setMotorPower(0);
	}

	protected void interrupted()
	{
		super.interrupted();
		end();
	}
}