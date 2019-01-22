package de.christianost.aida.sketch.processing;

class Calculations {
    private static int mapAccelerationToCoordinate(Operator operator, float size, float acceleration) {
        float ACCELERATION_MAX = 9.81;
        float step = size / (ACCELERATION_MAX * 2);
        float value = Math.abs(Operator.PLUS.equals(operator) ? acceleration + ACCELERATION_MAX : acceleration - ACCELERATION_MAX);

        return Math.round(step * value);
    }

    public static int mapXAccelerationToCoordinate(float width, float acceleration) {
        return Calculations.mapAccelerationToCoordinate(Operator.MINUS, width, acceleration);
    }

    public static int mapYAccelerationToCoordinate(float height, float acceleration) {
        return Calculations.mapAccelerationToCoordinate(Operator.PLUS, height, acceleration);
    }

}