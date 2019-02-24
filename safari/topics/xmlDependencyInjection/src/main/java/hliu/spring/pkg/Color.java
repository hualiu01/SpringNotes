package hliu.spring.pkg;

import java.util.Scanner;

public enum Color {
    GRAY(128,128, 128),
    WHITE(255,255,255),
    BLACK(0,0,0);

    private int r, b, g;

    /**
     * enum type constructor can not be protected or public. This implies a private method
     * @param red red value in rbg color
     * @param blue blue value in rbg color
     * @param green green value in rbg color
     */
    Color(int red, int green, int blue) {
        this.r = red;
        this.g = green;
        this.b = blue;
    }

    public String toHexString(Boolean withHashTag) {
        String hex = String.format("%02x%02x%02x",r,g,b);
        return withHashTag?"#"+hex:hex;
    }

    public Integer toRGB() {
        Integer bitsPerBase = 8;  // 8 bits for each color in R, G, B
        Double r_base = Math.pow(2,bitsPerBase*2);
        Double g_base = Math.pow(2,bitsPerBase);
        Double b_base = Math.pow(2,0);

        Double rgb = r_base*this.r + g_base*this.g + b_base*this.b;

        return rgb.intValue();
    }

    static public Color[] allColors() { return Color.values(); }
    static public void printAllColors() {
        for(Color c : allColors()) System.out.println(c.name());
    }

    public void run() {
        System.out.println("Input Integer: ");
        Scanner scanner = new Scanner(System.in);
        Integer i = scanner.nextInt();
    }
}
