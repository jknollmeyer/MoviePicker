import "MoviePicker.java";

public class userinput{
	ArrayList<int> genre = new ArrayList<>();

	    /* dynamic Vector of ints corresponding genre below:
     Short   1
     Drama   2
     Comedy  3
     Documentary 4
     Adult   5
     Action  6
     Romance 7
     Thriller    8
     Animation   9
     Family  10
     Horror  11
     Crime   12
     Music   13
     Adventure   14
     Fantasy 15
     Sci-Fi  16
     Mystery 17
     Biography   18
     History 19
     Sport   20
     Musical 21
     War 22
     Western 23
     */

     boolean animated; //yes 1, no 0, don't care 1 from pull down menu
     ArrayList<string> actors = new ArrayList<>();
     ArrayList<string> directors = new ArrayList<>();
     time runtime = time();

     boolean[] whatinputs;
     whatinputs = new boolean[5]; // vector tells what this particular user chose to input (hours and mins considered one input here)
    //{genre,animated,actors,directors,runtime}

     public userinput(){	//null constructor
     	for (int i = 0; i < 2; i++){
     		genre[i] = 0
     	}
     	genre[3] = 1; // sets default genre to comedy

     	for (int i = 3; i < 23; i++){ // default null input is only comedy
     		genre[i] = 0;
     	}

     	animated = true;
     	runtime = time();
     	whatinputs = {1,1,0,0,1}; // null constructor has everything but actors and directors
     }

     public void setGenre(){
     	boolean next_button = 0;
     	int genre_button_number; // each time a user presses a button should set this to genre number
     	while (!next_button){	// keeps adding genres as user selects til user presses next
     		genre.add(genre_button_number);
     	}
     }

     public void setAnimated(bool want_animated){ // should be called when user says if they want an animated film
     	animated = want_animated;
     }
/*
     public void setActors(){
     	boolean next_button = 0;
     	string userTypedActor; // each time a user types an actor name should be written to this
     	while (!next_button){	// keeps adding actors as user types til user presses next
     		actors.add(userTypedActor);
     	}
     }

   	 public void setDirectors(){
     	boolean next_button = 0;
     	string userTypedDirector; // each time a user types an actor name should be written to this
     	while (!next_button){	// keeps adding actors as user types til user presses next
     		directors.add(userTypedDirector);
     	}
     }
*/
     public void setRuntime(int hours; int minutes){
     	runtime.sethrs(hours);
     	runtime.setmins(minutes);
     }

     public ArrayList<int> getGenre(){
     	return genre;
     }

     public boolean getAnimated(){
     	return animated;
     }

     public ArrayList<string> getActors(){
     	return actors;
     }

     public ArrayList<string> getDirectors(){
     	return directors;
     }

     public time getRuntime(){
     	return runtime;
     }
}
