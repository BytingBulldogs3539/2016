package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends BulldogSystem
{
	private CANTalon armMotor;
	private CANTalon armMotorTwo;

	public Arm()
	{
		super("Arm");
		armMotor = new CANTalon(RobotMap.armTalonTwo);
		armMotorTwo =  new CANTalon(RobotMap.armTalon);
		
		armMotor.enableBrakeMode(true);
		armMotorTwo.enableBrakeMode(true);
	}

	public void setMotorPower(double power)
	{
		armMotor.set(power);
		System.out.println("ENC POSITION " + armMotor.getEncPosition());
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
