public class Sound extends Music
{
	private static final Sound SOUND=new Sound();
	private Sound() {}
	public static Sound getInstance()
	{
		return SOUND;
	}
}
