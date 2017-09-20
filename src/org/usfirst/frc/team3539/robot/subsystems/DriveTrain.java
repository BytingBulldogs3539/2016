package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;
import org.usfirst.frc.team3539.robot.commands.DriveCommand;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Kenny T.
 */
@SuppressWarnings("unused")
public class DriveTrain extends BulldogSystem
{
	public CANTalon lfMotor, lbMotor, rfMotor, rbMotor;

	private CANTalon driveCan;

	private RobotDrive drive;
	private DoubleSolenoid manipulatorSol;
	private boolean manipulatorStatus;
	private ADXRS450_Gyro gyro;

	public DriveTrain()
	{
		super("DriveTrain");

		gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

		lfMotor = new CANTalon(RobotMap.lfMotorTalon);
		lbMotor = new CANTalon(RobotMap.lbMotorTalon);
		rfMotor = new CANTalon(RobotMap.rfMotorTalon);
		rbMotor = new CANTalon(RobotMap.rbMotorTalon);

		lfMotor.changeControlMode(TalonControlMode.PercentVbus);
		rfMotor.changeControlMode(TalonControlMode.PercentVbus);
		// rbMotor.changeControlMode(TalonControlMode.PercentVbus);
		// lbMotor.changeControlMode(TalonControlMode.PercentVbus);

		rbMotor.changeControlMode(TalonControlMode.Follower);
		lbMotor.changeControlMode(TalonControlMode.Follower);

		rbMotor.set(rfMotor.getDeviceID());
		lbMotor.set(lfMotor.getDeviceID());

		lfMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		rfMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		// rbMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		// lbMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);

		lfMotor.configNominalOutputVoltage(0.0f, -0.0f);
		lfMotor.configPeakOutputVoltage(12.0f, -12.0f);

		rfMotor.configNominalOutputVoltage(0.0f, -0.0f);
		rfMotor.configPeakOutputVoltage(12.0f, -12.0f);

		lfMotor.configMaxOutputVoltage(12);
		rfMotor.configMaxOutputVoltage(12);
		rfMotor.setCurrentLimit(35);
		lfMotor.setCurrentLimit(35);

		lfMotor.EnableCurrentLimit(true);
		rfMotor.EnableCurrentLimit(true);

		lfMotor.enableBrakeMode(true);
		rfMotor.enableBrakeMode(true);

		drive = new RobotDrive(lfMotor, rfMotor);
		// drive = new RobotDrive(lfMotor, lbMotor, rfMotor, rbMotor);
		drive.setSafetyEnabled(false);

		lfMotor.setSafetyEnabled(false);
		rfMotor.setSafetyEnabled(false);
		lbMotor.setSafetyEnabled(false);
		rbMotor.setSafetyEnabled(false);
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
		return (lfMotor.getEncPosition() - rfMotor.getEncPosition()) / 2;
	}
	public int getRightEnc()
	{
		return rfMotor.getEncPosition();
		//return rfMotor.getPulseWidthPosition();
	}
	public int getLeftEnc()
	{
		return lfMotor.getEncPosition();
		//return lfMotor.getPulseWidthPosition();
		
	}

	public void zeroEncoders()
	{
		// lfMotor.setEncPosition(0);
		// rfMotor.setEncPosition(0);
		// rbMotor.setEncPosition(0);
		// lbMotor.setEncPosition(0);

		lfMotor.setPosition(0);
		rfMotor.setPosition(0);
		// rbMotor.setPosition(0);
		// lbMotor.setPosition(0);
	}

	public void disablePIDControl()
	{
		lfMotor.disableControl();
		rfMotor.disableControl();
		// lbMotor.disableControl();
		// rbMotor.disableControl();
	}

	public void talonControlVBus()
	{
		lfMotor.changeControlMode(TalonControlMode.PercentVbus);
		rfMotor.changeControlMode(TalonControlMode.PercentVbus);
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