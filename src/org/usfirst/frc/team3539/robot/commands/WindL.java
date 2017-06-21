//
//package org.usfirst.frc.team3539.robot.commands;
//
//import org.usfirst.frc.team3539.robot.Robot;
//import org.usfirst.frc.team3539.robot.RobotMap;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class WindL extends Command
//{
//	private double power = 0;
//	
//    public WindL(double power)
//    {
//    	this.power = power;
//    }
//
//    protected void initialize()
//    {
//        System.out.println("");
//    }
//
//    protected void execute()
//    {
//    	Robot.shooter.setFlyWheel(power);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished()
//    {
//        return !Robot.oi.onebumperl.get();
//    }
//
//    protected void end()
//    {
//        Robot.shooter.setFlyWheel(0);
//    }
//
//    protected void interrupted()
//    {
//        end();
//    }
//}