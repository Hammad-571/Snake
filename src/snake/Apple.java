package snake;

import java.util.Random;

public class Apple {
	private static int applesEaten = -1;		//how many times i have eaten the apple
	private int appleX;							//x coordinates of apple
	private int appleY;							//y coordinates of apple
	
	Apple(int SCREEN_WIDTH, int SCREEN_HEIGHT, int UNIT_SIZE )
	{
		Random random = new Random();
		//choose random x and y for apple
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
		applesEaten ++;
	}

	public int getApplesEaten() {
		return applesEaten;
	}

	public int getAppleX() {
		return appleX;
	}

	public int getAppleY() {
		return appleY;
	}
	
}
