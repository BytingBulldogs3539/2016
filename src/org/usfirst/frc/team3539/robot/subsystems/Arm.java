package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends BulldogSystem
{
	private WPI_TalonSRX armMotor;
	private WPI_TalonSRX armMotorTwo;

	public Arm()
	{
		super("Arm");
		armMotor = new WPI_TalonSRX(RobotMap.armTalonTwo);
		armMotorTwo = new WPI_TalonSRX(RobotMap.armTalon);

		armMotor.setNeutralMode(NeutralMode.Brake);
		armMotorTwo.setNeutralMode(NeutralMode.Brake);
	}

	public void setMotorPower(double power)
	{
		armMotor.set(power);
		System.out.println("ENC POSITION " + armMotor.getSelectedSensorPosition(0));
		armMotorTwo.set(-power);
	}

	public void initDefaultCommand()
	{
	}

	public void SmartInit()
	{
	}

	@Override
	public void Update()
	{
		// TODO Auto-generated method stub

	}

}
