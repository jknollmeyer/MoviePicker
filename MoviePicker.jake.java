import java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class MoviePicker{
	public class settings{
		//set in setting window the returned movie(s) MUST obey these criteria

		bool[] max_rating; /*true maxrating and up ratings  {G,PG,PG-13,R,NR,NC-17} */
		max_rating = new int[6];
		int earliest_release;
//    bool exclude_watchedlist; /* we'd have to include a watched list funtionality */
//    bool on_netflix;  /* we'd have to include an on netflix funtionality */
	} settingspane;

	public class movie{
		string title;
		int year
		string genre;
		Bufferedimage poster; // to set poster = ImageIO.read(new File("my.png"));
	} tonights_movie;

	public void initialfileopen(){
		/* we will always want these iMDb files open commented out not necessary to open
     if we get no user input pertaining to them */

		path genre_path = Path.get(./genre.list);
		InputStream genre = Files.newInputStream(genre_path);

		path mpaa_path = Path.get(./mpaa-ratings-reasons.list);
		InputStream mpaa = Files.newInputStream(mpaa_path);

		//path actors_path = Path.get(./actors.list);
		//InputStream actors = Files.newInputStream(actors_path

		//path directors_path = Path.get(./directors.list);
		//InputStream directors = Files.newInputStream(directors_path);

		//path runtime_path = Path.get(./running-times.list);
		//InputStream runtime = Files.newInputStream(runtime_path);
	}
	public class time{// a time class so user can just put in that they would like to watch a 2hr 30min movie at max
                // these inputs should be typed into a hrs and mins textbox and cast as type int
		int hrs;
		int mins;
		int totalmins = 60*hrs + mins;

		public time(){
			hrs = 24;
			mins = 0;
			totalmins = 60*hrs + mins;
		}

		public time(int hours; int minutes){
			hrs = hours;
			mins = minutes;
			totalmins = 60*hrs + mins;
		}

		public void sethrs(int hours){
			hrs = hours;
			totalmins = 60*hrs + mins;
		}

		public void setmins(int minutes){
			mins = minutes;
			totalmins = 60*hrs + mins;
		}
		public int getTotalmins(){
			return totalmins;
		}
	};
}
