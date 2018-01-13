package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends BulldogSystem
{
	private WPI_TalonSRX controlWheel;
	private WPI_TalonSRX flyWheel;

	public Shooter()
	{
		super("Shooter");
		controlWheel = new WPI_TalonSRX(RobotMap.controlWheel);
		
		
		flyWheel = new WPI_TalonSRX(RobotMap.flyWheel);
	flyWheel.configContinuousCurrentLimit(35,0);
	}
	
	public void setControlPower(double power)
	{
		controlWheel.set(power);
	}

	public void setFlyWheel(double power)
	{
		flyWheel.set(power);
	}

	public void initDefaultCommand()
	{
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