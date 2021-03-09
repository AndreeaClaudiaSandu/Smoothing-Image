public class CompClass {

    //limitarea unui numar intre o valoare minima si maxima
    public static float compN(float x, float a, float b) {
        return (x < a) ? a : (x > b) ? b : x;
    }

    public static int compN(int x, int a, int b) {
        return (x < a) ? a : (x > b) ? b : x;
    }

}
