package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;



import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;


/**
 * @author Domink D
 */
@SuppressWarnings("unused")
public class DriveTrain extends BulldogSystem
{
	public WPI_TalonSRX lfMotor, lbMotor, rfMotor, rbMotor;

	private TalonSRX driveCan;
	private DifferentialDrive drive;
	private RobotDrive d;
	private DoubleSolenoid manipulatorSol;
	private boolean manipulatorStatus;
	private ADXRS450_Gyro gyro;
	//private RobotBase drive;
	public DriveTrain()
	{
		super("DriveTrain");

		gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

		lfMotor = new WPI_TalonSRX(RobotMap.lfMotorTalon);
		lbMotor = new WPI_TalonSRX(RobotMap.lbMotorTalon);
		rfMotor = new WPI_TalonSRX(RobotMap.rfMotorTalon);
		rbMotor = new WPI_TalonSRX(RobotMap.rbMotorTalon);

		lfMotor.set(ControlMode.PercentOutput,0.0);
		rfMotor.set(ControlMode.PercentOutput,0.0);
		// rbMotor.changeControlMode(TalonControlMode.PercentVbus);
		// lbMotor.changeControlMode(TalonControlMode.PercentVbus);
//******************
		rbMotor.set(ControlMode.Follower,rfMotor.getDeviceID());
	lbMotor.set(ControlMode.Follower, lfMotor.getDeviceID());
//*******************
		lfMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rfMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		// rbMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		// lbMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		lfMotor.configNominalOutputForward(1, 0);
		lfMotor.configNominalOutputReverse(-1, 0);
		rfMotor.configNominalOutputForward(1, 0);
		rfMotor.configNominalOutputReverse(-1, 0);

	
	
		lfMotor.configPeakOutputForward(1, 0);
		lfMotor.configPeakOutputReverse(-1, 0);
		rfMotor.configPeakOutputForward(1, 0);
		rfMotor.configPeakOutputReverse(-1, 0);
		rfMotor.configContinuousCurrentLimit(35,0);
		lfMotor.configContinuousCurrentLimit(35,0);
		lfMotor.enableCurrentLimit(true);
		rfMotor.enableCurrentLimit(true);

		lfMotor.setNeutralMode(NeutralMode.Brake);
		rfMotor.setNeutralMode(NeutralMode.Brake);
		
		 drive = new DifferentialDrive(rfMotor,lfMotor);
		//RobotBase drive = new RobotBase(lfMotor, rfMotor);
		//drive = new RobotDrive(lfMotor, rfMotor);
		// drive = new RobotDrive(lfMotor, lbMotor, rfMotor, rbMotor);
		//drive.setSafetyEnabled(false);
//
//		lfMotor.setSafetyEnabled(false);
//		rfMotor.setSafetyEnabled(false);
//		lbMotor.setSafetyEnabled(false);
//		rbMotor.setSafetyEnabled(false);
	}

	public void driveLinear(double speed)
	{
		drive.tankDrive(speed, speed);
	}
	
	public void setRightPower(double speed)
	{
		rfMotor.set(-speed);
	}
	public void setLeftPower(double speed)
	{
		lfMotor.set(speed);
	}

	public void turnLinear(double speed)
	{
		drive.tankDrive(-speed, speed);		
	}

	public double getBalancedEncoderPosition()
	{
		return 0; //(lfMotor.getEncPosition() - rfMotor.getEncPosition()) / 2;
	}
	public int getRightEnc()
	{
		return 0;// rfMotor.getEncPosition();
		//return rfMotor.getPulseWidthPosition();
	}
	public int getLeftEnc()
	{
		return 0; //lfMotor.getEncPosition();
		//return lfMotor.getPulseWidthPosition();
		
	}

	public void zeroEncoders()
	{
		// lfMotor.setEncPosition(0);
		// rfMotor.setEncPosition(0);
		// rbMotor.setEncPosition(0);
		// lbMotor.setEncPosition(0);
//
//		lfMotor.setPosition(0);
//		rfMotor.setPosition(0);
		// rbMotor.setPosition(0);
		// lbMotor.setPosition(0);
	}

	public void disablePIDControl()
	{
//		lfMotor.disableControl();
//		rfMotor.disableControl();
		// lbMotor.disableControl();
		// rbMotor.disableControl();
	}

	public void talonControlVBus()
	{
		rfMotor.set(ControlMode.PercentOutput,rfMotor.getDeviceID());
		lfMotor.set(ControlMode.PercentOutput,lfMotor.getDeviceID());

//		lfMotor.changeControlMode(TalonControlMode.PercentVbus);
//		rfMotor.changeControlMode(TalonControlMode.PercentVbus);
		// lbMotor.changeControlMode(TalonControlMode.PercentVbus);
		// rbMotor.changeControlMode(TalonControlMode.PercentVbus);
	}

	public void driveArcade(double leftStick, double rightStick)
	{
		
		drive.arcadeDrive(leftStick, rightStick);
		//System.out.println(rightStick);
	}

	public void gyroReset()
	{
		gyro.reset();
		System.out.println("Gyro Zeroed");
	}

	public double getGyroAngle()
	{
		return gyro.getAngle();
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(new DriveCommand());
	}

	public void stopTrain()
	{
		drive.arcadeDrive(0, 0);
	}

	@Override
	public void Update()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SmartInit()
	{
		// TODO Auto-generated method stub
		
	}
}