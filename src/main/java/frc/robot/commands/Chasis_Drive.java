//*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Chasis_Drive extends Command {
  public Chasis_Drive() {
    requires(Robot.chasis);
    requires(Robot.luces);
  }

  @Override
  protected void initialize() {
    Robot.luces.Prender_Azul(1);
    Robot.luces.Prender_Rojo(0);
    Robot.luces.Prender_Verde(0);
  }

  @Override
  protected void execute() {
    
    Robot.chasis.set_motor(Robot.m_oi.get_yAxisR(), Robot.m_oi.get_yAxisL());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.chasis.print_encoder();
    Robot.chasis.set_motor(0, 0);
    Robot.chasis.reset_encoders();
  }

  @Override
  protected void interrupted() {
  }
}
