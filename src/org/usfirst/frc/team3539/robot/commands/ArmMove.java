
package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmMove extends BulldogCommand
{
	private double power = 0;
	
    public ArmMove(double power)
    {
    	super("ArmMove");
    	this.power = -power;
    }

    protected void initialize()
    {
    	super.initialize();
    }

    protected void execute()
    {
    	super.execute();
    	Robot.arm.setMotorPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
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