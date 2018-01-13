package org.usfirst.frc.team3539.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3539.robot.commands.*;
import org.usfirst.frc.team3539.robot.subsystems.*;
import org.usfirst.frc.team3539.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 **/

public class Robot extends IterativeRobot
{

	// SUBSYSTEMS
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Shooter shooter = new Shooter();
	public static final Arm arm = new Arm();

	public static OI oi;
	// public static UsbCamera camera;

	Command autonMode;
	SendableChooser<Command> autonChooser;

	public void robotInit()
	{
		oi = new OI();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 **/
	public void disabledInit()
	{
	//	BulldogLogger.getInstance().logInfo("----DISABLEINIT----");

		Scheduler.getInstance().run();

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
		// System.out.println("disabled period");

	}

	public void autonomousInit()
	{
	//	BulldogLogger.getInstance().logInfo("----AUTONINIT----");

		System.out.println("autonomousInit");

		autonMode = (Command) autonChooser.getSelected();
		if (autonMode != null)
		{
			System.out.println("Here");

			autonMode.start();
		}

		driveTrain.gyroReset();
	}

	// This function is called periodically during autonomous
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();

	}

	public void teleopInit()
	{
	//	BulldogLogger.getInstance().logInfo("----TELEOPINIT----");
	}

	// This function is called periodically during operator control
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();

	}

	// This function is called periodically during test mode
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}