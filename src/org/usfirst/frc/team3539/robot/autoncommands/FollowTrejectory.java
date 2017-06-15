package org.usfirst.frc.team3539.robot.autoncommands;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

/**
 *
 */
public class FollowTrejectory extends Command {
	EncoderFollower left;
	EncoderFollower right;

    public FollowTrejectory() 
    {
    	
    }
    protected void initialize() 
    {
		Robot.driveTrain.gyroReset();
		Robot.driveTrain.zeroEncoders();
        Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, SmartDashboard.getDouble("Interval Rate"), 192, 120, 10);
        Waypoint[] points = new Waypoint[] 
        {
        		new Waypoint(0,0,Pathfinder.d2r(0)),
        		new Waypoint(24,24,Pathfinder.d2r(-60))
        };
        System.out.println("I Am creating trajectory");

        Trajectory trajectory = Pathfinder.generate(points, config);
        
        TankModifier modifier = new TankModifier(trajectory).modify(34);
        
        left = new EncoderFollower(modifier.getLeftTrajectory());
        right = new EncoderFollower(modifier.getRightTrajectory());
        
        left.configureEncoder(Robot.driveTrain.getLeftEnc(), 1024, 4);
        right.configureEncoder(-Robot.driveTrain.getRightEnc(), 1024, 4);
        
        left.configurePIDVA(RobotMap.drivePea, RobotMap.driveEye, RobotMap.driveDee, .24, 0);
        right.configurePIDVA(RobotMap.drivePea, RobotMap.driveEye, RobotMap.driveDee, .24, 0);
    }
    protected void execute() 
    {
    	double l = left.calculate(Robot.driveTrain.getLeftEnc());
        double r = right.calculate(-Robot.driveTrain.getRightEnc());
        
        double gyro_heading = Robot.driveTrain.getGyroAngle();
        double desired_heading = Pathfinder.r2d(left.getHeading());
        if (desired_heading>0)
        {
        	desired_heading= desired_heading+180;
        }
        if (desired_heading<0)
        	desired_heading = desired_heading-180;
        
        
        double angleDifference = Pathfinder.boundHalfDegrees(desired_heading-gyro_heading);
        double turn = .01*angleDifference;
        Robot.driveTrain.setLeftPower(l - turn);
        Robot.driveTrain.setRightPower(r + turn);
        System.out.println(l+" ,"+r +" ,"+turn);

    }
    protected boolean isFinished() 
    {
    	return false;
    }
    protected void end() 
    {
    	Robot.driveTrain.setLeftPower(0);
    	Robot.driveTrain.setRightPower(0);
    	
    	System.out.println("cancel");
    	
    	left.reset();
    	right.reset();
    	
    }

    protected void interrupted() 
    {
    	end();
    }
}