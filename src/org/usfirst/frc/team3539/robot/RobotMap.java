package org.usfirst.frc.team3539.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// CONTROLLER PORT
	public static final int controllerOnePort = 1;
	public static final int controllerTwoPort = 0;

	// CONTROLLER AXIS
	public static final int X_AxisL = 0;
	public static final int Y_AxisL = 1;

	public static final int X_AxisR = 4;
	public static final int Y_AxisR = 5;

	public static final int RIGHT_TRIGGER = 3;
	public static final int LEFT_TRIGGER = 2;

	// BUTTON/
	public static final int buttona = 1;
	public static final int buttonb = 2;
	public static final int buttonx = 3;
	public static final int buttony = 4;
	public static final int buttonStart = 8;
	public static final int buttonLS = 9;
	public static final int buttonRS = 10;

	// BUMPER
	public static final int bumperl = 5;
	public static final int bumperr = 6;

	// DRIVE
	public static final int lfMotorTalon = 1;
	public static final int lbMotorTalon = 2;
	public static final int rfMotorTalon = 6;
	public static final int rbMotorTalon = 5;

	//3 and 4 are the climber
	
	//7 is the flashlight
	//8 is the control wheels
	//11 and 12 are ratchets
	
	public static final int controlWheel = 8; //DONE
	
	// ARM
	public static final int armTalon = 7; //might be intake was 9
	public static final int armTalonTwo = 10; //might be intake

	// SHOOTER
	public static final int flyWheel = 9; //DONE
}	