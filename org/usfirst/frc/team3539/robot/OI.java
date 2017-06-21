package org.usfirst.frc.team3539.robot;
import org.usfirst.frc.team3539.robot.commands.ArmMoveX;
import org.usfirst.frc.team3539.robot.commands.ArmMoveY;
import org.usfirst.frc.team3539.robot.commands.ControlA;
import org.usfirst.frc.team3539.robot.commands.ControlB;
import org.usfirst.frc.team3539.robot.commands.IntakeCommand;
import org.usfirst.frc.team3539.robot.commands.ShootCommand;
//import org.usfirst.frc.team3539.robot.commands.WindL;
import org.usfirst.frc.team3539.robot.commands.WindR;
import org.usfirst.frc.team3539.robot.utilities.TriggerButton;
import org.usfirst.frc.team3539.robot.utilities.DpadButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	public Joystick controller1 = new Joystick(RobotMap.controllerOnePort);
	public Joystick controller2 = new Joystick(RobotMap.controllerTwoPort);

	public JoystickButton onebuttonx = new JoystickButton(controller1, RobotMap.buttonx);
	public JoystickButton onebuttony = new JoystickButton(controller1, RobotMap.buttony);
	public JoystickButton onebuttona = new JoystickButton(controller1, RobotMap.buttona);
	public JoystickButton onebuttonb = new JoystickButton(controller1, RobotMap.buttonb);
	
	

	public JoystickButton onebumperl = new JoystickButton(controller1, RobotMap.bumperl);
	public JoystickButton onebumperr = new JoystickButton(controller1, RobotMap.bumperr);

	
	
	public JoystickButton twobuttonStart = new JoystickButton(controller2, RobotMap.buttonStart);
	
	
	public JoystickButton twobuttonx = new JoystickButton(controller2, RobotMap.buttonx);
	public JoystickButton twobuttony = new JoystickButton(controller2, RobotMap.buttony);
	public JoystickButton twobuttona = new JoystickButton(controller2, RobotMap.buttona);
	public JoystickButton twobuttonb = new JoystickButton(controller2, RobotMap.buttonb);
	
	public JoystickButton twotriggerl = new JoystickButton(controller2, RobotMap.LEFT_TRIGGER);
	public JoystickButton twotriggerr = new JoystickButton(controller2, RobotMap.RIGHT_TRIGGER);
	
	public JoystickButton twobuttonLS = new JoystickButton (controller2, RobotMap.buttonLS);
	public JoystickButton twobuttonRS = new JoystickButton (controller2, RobotMap.buttonRS);

	public JoystickButton twobumperl = new JoystickButton(controller2, RobotMap.bumperl);
	public JoystickButton twobumperr = new JoystickButton(controller2, RobotMap.bumperr);

	public OI()
	{
		onebuttonx.whenPressed(new ArmMoveX(.5));
		onebuttony.whenPressed(new ArmMoveY(-.5));
		
		onebuttona.whenPressed(new ShootCommand(1, 1, 1));
		onebuttonb.whenPressed(new ControlB(1));
		
		onebumperl.whenPressed(new IntakeCommand(-1, 1));
		
		onebumperr.whenPressed(new WindR(1));
	}
}