/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.CANifier.LEDChannel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Luces extends Subsystem {

  public void Prender_Azul(double val){
    RobotMap.LEDs.setLEDOutput(val, LEDChannel.LEDChannelC);
  }

  public void Prender_Rojo(double val){
    RobotMap.LEDs.setLEDOutput(val, LEDChannel.LEDChannelB);
  }
  public void Prender_Verde(double val){
    RobotMap.LEDs.setLEDOutput(val, LEDChannel.LEDChannelA);
  }
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
