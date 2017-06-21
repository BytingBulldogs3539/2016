
package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlA extends Command
{
	private double power = 0;
	
    public ControlA(double power)
    {
    	this.power = power;
    }

    protected void initialize()
    {
        System.out.println("");
    }

    protected void execute()
    {
    	Robot.shooter.setControlPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return !Robot.oi.onebuttona.get();
    }

    protected void end()
    {
        Robot.shooter.setControlPower(0);
    }

    protected void interrupted()
    {
        end();
    }
}