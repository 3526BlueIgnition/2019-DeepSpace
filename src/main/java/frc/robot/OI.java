/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.BallIn;
import frc.robot.commands.BallOut;
import frc.robot.commands.ElevadorAbajo;
import frc.robot.commands.ElevadorArriba;
import frc.robot.commands.arm;
import frc.robot.commands.panel_new;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick control = new Joystick(RobotMap.JOY_PORT);
  public static final double ZONA_MUERTA = 0.05;

  public double get_yAxisL(){
    double raw = control.getRawAxis(RobotMap.LAXIS_Y);
    return Math.abs(raw) < ZONA_MUERTA ? 0.0 : raw;
  }

  public double get_yAxisR(){
    double raw = control.getRawAxis(RobotMap.RAXIS_Y);
    return Math.abs(raw) < ZONA_MUERTA ? 0.0 : raw;
  }
/// Arriba
public double get_LTtrigger(){
  double raw = control.getRawAxis(RobotMap.BTNLT);
  return raw;
}
////Abajo
public double get_RTtrigger(){
  double raw = control.getRawAxis(RobotMap.BTNRT);
  return raw;
}
  
  // Botones

  Button btn_A = new JoystickButton(control, RobotMap.BTNA);
  Button btn_B = new JoystickButton(control, RobotMap.BTNB);
  Button btn_R3 = new JoystickButton(control, RobotMap.BTNR3);
  Button btn_X = new JoystickButton(control, RobotMap.BTNX);
  Button btn_Y = new JoystickButton(control, RobotMap.BTNY);
  Button btn_Rb = new JoystickButton(control, RobotMap.BTNRB);
  Button btn_Lb = new JoystickButton(control, RobotMap.BTNLB);
  Button btn_7 = new JoystickButton(control, RobotMap.BTN7);
  Button btn_8 = new JoystickButton(control, RobotMap.BTN8);
  

  // Constructor clase
  public OI(){
    
    btn_A.whileHeld(new ElevadorAbajo());
    btn_B.whileHeld(new ElevadorArriba());
    btn_X.toggleWhenPressed(new panel_new());
    btn_Y.toggleWhenPressed(new arm());
    btn_Lb.whileHeld(new BallOut());
    btn_Rb.whileHeld(new BallIn());
  }

}
