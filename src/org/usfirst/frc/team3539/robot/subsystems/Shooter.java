package org.usfirst.frc.team3539.robot.subsystems;

import org.usfirst.frc.team3539.robot.Robot;
import org.usfirst.frc.team3539.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem
{
	private CANTalon controlWheel;
	private CANTalon flyWheel;

	public Shooter()
	{
		super("Shooter");
		controlWheel = new CANTalon(RobotMap.controlWheel);
		
		
		flyWheel = new CANTalon(RobotMap.flyWheel);
		flyWheel.EnableCurrentLimit(true);
		flyWheel.setCurrentLimit(35);
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
}