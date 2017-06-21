
package org.usfirst.frc.team3539.robot.commands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmMoveX extends Command
{
	private double power = 0;
	
    public ArmMoveX(double power)
    {
    	this.power = power;
    }

    protected void initialize()
    {
        System.out.println("");
    }

    protected void execute()
    {
    	Robot.arm.setMotorPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return !Robot.oi.onebuttonx.get();
    }

    protected void end()
    {
        Robot.arm.setMotorPower(0);
    }

    protected void interrupted()
    {
        end();
    }
}