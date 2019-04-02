/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Elevador extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX MotElevaD;
  public static TalonSRX MotElevaI;

public Elevador(){
    MotElevaD = new TalonSRX(4);
    MotElevaI = new TalonSRX(5);

    // Configuraciones del elevador
    MotElevaD.setInverted(true);
    MotElevaI.setInverted(false);
    TalonConfig_Brake(MotElevaD);
    TalonConfig_Brake(MotElevaI);

}
//////////////////////////////////////////////
public void Elevador_Ar(double val){
  MotElevaD.set(ControlMode.PercentOutput, val);
  MotElevaI.set(ControlMode.PercentOutput, val);
}

public void Elevador_Ab(double val){
  MotElevaD.set(ControlMode.PercentOutput, val);
  MotElevaI.set(ControlMode.PercentOutput, val);
}
////////////////////////////////////////////////////

public void Elevador_stop(){
  MotElevaD.set(ControlMode.PercentOutput, 0.0);
  MotElevaI.set(ControlMode.PercentOutput, 0.0);
}

public void InitDefaultState(){
  Elevador_stop();
}
 
public void initDefaultCommand() {
  // Set the default command for a subsystem here.
  // setDefaultCommand(new MySpecialCommand());
}

public static void TalonConfig_Brake(TalonSRX motor){
  
  motor.setNeutralMode(NeutralMode.Brake);            // Modo inercia libre
  motor.configClosedloopRamp(RobotMap.RampDrive, 0);           // Tiempo para llegar a maxima velocidad (Close loop)
  motor.configOpenloopRamp(RobotMap.RampDrive, 0);             // Tiempo para llegar a maxima velocidad (Open loop)
  motor.set(ControlMode.PercentOutput, 0);            // Envio de datos en porcentaje -1 a 1
  
}

}
