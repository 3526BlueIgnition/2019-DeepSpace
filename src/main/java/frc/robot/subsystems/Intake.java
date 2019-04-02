/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;



/**
 * Add your docs here.
 */
public class Intake extends Subsystem {

  public Intake() {
  }

  public void Stop_Intake() {
      RobotMap.intakeMotor.set(0.0);
  }

  public void initDefaultState() { 
      Stop_Intake();
  }

public boolean get_Limit_State(){
    return RobotMap.limitin.get();
}
  public void intake_In(){
      RobotMap.intakeMotor.set(1);
  }

  public void intake_Out(){
      RobotMap.intakeMotor.set(-1);
  }

  @Override
  protected void initDefaultCommand() {
  }

  public void arm_Up(){
      RobotMap.piston2.set(DoubleSolenoid.Value.kReverse);
  }

  public void arm_down(){
      RobotMap.piston2.set(DoubleSolenoid.Value.kForward);
  }
 
 public void grab(){
     RobotMap.piston1.set(Value.kReverse);
 }
 public void release(){
     RobotMap.piston1.set(Value.kForward);
 }
  public void Stop_Arms(){
      RobotMap.piston2.set(Value.kOff);
      RobotMap.piston1.set(Value.kOff);
  }
  
}