/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Chasis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double speed;

  public Chasis(){
    speed = 1;
  }

  public void set_motor(double RValue, double LValue){

    RobotMap.MotChasisD1.set(ControlMode.PercentOutput, -RValue*speed);
    RobotMap.MotChasisI1.set(ControlMode.PercentOutput, -LValue*speed);
  }

public void Chasis1_Up(){
  RobotMap.pistonC1.set(DoubleSolenoid.Value.kReverse);
}

public void Chasis1_down(){
  RobotMap.pistonC1.set(DoubleSolenoid.Value.kForward);
}

public void Chasis2_Up(){
  RobotMap.pistonC2.set(DoubleSolenoid.Value.kReverse);
}

public void Chasis2_down(){
  RobotMap.pistonC2.set(DoubleSolenoid.Value.kForward);
}

  public int[] get_encoder(){
    int[] pos = new int[2];
    pos[0] = RobotMap.MotChasisD1.getSelectedSensorPosition();
    pos[1] = RobotMap.MotChasisI1.getSelectedSensorPosition();

    return pos;
  }

  public void print_encoder(){
    // Configuracion de encoder ---> 1440 CPR
    int[] pos = new int[2];
    pos = get_encoder();
    SmartDashboard.putNumber("Encoder derecho: ", pos[0]);
    SmartDashboard.putNumber("Encoder Izquierdo: ", pos[1]);
  }

  public void reset_encoders(){
    RobotMap.MotChasisD1.setSelectedSensorPosition(0);
    RobotMap.MotChasisI1.setSelectedSensorPosition(0);
  }
  
  @Override
  public void initDefaultCommand() {
  }
}
