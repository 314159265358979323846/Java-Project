import javax.sound.sampled.*;
import java.io.*;
import java.net.*;

public class Music
{
	public Clip clip;
	public void play(URL src)
	{
		try
		{
			clip=AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(src));
			clip.start();
		}
		catch(LineUnavailableException | IOException | UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
	}
	public void play(String filename)
	{
		play(getClass().getResource("sound/"+filename));
	}
	public void stop()
	{
		clip.close();
	}
}
