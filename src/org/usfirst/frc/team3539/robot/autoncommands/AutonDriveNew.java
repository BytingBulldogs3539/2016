package org.usfirst.frc.team3539.robot.autoncommands;

import org.usfirst.frc.team3539.robot.Robot;

import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.utilities.BulldogPIDOutput;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

import jaci.pathfinder.Pathfinder;

/**
 *
 */
public class AutonDriveNew extends PIDCommand 
{
	private double DriveDistance;
	private BulldogPIDOutput pidOutput = new BulldogPIDOutput();
	private PIDController anglePID;
	private double startTurn = 0;
	private boolean pidenabled;

	
	private boolean useVision = false;
	
	private final PIDSource angle_output_source = new PIDSource()
			{
		public void setPIDSourceType(PIDSourceType pidSource)
		{
			
		}
		public PIDSourceType getPIDSourceType()
		{
			return PIDSourceType.kDisplacement;
		}
		public double pidGet()
		{
			return Robot.driveTrain.getGyroAngle();

		}
		
			};
	
    public AutonDriveNew(double inches, double desiredTime, double timeOut) 
    {
    	super("AutonDriveNew", RobotMap.drivePea, RobotMap.driveEye, RobotMap.driveDee);
    	
    	DriveDistance = Robot.driveTrain.inchToEnc2(inches);
    	requires(Robot.driveTrain);
    	this.useVision = false;
    	double DriveSpeed = Math.abs(inches)/RobotMap.driveSpeed;
    	if (DriveSpeed > RobotMap.deadband)
    		DriveSpeed = RobotMap.deadband;
    	if (DriveSpeed < 1)
    	{
    		DriveSpeed = 1;
    	}
    	this.getPIDController().setOutputRange(-DriveSpeed, DriveSpeed);
    	this.setTimeout(timeOut);
    	this.startTurn = 0;
    	
    }
    public double returnAnglePIDInput()
    {
    	return Robot.raspberry.getTurnAngle();
    }

    protected void initialize() 
    {
    	anglePID = new PIDController (RobotMap.turnPea, RobotMap.turnEye, RobotMap.turnDee, angle_output_source, pidOutput);
    	if(useVision)
    	{
    		anglePID.setSetpoint(Robot.raspberry.getTurnAngle());
    	}
    	else
    		anglePID.setSetpoint(0);
    	anglePID.setAbsoluteTolerance(RobotMap.AutonDriveTolerance);
    	anglePID.setToleranceBuffer(5);
    	
    	this.getPIDController().setPID(RobotMap.drivePea, RobotMap.driveEye, RobotMap.driveDee);
    	Robot.driveTrain.gyroReset();
    	Robot.driveTrain.zeroEncoders();
    	this.setSetpoint(DriveDistance);
    	this.pidenabled = false;
    }

    protected void execute() 
    {
    	if (Robot.driveTrain.encToInch(Robot.driveTrain.getBalancedEncoderPosition())<=this.startTurn && !this.pidenabled)
    	{
    		anglePID.enable();
    		this.pidenabled = true;
    	}
    	else
    	{
    		anglePID.disable();
    		this.pidenabled = false;
    	}
    }

    protected boolean isFinished() 
    {
    	return (this.getPIDController().onTarget() || this.isTimedOut());
    }

    protected void end() 
    {
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.stopTrain();
		anglePID.disable();
		this.pidenabled = false;
		pidOutput.Reset();
    }

    protected void interrupted() 
    {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) 
	{
		
	}
}
