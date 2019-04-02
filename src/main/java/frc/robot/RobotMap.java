/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.VictorSP;

public class RobotMap {

  // Puertos USB //

  public static final int JOY_PORT = 0;
  public static final int LAXIS_Y = 1;
  public static final int RAXIS_Y = 5;
  public static final int BTNA = 1;
  public static final int BTNX = 3;
  public static final int BTNY = 4;
  public static final int BTNB = 2;
  public static final int BTNR3 = 9;
  public static final int BTNLB = 5;
  public static final int BTNRB = 6;



  public static final int BTNLT = 2;
  public static final int BTNRT = 3;



  
  public static final int BTN7 = 7;
  public static final int BTN8 = 8;
  

  /* Definiciones de puertos utilizados */
  // Motores CAN //
  
  /*TalonSRX Chasis*/
  public static final int MOTCHASISD1 = 0;
  public static final int MOTCHASISD2 = 1;
  public static final int MOTCHASISI1 = 2;
  public static final int MOTCHASISI2 = 3;

  /*TalonSRX Elevador*/
  public static final int MOTELEVAD = 4;
  public static final int MOTELEVAI = 5;

  // Motores PWM //
  

  // DIO //

  /*Limit switches*/

  //Elevador
  public static final int ELEVAAR = 0;
  public static final int ELEVAAB = 1;



  // Electrovalvulas //
  public static final int ARRIBACHASIS_FORWARD = 0;
  public static final int ARRIBACHASIS_REVERSE = 1;
  public static final int SOLTAR_FORWARD = 2;
  public static final int SOLTAR_REVERSE = 3;
  public static final int INTAKE_PORT = 0;
	public static final int LIFT_MOTOR_PORT = 5;

  // CANifier
  public static final int LEDS = 0;

  //////////////////////////////////////////////////////////////////////////////////
  /* Definiciones de controladores y recursos utilizados*/
  
  // Chasis
  public static TalonSRX MotChasisD1;
  public static TalonSRX MotChasisD2;
  public static TalonSRX MotChasisI1;
  public static TalonSRX MotChasisI2;
  public static DoubleSolenoid ArribaChasis;
  public static PowerDistributionPanel pdp;
  public static Compressor Compresor;
  public static final double RampDrive = 0.2;

  // Intake
    
	/**************************************************/
	
	/********numeros de senales de PCM**************/

	/*****************intake**************/
	public static VictorSP intakeMotor;
	
  public static DoubleSolenoid piston1;
  public static DoubleSolenoid pistonC1;
  public static DoubleSolenoid pistonC2;

	

	//public static DigitalInput limitdown;
  public static DigitalInput limitup;
  public static DigitalInput limitdown;
  public static DigitalInput limitin;
  
	/*******************************************/
  
  
		
		/***********************************************/  

  // Elevador
  public static TalonSRX MotElevaD;
  public static TalonSRX MotElevaI;
  public static DigitalInput ElevaAr;
  public static DigitalInput ElevaAb;

  // Luces LED (CANifier)
  public static CANifier LEDs;
  public static DoubleSolenoid piston2;

  public static void resource_init(){
    // Recursos generales
    pdp = new PowerDistributionPanel();
    //Compresor = new Compressor(0);

    // Recursos chasis //
    MotChasisD1 = new TalonSRX(MOTCHASISD1);
    MotChasisD2 = new TalonSRX(MOTCHASISD2);
    MotChasisI1 = new TalonSRX(MOTCHASISI1);
    MotChasisI2 = new TalonSRX(MOTCHASISI2);
    ArribaChasis = new DoubleSolenoid(ARRIBACHASIS_FORWARD, ARRIBACHASIS_REVERSE);

    //Configuraciones de chasis //
    MotChasisD1.setInverted(true);
    MotChasisD2.setInverted(true);
    MotChasisI1.setInverted(false);
    MotChasisI2.setInverted(false);
    TalonConfig_Coast(MotChasisD1);
    TalonConfig_Coast(MotChasisD2);
    TalonConfig_Coast(MotChasisI1);
    TalonConfig_Coast(MotChasisI2);

    // Sensores de chasis //
    MotChasisD1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    MotChasisD1.setSensorPhase(true);
    MotChasisD1.setSelectedSensorPosition(0);

    MotChasisI1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    MotChasisI1.setSensorPhase(true);
    MotChasisI1.setSelectedSensorPosition(0, 0, 0);

    // Modo follow de motores
    MotChasisD2.follow(MotChasisD1);
    MotChasisI2.follow(MotChasisI1);

    // Recursos del elevador
    /*MotElevaD = new TalonSRX(MOTELEVAD);
    MotElevaI = new TalonSRX(MOTELEVAI);

    // Configuraciones del elevador
    MotElevaD.setInverted(true);
    MotElevaI.setInverted(false);
    TalonConfig_Brake(MotElevaD);
    TalonConfig_Brake(MotElevaI);

    MotElevaI.follow(MotElevaD);*/

    // Sensores de elevador
    //ElevaAr = new DigitalInput(ELEVAAR);
    //ElevaAb = new DigitalInput(ELEVAAB);

    //MotElevaD.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    //MotElevaD.setSensorPhase(true);
    //MotElevaD.setSelectedSensorPosition(0, 0, 0);

    // Recursos luces LEDs // 
    LEDs = new CANifier(LEDS);

    /********************intake******************/
    intakeMotor = new VictorSP(INTAKE_PORT);
    piston2 = new DoubleSolenoid(6, 7);
    piston1 = new DoubleSolenoid(4, 5);
  
  }

  /////////////////////////////////////////////////////////////////////////////////////////
  // Configuracion de talon en modo coast
  public static void TalonConfig_Coast(TalonSRX motor){
    
    motor.setNeutralMode(NeutralMode.Coast);            // Modo inercia libre
    motor.configClosedloopRamp(RampDrive, 0);           // Tiempo para llegar a maxima velocidad (Close loop)
    motor.configOpenloopRamp(RampDrive, 0);             // Tiempo para llegar a maxima velocidad (Open loop)
    motor.set(ControlMode.PercentOutput, 0);            // Envio de datos en porcentaje -1 a 1

  }

  // Configuracion de talon en modo brake
  public static void TalonConfig_Brake(TalonSRX motor){
    
    motor.setNeutralMode(NeutralMode.Brake);            // Modo inercia libre
    motor.configClosedloopRamp(RampDrive, 0);           // Tiempo para llegar a maxima velocidad (Close loop)
    motor.configOpenloopRamp(RampDrive, 0);             // Tiempo para llegar a maxima velocidad (Open loop)
    motor.set(ControlMode.PercentOutput, 0);            // Envio de datos en porcentaje -1 a 1
    
  }
}
