/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.Chasis_Drive;
import frc.robot.commands.verde;
import frc.robot.subsystems.Chasis;
import frc.robot.subsystems.Elevador;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Luces;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  public static Chasis chasis = new Chasis();
  public static Elevador elevador = new Elevador();
  public static Intake intake = new Intake();
  public static Luces luces = new Luces();
  public static OI m_oi = new OI();

  // Comandos
  Command main_drive = new Chasis_Drive();
  Command verde = new verde();

  @Override
  public void robotInit() {
    RobotMap.resource_init();
    CameraServer.getInstance().startAutomaticCapture();
    verde.start();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void disabledInit() {
    verde.start();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    main_drive.start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    main_drive.start();                             // Iniciar chasis
    verde.start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
