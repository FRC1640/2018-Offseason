package frc.team1640.robot;

import java.util.HashMap;

import frc.team1640.utilities.Vector2;

public class SwerveController {

	public static final double W = 21.0;
	public static final double L = 27.25;

	public static enum SwerveMode {
		NORMAL,
		FIELD_CENTRIC,
		GYRO_CORRECTED;
	}

	SwerveMode swerveMode;
	HashMap<Pivot,Vector2> pivotMap;

	public SwerveController () {
		swerveMode = SwerveMode.NORMAL;
		pivotMap = new HashMap<Pivot,Vector2>();

		pivotMap.put(new Pivot("FL", new Vector2(-W,L).multiply(0.5), 13, 10, 0, 0.20019529200000002, 4.737548343, 0.0, false, false, false), null); // FL
		pivotMap.put(new Pivot("FR", new Vector2(W,L).multiply(0.5), 12, 9, 1, 0.20385740100000002, 4.729003422, 0.0, false, false, false), null); // FR
		pivotMap.put(new Pivot("BL", new Vector2(-W,-L).multiply(0.5), 2, 6, 2, 0.209960916, 4.742431155, 180.0, false, false, false), null); // BL
		pivotMap.put(new Pivot("BR", new Vector2(W,-L).multiply(0.5), 3, 7, 3, 0.205078104, 4.739989749, 180.0, false, false, false), null); // BR
	}

	public void setSwerveMode (SwerveMode sm) {
		swerveMode = sm;
	}

	public void drive (double x1, double y1, double x2) {

		// Clamp x1, y1, and x2 to be between -1 and 1
		// Really only matters for x2, since that can go over for gyro-correction
		x1 = Math.max(-1.0, Math.min(x1, 1.0));
		y1 = Math.max(-1.0, Math.min(y1, 1.0));
		x2 = Math.max(-1.0, Math.min(x2, 1.0));

		if (swerveMode != SwerveMode.NORMAL) { /* ERROR */ return; }

		Vector2 tVec = new Vector2(x1, y1);
		if (tVec.magnitude() < 0.03) { tVec.reset(); }

		if (Math.abs(x2) < 0.02) { x2 = 0.0; }

		double max = 0.0;
		for (Pivot piv : pivotMap.keySet()) {
			Vector2 vt = piv.position.copy().rotateD(-90.0).unitVector().multiply(x2).add(tVec);
			pivotMap.put(piv, vt);
			max = Math.max(max, vt.magnitude());
		}

		// TODO: Find a different normalization
		if (max > 1.0) {
			for (Pivot piv : pivotMap.keySet()) { pivotMap.get(piv).multiply(1.0/max); }
		}

		for (Pivot piv : pivotMap.keySet()) {
			Vector2 v = pivotMap.get(piv);
			piv.setSpeed(v.magnitude());
			piv.setTargetAngle(v.getAngle());
		}

	}

	public void disable () {
		for (Pivot piv : pivotMap.keySet()) {
			piv.disable();
		}
	}

	public void enable () {
		for (Pivot piv : pivotMap.keySet()) {
			piv.enable();
		}
	}

	public void setDriveRaw (double speed) {
		for (Pivot piv : pivotMap.keySet()) {
			piv.setSpeed(speed);
		}
	}

	public void setRotationRaw (double speed) {
		for (Pivot piv : pivotMap.keySet()) {
			piv.setRotationSpeed(speed);
		}
				
	}

	public HashMap<String,Double> getRawVoltages () {
		HashMap<String,Double> voltageMap = new HashMap<String,Double>();
		for (Pivot piv : pivotMap.keySet()) {

			String id = piv.getId();
			double voltage = piv.getRawVoltage();

			voltageMap.put(piv.getId(), piv.getRawVoltage());
		}
		return voltageMap;
	}

}