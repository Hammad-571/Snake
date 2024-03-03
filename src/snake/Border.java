package snake;

public class Border 
{
	private final int width;
	private final int height;
	Border(int screenWidth, int screenHeight)
	{
		width = screenWidth;
		height =screenHeight;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}
